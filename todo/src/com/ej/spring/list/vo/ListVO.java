package com.ej.spring.list.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("listVO")
public class ListVO {
	private int tno;			//번호
	private String title;		//제목
	private String writer;		//작성자
	private String userid;		//사용자 아이디
	private String tododata;	//내용
	private Date regdate;		//등록일
	private String importance;	//중요도상중하 L or M or H
	private Date deadline;		//마감일
	private String result;		//결과 T to F
	
	public ListVO() {
	}

	public ListVO(String title, String writer, String userid, String tododata, String importance,
			String result) {
		this.title = title;
		this.writer = writer;
		this.userid = userid;
		this.tododata = tododata;
		this.importance = importance;
		this.result = result;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTododata() {
		return tododata;
	}

	public void setTododata(String tododata) {
		this.tododata = tododata;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ListVO [tno=" + tno + ", title=" + title + ", writer=" + writer + ", userid=" + userid + ", tododata="
				+ tododata + ", regdate=" + regdate + ", importance=" + importance + ", deadline=" + deadline
				+ ", result=" + result + "]";
	}
	

}
