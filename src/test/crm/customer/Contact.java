package test.crm.customer;

public class Contact {
	private long accountId;
	
	private String firstName;
	private String lastName;
	private String nickName;
	private String gender;
	private String title;       //Mr. Mrs. Ms. Dr.
	
	
	/* date of birth */
	private int dobYear;
	private int dobMonth;
	private int dobDay;

	
	private String email1;
	private String email2;
	
	/* phone numbers */
	private String phone1;
	private String phone1_Ext;
	
	private String cellPhone;
	
	
	/* company info */
	private String phone2;
	private String phone2_Ext;
	
	private String companyName;
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone2_Ext() {
		return phone2_Ext;
	}
	public void setPhone2_Ext(String phone2_Ext) {
		this.phone2_Ext = phone2_Ext;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyPosition() {
		return companyPosition;
	}
	public void setCompanyPosition(String companyPosition) {
		this.companyPosition = companyPosition;
	}
	private String companyPosition;
	
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone1_Ext() {
		return phone1_Ext;
	}
	public void setPhone1_Ext(String phone1_Ext) {
		this.phone1_Ext = phone1_Ext;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
	
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getDobYear() {
		return dobYear;
	}
	public void setDobYear(int dobYear) {
		this.dobYear = dobYear;
	}
	public int getDobMonth() {
		return dobMonth;
	}
	public void setDobMonth(int dobMonth) {
		this.dobMonth = dobMonth;
	}
	public int getDobDay() {
		return dobDay;
	}
	public void setDobDay(int dobDay) {
		this.dobDay = dobDay;
	}
}
