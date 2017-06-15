/** event_news_edit.jsp */

/* edit news - init */
var EventNewsEdit = function (option) {

    var handleImages = function(option) {

        // see http://www.plupload.com/
        var uploader = new plupload.Uploader({
            runtimes : 'html5,flash,silverlight,html4',
             
            browse_button : document.getElementById('tab_images_uploader_pickfiles'), // you can pass in id...
            container: document.getElementById('tab_images_uploader_container'), // ... or DOM Element itself
             
            //url : "http://localhost:8080/acp/events/fileUpload", //TODO: Change to relative url
            url : "", //TODO: Change to relative url
             
            filters : {
                max_file_size : '10mb',
                mime_types: [
                    {title : "Image files", extensions : "jpg,gif,png"},
                    {title : "Zip files", extensions : "zip"}
                ]
            },
         
            // Flash settings
            flash_swf_url : 'assets/plugins/plupload/js/Moxie.swf',
     
            // Silverlight settings
            silverlight_xap_url : 'assets/plugins/plupload/js/Moxie.xap',             
         
            init: {
                PostInit: function() {
                    $('#tab_images_uploader_filelist').html("");
         
                    $('#tab_images_uploader_uploadfiles').click(function() {
                        uploader.start();
                        return false;
                    });

                    $('#tab_images_uploader_filelist').on('click', '.added-files .remove', function(){
                        uploader.removeFile($(this).parent('.added-files').attr("id"));    
                        $(this).parent('.added-files').remove();                     
                    });
                },
         
                FilesAdded: function(up, files) {
                    plupload.each(files, function(file) {
                        $('#tab_images_uploader_filelist').append('<div class="alert alert-warning added-files" id="uploaded_file_' + file.id + '">' + file.name + '(' + plupload.formatSize(file.size) + ') <span class="status label label-info"></span>&nbsp;<a href="javascript:;" style="margin-top:-5px" class="remove pull-right btn btn-sm red"><i class="fa fa-times"></i> remove</a></div>');
                    });
                },
         
                UploadProgress: function(up, file) {
                    $('#uploaded_file_' + file.id + ' > .status').html(file.percent + '%');
                },

                FileUploaded: function(up, file, response) {
                    var response = $.parseJSON(response.response);

                    if (response.result && response.result == 'OK') {
                    	alert(file.id);
                        var id = response.id; // uploaded file's unique name. Here you can collect uploaded file names and submit an jax request to your server side script to process the uploaded files and update the images tabke

                        $('#uploaded_file_' + file.id + ' > .status').removeClass("label-info").addClass("label-success").html('<i class="fa fa-check"></i> Done'); // set successfull upload
                        
                        //create media record to database
                        
                        
                        
                    } else {
                        $('#uploaded_file_' + file.id + ' > .status').removeClass("label-info").addClass("label-danger").html('<i class="fa fa-warning"></i> Failed'); // set failed upload
                        Metronic.alert({type: 'danger', message: 'One of uploads failed. Please retry.', closeInSeconds: 10, icon: 'warning'});
                    }
                },
         
                Error: function(up, err) {
                    Metronic.alert({type: 'danger', message: err.message, closeInSeconds: 10, icon: 'warning'});
                },
                
                UploadComplete: function(){
                	var eventUUID = option;
                	//refresh tab_images when uploading done
                	reloadEventMedia(eventUUID);
                	
                }
            }
        });

        
        uploader.setOption('url','/acp/events/fileUploadAndCreateRecord?eventUUID='+option);
        uploader.init();

    }

    var handleReviews = function () {
    	
    	var eventUUID = $("#eventUUID").val();
//    	console.log("eventUUID="+eventUUID);
    	
        var grid = new Datatable();

        grid.init({
            src: $("#datatable_reviews"),
            onSuccess: function (grid) {
                // execute some code after table records loaded
            },
            onError: function (grid) {
                // execute some code on network or other general error  
            },
            loadingMessage: 'Loading...',
            dataTable: { // here you can define a typical datatable settings from http://datatables.net/usage/options 

                // Uncomment below line("dom" parameter) to fix the dropdown overflow issue in the datatable cells. The default datatable layout
                // setup uses scrollable div(table-scrollable) with overflow:auto to enable vertical scroll(see: assets/global/scripts/datatable.js). 
                // So when dropdowns used the scrollable div should be removed. 
                //"dom": "<'row'<'col-md-8 col-sm-12'pli><'col-md-4 col-sm-12'<'table-group-actions pull-right'>>r>t<'row'<'col-md-8 col-sm-12'pli><'col-md-4 col-sm-12'>>",

                "lengthMenu": [
                    [10, 20, 50, 100, 150, -1],
                    [10, 20, 50, 100, 150, "All"] // change per page values here
                ],
                "pageLength": 10, // default record count per page
                "ajax": {
                    //"url": "/acp/events/eventsNewsReviewListData?eventUUID="+eventUUID, // ajax source
                	"url": "/acp/events/eventsNewsReviewListData", // ajax source
                	"data":{
                	    "eventUUID": eventUUID
                	}
                },
                "columnDefs": [{ // define columns sorting options(by default all columns are sortable extept the first checkbox column)
                    'orderable': true,
                    'targets': [0]
                }],
                "order": [
                    [0, "asc"]
                ] // set first column as a default sort by asc
            }
        });
    }

    var handleHistory = function () {

        var grid = new Datatable();

        grid.init({
            src: $("#datatable_history"),
            onSuccess: function (grid) {
                // execute some code after table records loaded
            },
            onError: function (grid) {
                // execute some code on network or other general error  
            },
            loadingMessage: 'Loading...',
            dataTable: { // here you can define a typical datatable settings from http://datatables.net/usage/options 
                "lengthMenu": [
                    [10, 20, 50, 100, 150, -1],
                    [10, 20, 50, 100, 150, "All"] // change per page values here
                ],
                "pageLength": 10, // default record count per page
                "ajax": {
                    "url": "demo/ecommerce_product_history.php", // ajax source
                },
                "columnDefs": [{ // define columns sorting options(by default all columns are sortable extept the first checkbox column)
                    'orderable': true,
                    'targets': [0]
                }],
                "order": [
                    [0, "asc"]
                ] // set first column as a default sort by asc
            }
        });
    } 

    var initComponents = function () {
        //init datepickers
        $('.date-picker').datepicker({
            rtl: App.isRTL(),		//modified by Athens
            autoclose: true
        });

        //init datetimepickers
        $(".datetime-picker").datetimepicker({
            isRTL: App.isRTL(),		//modified by Athens
            autoclose: true,
            todayBtn: true,
            pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left"),
            minuteStep: 10
        });

        //init maxlength handler
        $('.maxlength-handler').maxlength({
            limitReachedClass: "label label-danger",
            alwaysShow: true,
            threshold: 5
        });
    }

    return {

        //main function to initiate the module
        init: function (option) {
            initComponents();

            handleImages(option);
            handleReviews();
            //handleHistory();
        }

    };

}();


