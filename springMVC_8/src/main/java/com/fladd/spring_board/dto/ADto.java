package com.fladd.spring_board.dto;

import java.sql.Timestamp;

public class ADto { // 데이터베이스에 있는 데이터를 객체로 바꾸기

	int aId;
	String aName;
	String aTitle;
	String aContent;
	Timestamp aDate;
	int aHit;
	int aGroup;
	int aStep;
	int aIndent;

	public ADto() { // 디폴트 생성자

	}

	public ADto(int aId, String aName, String aTitle, String aContent, Timestamp aDate, int aHit, int aGroup, int aStep,
			int aIndent) { // 파라미터 받기

		this.aId = aId;
		this.aName = aName;
		this.aTitle = aTitle;
		this.aContent = aContent;
		this.aDate = aDate;
		this.aHit = aHit;
		this.aGroup = aGroup;
		this.aStep = aStep;
		this.aIndent = aIndent;
	}

	// getter/setter

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaTitle() {
		return aTitle;
	}

	public void setaTitle(String aTitle) {
		this.aTitle = aTitle;
	}

	public String getaContent() {
		return aContent;
	}

	public void setaContent(String aContent) {
		this.aContent = aContent;
	}

	public Timestamp getaDate() {
		return aDate;
	}

	public void setaDate(Timestamp aDate) {
		this.aDate = aDate;
	}

	public int getaHit() {
		return aHit;
	}

	public void setaHit(int aHit) {
		this.aHit = aHit;
	}

	public int getaGroup() {
		return aGroup;
	}

	public void setaGroup(int aGroup) {
		this.aGroup = aGroup;
	}

	public int getaStep() {
		return aStep;
	}

	public void setaStep(int aStep) {
		this.aStep = aStep;
	}

	public int getaIndent() {
		return aIndent;
	}

	public void setaIndent(int aIndent) {
		this.aIndent = aIndent;
	}

}
