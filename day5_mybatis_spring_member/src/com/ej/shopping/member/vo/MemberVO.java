package com.ej.shopping.member.vo;

import java.util.Date;

public class MemberVO {
	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_gender;
	private String tel1;
	private String tel2;
	private String tel3;
	private String hp1;
	private String hp2;
	private String hp3;
	private String smssts_yn;
	private String email;
	private String email1;
	private String email2;
	private String emailsts_yn;
	private String zipcode;
	private String roadaddress;
	private String jibunaddress;
	private String namujiaddress;
	private String member_birth_y;
	private String member_birth_m;
	private String member_birth_d;
	private String member_birth_gn;
	private Date joindate;
	private String del_yn;
	
	public MemberVO() {
	}
	
	public MemberVO(String member_id, String member_pw, String member_name, String member_gender, String tel1,
			String tel2, String tel3, String hp1, String hp2, String hp3, String smssts_yn, String email, String email1,
			String email2, String emailsts_yn, String zipcode, String roadaddress, String jibunaddress,
			String namujiaddress, String member_birth_y, String member_birth_m, String member_birth_d,
			String member_birth_gn) {
		super();
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_gender = member_gender;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
		this.hp1 = hp1;
		this.hp2 = hp2;
		this.hp3 = hp3;
		this.smssts_yn = smssts_yn;
		this.email = email;
		this.email1 = email1;
		this.email2 = email2;
		this.emailsts_yn = emailsts_yn;
		this.zipcode = zipcode;
		this.roadaddress = roadaddress;
		this.jibunaddress = jibunaddress;
		this.namujiaddress = namujiaddress;
		this.member_birth_y = member_birth_y;
		this.member_birth_m = member_birth_m;
		this.member_birth_d = member_birth_d;
		this.member_birth_gn = member_birth_gn;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public String getHp1() {
		return hp1;
	}

	public void setHp1(String hp1) {
		this.hp1 = hp1;
	}

	public String getHp2() {
		return hp2;
	}

	public void setHp2(String hp2) {
		this.hp2 = hp2;
	}

	public String getHp3() {
		return hp3;
	}

	public void setHp3(String hp3) {
		this.hp3 = hp3;
	}

	public String getSmssts_yn() {
		return smssts_yn;
	}

	public void setSmssts_yn(String smssts_yn) {
		this.smssts_yn = smssts_yn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getEmailsts_yn() {
		return emailsts_yn;
	}

	public void setEmailsts_yn(String emailsts_yn) {
		this.emailsts_yn = emailsts_yn;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getRoadaddress() {
		return roadaddress;
	}

	public void setRoadaddress(String roadaddress) {
		this.roadaddress = roadaddress;
	}

	public String getJibunaddress() {
		return jibunaddress;
	}

	public void setJibunaddress(String jibunaddress) {
		this.jibunaddress = jibunaddress;
	}

	public String getNamujiaddress() {
		return namujiaddress;
	}

	public void setNamujiaddress(String namujiaddress) {
		this.namujiaddress = namujiaddress;
	}

	public String getMember_birth_y() {
		return member_birth_y;
	}

	public void setMember_birth_y(String member_birth_y) {
		this.member_birth_y = member_birth_y;
	}

	public String getMember_birth_m() {
		return member_birth_m;
	}

	public void setMember_birth_m(String member_birth_m) {
		this.member_birth_m = member_birth_m;
	}

	public String getMember_birth_d() {
		return member_birth_d;
	}

	public void setMember_birth_d(String member_birth_d) {
		this.member_birth_d = member_birth_d;
	}

	public String getMember_birth_gn() {
		return member_birth_gn;
	}

	public void setMember_birth_gn(String member_birth_gn) {
		this.member_birth_gn = member_birth_gn;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getDel_yn() {
		return del_yn;
	}

	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}

	@Override
	public String toString() {
		return "MemberVO [member_id=" + member_id + ", member_pw=" + member_pw + ", member_name=" + member_name
				+ ", member_gender=" + member_gender + ", tel1=" + tel1 + ", tel2=" + tel2 + ", tel3=" + tel3 + ", hp1="
				+ hp1 + ", hp2=" + hp2 + ", hp3=" + hp3 + ", smssts_yn=" + smssts_yn + ", email=" + email + ", email1="
				+ email1 + ", email2=" + email2 + ", emailsts_yn=" + emailsts_yn + ", zipcode=" + zipcode
				+ ", roadaddress=" + roadaddress + ", jibunaddress=" + jibunaddress + ", namujiaddress=" + namujiaddress
				+ ", member_birth_y=" + member_birth_y + ", member_birth_m=" + member_birth_m + ", member_birth_d="
				+ member_birth_d + ", member_birth_gn=" + member_birth_gn + ", joindate=" + joindate + ", del_yn="
				+ del_yn + "]";
	}

}