/*edit news - button:back */
function backToNewsList(){
	location.href = "/acp/events/eventsNewsList";
}


/* event news - button:save change,update */
function updateNews() {
    
    var businessObject = getBusinessObject();
    //alert(JSON.stringify(businessObject));
	
    //execute saving
    $.ajax({
        type    :    "post",
        url        : "updateNews?itemJSONString="+JSON.stringify(businessObject),
        dataType:    "html",
        timeout :     30000,
        
        success:function(msg){
            location.href="eventsNewsList";
        },
        error:function(){
            alert("ERROR: News updating failed.");     
        },            
        complete: function(XMLHttpRequest, textStatus){
            //reset to avoid duplication
        }        
    });
}


/*edit news - button:save and continue */
function updateNewsAndContinue() {
	//alert("Entered updateNewsAndContinue successfully."); 
    var businessObject = getBusinessObject();	//refer to event-news-edit.js
    //alert(JSON.stringify(businessObject));
	
    //execute saving
    $.ajax({
        type    :    "post",
        url        : "updateNews?itemJSONString="+JSON.stringify(businessObject),
        dataType:    "html",
        timeout :     30000,
        
        success:function(msg){
        	//alert("News updated successfully."); 
        },
        error:function(){
            alert("ERROR: News updating failed.");     
        },            
        complete: function(XMLHttpRequest, textStatus){
            //reset to avoid duplication
        }        
    });
}


/*edit news - button:mark deleted */
function markNewsStatusDeleted(eventUUID) {
	//alert('entered markNewsStatusDeleted');
   
    $.ajax({
        type    :    "post",
        url        : "markNewsStatusDeleted?eventUUID="+eventUUID,
        dataType:    "html",
        timeout :     30000,
        
        success:function(msg){
//            //update deleted status
        	//alert('update deleted status successfully.');
        },
        error:function(xhr, status, error){
//            alert("ERROR: Sort Number updating failed."); 
//        	  alert(xhr.responseText);
        },            
        complete: function(XMLHttpRequest, textStatus){
        	//alert('update deleted status completed.');
        	$("#eventStatus").val(3);
        }        
    });
}


