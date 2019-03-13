package com.athensoft.content.event.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athensoft.content.event.entity.EventMedia;
import com.athensoft.content.event.service.EventMediaService;

import lombok.extern.log4j.Log4j;


/**
 * The controller of file uploading
 * @author Athens
 *
 */
@Controller
@Log4j
public class FileUploadAcpController {
	
	public static final int BUF_SIZE = 2 * 1024;
	
	private static final String RESP_SUCCESS = "{\"jsonrpc\" : \"2.0\", \"result\" : \"OK\", \"id\" : \"id\"}";
	private static final String RESP_ERROR = "{\"jsonrpc\" : \"2.0\", \"error\" : {\"code\": 101, \"message\": \"Failed to open input stream.\"}, \"id\" : \"id\"}";
	
	private int chunk;
	private int chunks;
	private String name;
	private String user;
	private String time;

	@Autowired
	private EventMediaService eventMediaService;
	
	/**
	 * upload files
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/events/fileUpload",produces="application/json")
	@ResponseBody
	public Map<String,Object> fileUpload(HttpServletRequest req){
		log.info("entering /events/fileUpload");
		
		//parameter
		String eventUUID = (String)req.getParameter("eventUUID");
		log.info("eventUUID="+eventUUID);
		
		String responseString = RESP_SUCCESS;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		log.info("isMultipart:" + isMultipart);
		
		if(isMultipart){
			ServletFileUpload upload = new ServletFileUpload();
			try {
				FileItemIterator iter = upload.getItemIterator(req);
				while (iter.hasNext()) {
				    FileItemStream item = iter.next();
				    InputStream input = item.openStream();
				    
				    // Handle a form field.
				    if(item.isFormField()){
				        String fileName = item.getFieldName();
				        String value = Streams.asString(input);

				        if("name".equals(fileName)){
				        	this.name = value;
				        }
				        else if("chunks".equals(fileName)){
				        	this.chunks = Integer.parseInt(value);
				        }else if("chunk".equals(fileName)){
				        	this.chunk = Integer.parseInt(value);
				        }else if("user".equals(fileName)){
				        	this.user = value;
				        }else if("time".equals(fileName)){
				        	this.time = value;
				        }
				        log.info("name:" + this.name);
				        log.info("chunks:" + this.chunks);
				        log.info("chunk:" + this.chunk);
				        log.info("user:" + this.user);
				        log.info("time:" + this.time);
				    }
				    
				    // Handle a multi-part MIME encoded file.
				    else {
//				    	String fileDir = req.getSession().getServletContext().getRealPath("/")+FileDir;
				    	
//				    	String fileDir = FileDir;	//FIXME //TODO
				    	String fileDir = getFileBaseDir(getLoadedProperties());	//FIXME //TODO
						
				    	File dstFile = new File(fileDir);
						if (!dstFile.exists()){
							dstFile.mkdirs();
						}
						
						File dst = new File(dstFile.getPath()+ "/" + this.name);
						
						log.info("fileDir:" + fileDir);
						log.info("fileName:" + this.name);
						
				        saveUploadFile(input, dst);
				    }
				}
			}
			catch (Exception e) {
				responseString = RESP_ERROR;
				e.printStackTrace();
			}
		}
		
		// Not a multi-part MIME request.
		else {
			responseString = RESP_ERROR;
		}
		
		log.info("responseString:" + responseString);
		
		ModelAndView mav = new ModelAndView();
		
		//view
		String viewName = "events/event_news_edit";
		mav.setViewName(viewName);
		
		//data
		Map<String, Object> model = mav.getModel();
		
		model.put("jsonrpc", "2.0");
		model.put("result", "OK");
		model.put("id", "id");
		
		log.info("leaving /events/fileUpload");
		return model;
	}
	
	
	/**
	 * upload files and then create corresponding records
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/events/fileUploadAndCreateRecord",produces="application/json")
	@ResponseBody
	public Map<String,Object> fileUploadAndCreateRecord(HttpServletRequest req){
		
		log.info("entering /events/fileUploadAndCreateRecord");
		
		//parameter
		String eventUUID = (String)req.getParameter("eventUUID");
		log.info("eventUUID="+eventUUID);
		
		
		String responseString = RESP_SUCCESS;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		log.info("isMultipart:" + isMultipart);
		
		if(isMultipart){
			ServletFileUpload upload = new ServletFileUpload();
			try {
				FileItemIterator iter = upload.getItemIterator(req);
				while (iter.hasNext()) {
				    FileItemStream item = iter.next();
				    InputStream input = item.openStream();
				    
				    // Handle a form field.
				    if(item.isFormField()){
				        String fileName = item.getFieldName();
				        String value = Streams.asString(input);

				        if("name".equals(fileName)){
				        	this.name = value;
				        }
				        else if("chunks".equals(fileName)){
				        	this.chunks = Integer.parseInt(value);
				        }else if("chunk".equals(fileName)){
				        	this.chunk = Integer.parseInt(value);
				        }else if("user".equals(fileName)){
				        	this.user = value;
				        }else if("time".equals(fileName)){
				        	this.time = value;
				        }
				        log.info("name:" + this.name);
				        log.info("chunks:" + this.chunks);
				        log.info("chunk:" + this.chunk);
				        log.info("user:" + this.user);
				        log.info("time:" + this.time);
				    }
				    
				    // Handle a multi-part MIME encoded file.
				    else {
//				    	String fileDir = req.getSession().getServletContext().getRealPath("/")+FileDir;
				    	
				    	String fileDir = getFileBaseDir(getLoadedProperties())+File.separator+eventUUID;
//						
				    	File dstFile = new File(fileDir);
						if (!dstFile.exists()){
							dstFile.mkdirs();
						}
						File dst = new File(dstFile.getPath()+ "/" + this.name);
						
						log.info("fileDir:" + fileDir);
						log.info("fileName:" + this.name);
						
				        saveUploadFile(input, dst);
				        
//				        String mediaURL = fileDir+File.separator+this.name;
				        
				        // persist media record into database
				        log.info("Start creating event media - Name:" + this.name);
				        EventMedia eventMedia = new EventMedia();
				        eventMedia.setEventUUID(eventUUID);
				        eventMedia.setMediaName(this.name);
				        eventMedia.setMediaLabel(this.name);
//				        String filePath = ImgBaseUrl+"/"+eventUUID+"/";	//FIXME //TODO
				        String filePath = getFileBaseUrl(getLoadedProperties())+"/"+eventUUID+"/";	//FIXME //TODO
				        eventMedia.setMediaURL(filePath);
				        eventMedia.setPrimaryMedia(false);
				        eventMedia.setPostTimestamp(new Date());
				        
				        eventMediaService.creatEventMedia(eventMedia);
				    }
				}//end-of-while-loop
			}
			catch (Exception e) {
				responseString = RESP_ERROR;
				e.printStackTrace();
			}
		}
		
		// Not a multi-part MIME request.
		else {
			responseString = RESP_ERROR;
		}
		
		log.info("responseString:" + responseString);
		
		ModelAndView mav = new ModelAndView();
		Map<String, Object> model = mav.getModel();
		model.put("jsonrpc", "2.0");
		model.put("result", "OK");
		model.put("id", "id");
		
		String viewName = "events/event_news_edit";
		mav.setViewName(viewName);
		
		log.info("leaving /events/fileUploadAndCreateRecord");
		return model;
	}


	/**
	 * @param input
	 * @param dst
	 * @throws IOException
	 */
	private void saveUploadFile(InputStream input, File dst) throws IOException {
		OutputStream out = null;
		try {
			if (dst.exists()) {
				out = new BufferedOutputStream(new FileOutputStream(dst, true), BUF_SIZE);
			} else {
				out = new BufferedOutputStream(new FileOutputStream(dst), BUF_SIZE);
			}

			byte[] buffer = new byte[BUF_SIZE];
			int len = 0;
			while ((len = input.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != input) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	private static String getFileBaseDir(Properties pro) {
		/* property: docBase of photo at server side */
		String path = pro.getProperty("file.photo.docbase");
		log.info("image base path in file system=" + path);
		return path;
	}

	private static String getFileBaseUrl(Properties pro) {
		/* property: docBase of photo at server side */
		String path = pro.getProperty("file.photo.baseurl");
		log.info("image base url =" + path);
		return path;
	}

	private static Properties getLoadedProperties() {
		Properties pro = new Properties();
		
		/* get the docbase of uploading photos */
		InputStream is = FileUploadAcpController.class.getResourceAsStream("file-upload-event.properties");
		try {
			pro.load(is);
			is.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return pro;
	}
}
