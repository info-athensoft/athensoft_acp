package com.athensoft.school.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.athensoft.school.dao.SchoolClassDao;
import com.athensoft.school.entity.SchoolClass;
import com.athensoft.school.entity.SchoolClassAction;
import com.athensoft.school.entity.SchoolClassStatus;
import com.athensoft.school.entity.SchoolClassType;

@Service
public class SchoolClassService {
	
	@Autowired
	@Qualifier("schoolClassDaoJdbcImpl")
	private SchoolClassDao schoolClassDao;
	
	public List<SchoolClass> getAllClasses(){
		return schoolClassDao.findAll();
	}
	
	public SchoolClass getSchoolClassByClassCode(String classCode){
		return schoolClassDao.findByClassCode(classCode);
	}
	
	public void createSchoolClass(SchoolClass schoolClass){
		this.schoolClassDao.create(schoolClass);
		return;
	}
	
	
	/**
	 * @param listSchoolClass
	 * @param action - School Action
	 * @return
	 */
	public String[][] getData(List<SchoolClass> listSchoolClass, String action){
		int entryLength = listSchoolClass.size();
		final int COLUMN_NUM = 9;
		String[][] data = new String[entryLength][COLUMN_NUM];

		String field0 = ""; // check box
		String field1 = ""; // class code
		String field2 = ""; // class type
		String field3 = ""; // class name		
		String field4 = ""; // class owner
		String field5 = ""; // create date
		String field6 = ""; // max person number
		String field7 = ""; // class status
		String field8 = ""; // action

		for (int i = 0; i < entryLength; i++) {
			field0 = "<input type='checkbox' name='id[]' value=" + listSchoolClass.get(i).getClassCode() + ">";
			field1 = listSchoolClass.get(i).getClassCode() + "";
			
			//field2 = listSchoolClass.get(i).getClassType();
			String strClassType = (listSchoolClass.get(i).getClassType())+"";
			field2 = getSchoolClassType(strClassType);
			
			field3 = listSchoolClass.get(i).getClassName();
			field4 = listSchoolClass.get(i).getClassOwner();
			
			final String DATE_FORMAT = "yyyy-MM-dd";
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
			field5 = listSchoolClass.get(i).getCreateDate().format(formatter) + "";
			
			field6 = listSchoolClass.get(i).getMaxPerson() + "";

			int intClassStatus = listSchoolClass.get(i).getClassStatus();
			String[] classStatusPair = getClassStatusPair(intClassStatus);
			String classStatusKey = classStatusPair[0];
			String classStatus = classStatusPair[1];
			field7 = "<span class='label label-sm label-" + classStatusKey + "'>" + classStatus + "</span>";
			field8 = "<a href='" + getActionUrl(action) + "?classCode=" + field1
					+ "' class='btn btn-xs default btn-editable'><i class='fa fa-pencil'></i> " + getActionName(action) + "</a>";

			// log.info("field8="+field8);

			data[i][0] = field0;
			data[i][1] = field1;
			data[i][2] = field2;
			data[i][3] = field3;
			data[i][4] = field4;
			data[i][5] = field5;
			data[i][6] = field6;
			data[i][7] = field7;
			data[i][8] = field8;
		}

		return data;
	}
	
	public String getSchoolClassType(String strSchoolClassType) {

		int intEntityClass = Integer.parseInt(strSchoolClassType);
		String entityClass = "";
		switch (intEntityClass) {
		case SchoolClassType.ADULT:
			entityClass = "����";
			break;
		case SchoolClassType.CHILD:
			entityClass = "δ������";
			break;
		default:
			entityClass = "����";
			break;
		}
		return entityClass;
	}
	
	public String[] getClassStatusPair(int intEntityStatus) {
		String[] entityStatusPair = new String[2];

		String entityStatus = "";
		String entityStatusKey = "";
		switch (intEntityStatus) {
		case SchoolClassStatus.CREATED:
			entityStatus = "�Ѵ���";
			entityStatusKey = "info";
			break;
		case SchoolClassStatus.OPENING:
			entityStatus = "������";
			entityStatusKey = "warning";
			break;
		case SchoolClassStatus.ACTIVE:
			entityStatus = "������";
			entityStatusKey = "success";
			break;
		case SchoolClassStatus.CLOSED:
			entityStatus = "�ѽ�ҵ";
			entityStatusKey = "default";
			break;
		case SchoolClassStatus.DISMISSED:
			entityStatus = "�ѽ�ɢ";
			entityStatusKey = "danger";
			break;
		default:
			entityStatus = "δ֪״̬";
			entityStatusKey = "default";
			break;
		}

		entityStatusPair[0] = entityStatusKey;
		entityStatusPair[1] = entityStatus;

		return entityStatusPair;
	}
	
	public String getActionUrl(String action) {
		final String actionURLPrefix="/acp/school/class/";
		String actionUrl = "";
		switch (action) {
		case SchoolClassAction.EDIT:
			actionUrl = actionURLPrefix+"edit.html";
			break;
		case SchoolClassAction.DELETE:
			actionUrl = actionURLPrefix+"delete.html";
			break;
		}
		return actionUrl;
	}
	
	public String getActionName(String action){
		String actionName = "";
		switch(action){
			case SchoolClassAction.VIEW:
				actionName = "�鿴";	//Button Name - view
				break;
			case SchoolClassAction.EDIT:
				actionName = "�༭";	//Button Name - edit
				break;
			case SchoolClassAction.DELETE:
				actionName = "ɾ��";	//Button Name - delete
				break;
			case SchoolClassAction.MANAGE:
				actionName = "����";	//Button Name - view
				break;
			default:
				actionName = "δ����";
		}
		return actionName;
	}
}