/*edit news - tab:images */
function setCoverMedia(mediaId, eventUUID) {
	//alert('ENTERING setCoverMedia='+mediaId+"    "+eventUUID);
//    var businessObject = getBusinessObject();
//    alert(JSON.stringify(businessObject));
	
    $.ajax({
        type    :    "post",
        url        : "setCoverMedia?mediaId="+mediaId+"&eventUUID="+eventUUID,
        dataType:    "json",
        timeout :     30000,
        
        success:function(msg){
        	
        	var t = $("#tabs_event");
        	//alert("tab is "+t);
        	t.tabs({"active":2});
        	
        	//$("#tabs_event").tabs({ active: 2 });
        	var mydata = msg.eventMediaList;
        	//alert(data);
        	
        	
        	var str = '<table class="table table-bordered table-hover" id="event-media-table"><thead>'
					+ '<tr role="row" class="heading">'
					+ '<th width="8%">Image</th>'
					+ '<th width="20%">Label</th>'
					+ '<th width="8%">Sort Number</th>'
					+ '<th width="15%">Post Time</th>'
					+ '<th width="10%">Primary Media</th>'
					+ '<th width="10%">Action</th></tr>'
					+ '</thead><tbody>';
			
		    for(var index in mydata){
				var i = index;
				
				str = str+ '<tr>'
				+'<td><a href="'+mydata[i].mediaURL+'" class="fancybox-button" data-rel="fancybox-button">'
				+	'<img class="img-responsive" src="'+mydata[i].mediaURL+'" alt=""></a></td>'
				+'<td><input type="text" class="form-control" name="mediaName" value="'+mydata[i].mediaName+'"></td>'
				+'<td><input type="text" class="form-control" name="sortNumber" value="'+mydata[i].sortNumber+'"></td>'
				+'<td><input type="text" class="form-control" name="postTimestamp" value="'+mydata[i].postTimestamp+'"></td>'
				+'<td><input type="text" class="form-control" name="primaryMedia" value="'+mydata[i].primaryMedia+'" disabled="disabled"><div><a href="javascript:;" onclick="setCoverMedia('+mydata[i].mediaId+',\''+mydata[i].eventUUID+'\');return false;" class="btn default btn-sm"><i class="fa fa-edit"></i> Set Cover </a></div></td>'
				+'<td><a href="javascript:;" class="btn default btn-sm"><i class="fa fa-times"></i> Remove </a></td>'
				+'</tr>';
			}
			    
			str = str + '</tbody></table>';
			$("#event-media-table").html(str);
			//alert(str);
        },
        error:function(){
            alert("ERROR: Set Cover Media failed.");     
        },            
        complete: function(XMLHttpRequest, textStatus){
        	location.reload();
        	//var t = $("#tabs_event");
        	//t.tabs({"active":2});
        }        
    });   
}


/*edit news - tab:images */
function reloadEventMedia(eventUUID){
	$.ajax({
        type    :    "post",
        url        : "reloadEventMedia?eventUUID="+eventUUID,
        dataType:    "json",
        timeout :     30000,
        
        success:function(msg){
        	
        	var t = $("#tabs_event").tabs({active:2});
        	
        	//$("#tabs_event").tabs({ active: 2 });
        	var mydata = msg.eventMediaList;
        	//alert(data);
        	
        	
        	var str = '<table class="table table-bordered table-hover"><thead>'
					+ '<tr role="row" class="heading">'
					+ '<th width="8%">Image</th>'
					+ '<th width="20%">Label</th>'
					+ '<th width="8%">Sort Number</th>'
					+ '<th width="15%">Post Time</th>'
					+ '<th width="10%">Primary Media</th>'
					+ '<th width="10%">Action</th></tr>'
					+ '</thead><tbody>';
			
		    for(var index in mydata){
				var i = index;
				
				str = str+ '<tr>'
				+'<td><a href="/acp/assets/admin/pages/media/works/img1.jpg" class="fancybox-button" data-rel="fancybox-button">'
				+	'<img class="img-responsive" src="/acp/assets/admin/pages/media/works/img1.jpg" alt=""></a></td>'
				+'<td><input type="text" class="form-control" name="mediaName" value="'+mydata[i].mediaName+'"></td>'
				+'<td><input type="text" class="form-control" name="sortNumber" value="'+mydata[i].sortNumber+'"></td>'
				+'<td><input type="text" class="form-control" name="postTimestamp" value="'+mydata[i].postTimestamp+'"></td>'
				+'<td><input type="text" class="form-control" name="primaryMedia" value="'+mydata[i].primaryMedia+'" disabled="disabled"><div><a href="javascript:;" onclick="setCoverMedia('+mydata[i].mediaId+',\''+mydata[i].eventUUID+'\');return false;" class="btn default btn-sm"><i class="fa fa-edit"></i> Set Cover </a></div></td>'
				+'<td><a href="javascript:;" class="btn default btn-sm"><i class="fa fa-times"></i> Remove </a></td>'
				+'</tr>';
			}
			    
			str = str + '</tbody></table>';
			$("#event-media-table").html(str);
			//alert(str);
        },
        error:function(){
            alert("ERROR: Reload Media failed.");     
        },            
        complete: function(XMLHttpRequest, textStatus){
        	
        }        
    });
}


