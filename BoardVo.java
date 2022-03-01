package com.tistory.mabb.freeboard;

import java.util.Date;

public class BoardVo {
	int num;
	String sub;
	String content;
	String writer;
	Date writetime;    //mysql의 timestamp와 호환이 되는 데이터유형으로 설정을 해야한다.
	
	public BoardVo() {
		
	}
	
	//생성자
	public BoardVo(int num,String sub,String content,String writer,Date writetime) {
		this.num = num;
		this.sub = sub;
		this.content = content;
		this.writer = writer;
		this.writetime = writetime;
		}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWritetime() {
		return writetime;
	}
	public void setWritetime(Date writetime) {
		this.writetime = writetime;
	}
}
