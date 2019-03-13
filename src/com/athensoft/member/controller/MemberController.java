package com.athensoft.member.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athensoft.member.entity.Member;
import com.athensoft.member.entity.MemberStatus;
import com.athensoft.member.service.MemberService;
import com.athensoft.util.time.DatetimeHelper;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@Log4j
public class MemberController {

	private static final String ACTION_EDIT = "����";
	private static final String ACTION_DELETE = "ɾ��";

	private MemberService memberService;

	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/list.html")
	public String gotoMemberList() {
		return "member/member_list";
	}

	@RequestMapping(value = "/list", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getDataMemberList() {
		log.info("entering /member/list");

		// data
		List<Member> listMembers = memberService.getAllMembers();
		log.info("Length of member entries: " + listMembers.size());

		String[][] data = getData(listMembers, ACTION_EDIT);

		ModelAndView mav = new ModelAndView();
		Map<String, Object> model = mav.getModel();
		model.put("draw", new Integer(1));
		model.put("recordsTotal", new Integer(5));
		model.put("recordsFiltered", new Integer(5));
		model.put("data", data);
		model.put("customActionStatus", "OK");
		model.put("customActionMessage", "Data loaded");

		log.info("leaving /member/memberListData");
		return model;
	}

	@RequestMapping(value = "/search", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getDataSearchMembers(@RequestParam String jsonObjString) {
		log.info("entering... /member/search");

		// get parameters
		JSONObject jobj = new JSONObject(jsonObjString);

		String where1 = jobj.getString("acctName").trim();
		String where2 = jobj.getString("name1").trim();
		String where3 = jobj.getString("name2").trim();
		int where4 = jobj.getInt("gender");
		String where5 = jobj.getString("phone1").trim();
		String where6 = jobj.getString("phone2").trim();
		String where7 = jobj.getString("wechat").trim();
		String where8 = jobj.getString("email").trim();
		int where9 = jobj.getInt("memberStatus");

		/* construct query string */
		StringBuffer queryString = new StringBuffer();
		queryString.append(where1.length() == 0 ? " " : " and acct_name like '%" + where1 + "%' ");
		queryString.append(where2.length() == 0 ? " " : " and name1 like '%" + where2 + "%' ");
		queryString.append(where3.length() == 0 ? " " : " and name2 like '%" + where3 + "%' ");
		queryString.append(where4 == 0 ? " " : " and gender = " + where4 + " ");
		queryString.append(where5.length() == 0 ? " " : " and phone1 like '%" + where5 + "%' ");
		queryString.append(where6.length() == 0 ? " " : " and phone2 like '%" + where6 + "%' ");
		queryString.append(where7.length() == 0 ? " " : " and wechat like '%" + where7 + "%' ");
		queryString.append(where8.length() == 0 ? " " : " and email like '%" + where8 + "%' ");
		queryString.append(where9 == 0 ? " " : " and member_status = " + where9 + " ");
		log.info("QueryString = " + queryString.toString());

		List<Member> listMember = memberService.getMembersByFilter(queryString.toString());
		log.info("Length of member entries = " + listMember.size());

		// data
		String[][] data = getData(listMember, ACTION_EDIT);

		//
		ModelAndView mav = new ModelAndView();
		Map<String, Object> model = mav.getModel();
		model.put("draw", new Integer(1));
		model.put("recordsTotal", new Integer(5));
		model.put("recordsFiltered", new Integer(5));
		model.put("data", data);
		model.put("customActionStatus", "OK");
		model.put("customActionMessage", "OK");

		log.info("leaving... /member/searchFilterData");
		return model;
	}

	@RequestMapping(value = "/edit.html")
	public ModelAndView gotoMemberEdit(@RequestParam String acctName) {
		log.info("entering... /member/edit.html");

		// logic
		Member member = memberService.getMemberByAcctName(acctName);
		log.info("current member profile:" + member.toString());

		ModelAndView mav = new ModelAndView();
		Map<String, Object> model = mav.getModel();
		model.put("memberObject", member);
		// view
		String viewName = "member/member_edit";
		mav.setViewName(viewName);

		log.info("leaving... /member/edit.html");
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void updateMember(@RequestParam String jsonObjString) {
		log.info("entering... /member/update");

		JSONObject jsonObj = new JSONObject(jsonObjString);

		Member member = new Member();
		member.setAcctName(jsonObj.getString("acctName"));
		member.setName1(jsonObj.getString("name1"));
		member.setName2(jsonObj.getString("name2"));
		member.setGender(jsonObj.getInt("gender"));
		member.setNationality(jsonObj.getString("nationality"));
		member.setPhone1(jsonObj.getString("phone1"));
		member.setPhone2(jsonObj.getString("phone2"));
		member.setWechat(jsonObj.getString("wechat"));
		member.setEmail(jsonObj.getString("email"));
		member.setDegree(jsonObj.getString("degree"));
		member.setOccupation(jsonObj.getString("occupation"));
		member.setDob(jsonObj.getString("dob"));
		member.setPobProvince(jsonObj.getString("pobProvince"));
		member.setPobCity(jsonObj.getString("pobCity"));
		member.setHomeAddress(jsonObj.getString("homeAddress"));
		member.setPostalcode(jsonObj.getString("postalcode"));
		member.setMemberLevel(jsonObj.getInt("memberLevel"));
		int intMemberStatus = jsonObj.getInt("memberStatus");
		member.setMemberStatus(intMemberStatus);

		switch (intMemberStatus) {
		case MemberStatus.APPLIED:
			member.setMemberApplyDate(new Date());
			break;
		case MemberStatus.APPROVED:
			member.setMemberApprovedDate(new Date());
			break;
		case MemberStatus.ACTIVE:
			member.setMemberActiveDate(new Date());
			member.setMemberInactiveDate(DatetimeHelper.addOneYear(new Date()));
			break;
		case MemberStatus.INACTIVE:
			member.setMemberInactiveDate(new Date());
			break;
		case MemberStatus.BANNED:
			member.setMemberBannedDate(new Date());
			break;
		case MemberStatus.PENDING:
			member.setMemberPendingDate(new Date());
			break;
		default:
			break;
		}

		// DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Date tmpDate = null;
		// try {
		// tmpDate = dateFormat.parse(jsonObj.getString("memberActiveDate"));
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }
		//
		// member.setMemberActiveDate(tmpDate); //FIXME
		log.info("member = " + member);

		/* business logic */
		memberService.updateMember(member);

		log.info("leaving /member/update");
		return;
	}

	@RequestMapping(value = "/updategroup", produces = "application/json")
	@ResponseBody
	public void updateGroupMember(@RequestParam String memberArray, @RequestParam int memberStatus) {
		log.info("entering... /member/updategroup");

		List<Member> memberList = new ArrayList<Member>();
		String[] members = memberArray.split(",");
		int memberLength = members.length;

		for (int i = 0; i < memberLength; i++) {
			Member member = new Member();
			member.setAcctName(members[i]);
			member.setMemberStatus(memberStatus);
			memberList.add(member);
			member = null;
		}
		log.info("memberList size=" + memberList == null ? "NULL" : memberList.size());

		/* business logic */
		memberService.updateMemberGroup(memberList);

		log.info("leaving... /member/updategroup");
		return ;
	}

	private String[][] getData(List<Member> list, String actionName) {
		int entryLength = list.size();
		final int COLUMN_NUM = 11;
		String[][] data = new String[entryLength][COLUMN_NUM];

		String field0 = ""; // check box
		String field1 = ""; // acctName
		String field2 = ""; // name1
		String field3 = ""; // name2
		String field4 = ""; // gender
		String field5 = ""; // phone1
		String field6 = ""; // phone2
		String field7 = ""; // wechat
		String field8 = ""; // email
		String field9 = ""; // memberStatus
		String field10 = ""; // action

		for (int i = 0; i < entryLength; i++) {
			field0 = "<input type='checkbox' name='id[]' value=" + list.get(i).getAcctName() + ">";
			field1 = list.get(i).getAcctName() + "";
			field2 = list.get(i).getName1();
			field3 = list.get(i).getName2();
			field4 = getGender(list.get(i).getGender());
			field5 = list.get(i).getPhone1().trim();
			field6 = list.get(i).getPhone2().trim();
			field7 = list.get(i).getWechat().trim();
			field8 = list.get(i).getEmail().trim();

			int intMemberStatus = list.get(i).getMemberStatus();
			String[] memberStatusPair = getMemberStatusPair(intMemberStatus);
			String memberStatusKey = memberStatusPair[0];
			String memberStatus = memberStatusPair[1];
			field9 = "<span class='label label-sm label-" + memberStatusKey + "'>" + memberStatus + "</span>";
			field10 = "<a href='/acp/member/" + getAction(actionName) + "?acctName=" + field1
					+ "' class='btn btn-xs default btn-editable'><i class='fa fa-pencil'></i> " + actionName + "</a>";

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
			data[i][9] = field9;
			data[i][10] = field10;
		}

		return data;
	}

	private String getGender(int gender) {
		String strGender = "";
		if (1 == gender) {
			strGender = "��";
		} else if (2 == gender) {
			strGender = "Ů";
		} else {
			strGender = "δ֪";
		}
		return strGender;
	}

	private String getAction(String actionName) {
		String action = "";
		switch (actionName) {
		case ACTION_EDIT:
			action = "edit.html";
			break;
		case ACTION_DELETE:
			action = "delete.html";
			break;
		}
		return action;
	}

	private String[] getMemberStatusPair(int intStatus) {
		String[] statusPair = new String[2];

		String status = "";
		String statusKey = "";
		switch (intStatus) {
		case MemberStatus.APPLIED:
			// status = "Applied";
			status = "������";
			statusKey = "warning";
			break;
		case MemberStatus.APPROVED:
			// status = "Approved";
			status = "��ͨ��Ԥ��";
			statusKey = "info";
			break;
		case MemberStatus.ACTIVE:
			// status = "Active";
			status = "�Ѽ���";
			statusKey = "success";
			break;
		case MemberStatus.INACTIVE:
			// status = "Inactive";
			status = "δ����";
			statusKey = "default";
			break;
		case MemberStatus.PENDING:
			// status = "Pending";
			status = "�����";
			statusKey = "danger";
			break;
		case MemberStatus.BANNED:
			// status = "Banned";
			status = "�ѽ�ֹ";
			statusKey = "danger";
			break;
		default:
			break;
		}

		statusPair[0] = statusKey;
		statusPair[1] = status;

		return statusPair;
	}
}