/*edit news - tab:images */
function changeMediaName(object,mediaId,eventUUID) {
	//alert(object);
	var mediaName = object.value;

	var mediaObject =
    {
			mediaId    :    mediaId,
			eventUUID  :    eventUUID,
			mediaName :    mediaName
    };
   
    $.ajax({
        type    :    "post",
        url        : "changeMediaName?itemJSONString="+JSON.stringify(mediaObject),
        dataType:    "json",
        timeout :     30000,
        
        success:function(msg){
//            location.href="";
        },
        error:function(xhr, status, error){
//            alert("ERROR: Sort Number updating failed."); 
//        	  alert(xhr.responseText);
        },            
        complete: function(XMLHttpRequest, textStatus){
            //reset to avoid duplication
        }        
    });
}


/*edit news - tab:images */
function changeMediaLabel(object,mediaId,eventUUID) {
	//alert(object);
	var mediaLabel = object.value;

	var mediaObject =
    {
			mediaId    :    mediaId,
			eventUUID  :    eventUUID,
			mediaLabel :    mediaLabel
    };
   
    $.ajax({
        type    :    "post",
        url        : "changeMediaLabel?itemJSONString="+JSON.stringify(mediaObject),
        dataType:    "json",
        timeout :     30000,
        
        success:function(msg){
//            location.href="";
        },
        error:function(xhr, status, error){
//            alert("ERROR: Sort Number updating failed."); 
//        	  alert(xhr.responseText);
        },            
        complete: function(XMLHttpRequest, textStatus){
            //reset to avoid duplication
        }        
    });
}


/*edit news - tab:images */
function changeSortNumber(object,mediaId,eventUUID) {
	//alert(object);
	var sortNumber = object.value;
//    alert("sortNumber="+sortNumber+", mediaId="+mediaId+", eventUUID="+eventUUID);
	var mediaObject =
    {
			mediaId    :    mediaId,
			eventUUID  :    eventUUID,
			sortNumber :    sortNumber
    };
   
    $.ajax({
        type    :    "post",
//        url        : "changeSortNumber?mediaId="+mediaId+"&eventUUID="+eventUUID+"&sortNumber="+sortNumber,
        url        : "changeSortNumber?itemJSONString="+JSON.stringify(mediaObject),
        dataType:    "json",
        timeout :     30000,
        
        success:function(msg){
//            location.href="";
        },
        error:function(xhr, status, error){
//            alert("ERROR: Sort Number updating failed."); 
//        	  alert(xhr.responseText);
        },            
        complete: function(XMLHttpRequest, textStatus){
            //reset to avoid duplication
        }        
    });
}


/*edit news - tab:reviews */
function filterSearchReview(){
	
//	alert("do filterSearchReview()");

	//	create a json object
    var p1 = $("#event_review_no").val();
    var p2a = $("#event_review_date_from").val();
    var p2b = $("#event_review_date_to").val();
    var p3 = $("#event_review_customer").val();
    var p4 = $("#event_review_content").val();
    var p5 = $("#event_review_status").val();

//    alert(p2a+"---"+p2b+"  p5="+p5);
    
//	validate
    /*
	if(!isNonNegativeInteger(p6a)){
		p6a = "";
		$("#viewNumFrom").val("");
	}
	if(!isNonNegativeInteger(p6b)){
		p6b = "";
		$("#viewNumTo").val("");
	}*/
  
    var eventReviewObject =
    {
    		eventReviewNo		:	p1,
    		eventReviewDateFrom	:   p2a,
    		eventReviewDateTo	:   p2b,
    		eventReviewCustomer	:   p3,
    		eventReviewContent	:   p4,
    		eventReviewStatus	:   p5
    };

    var dt = $("#datatable_reviews").DataTable();
    
    var x = dt.ajax.url("newsReviewSearchFilterData?itemJSONString="+JSON.stringify(eventReviewObject)).load();
    
    
}
