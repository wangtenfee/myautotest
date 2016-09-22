package com.comall.requestautotest.domain;


public class Parameter {
	private Position  positon;
	private String paraName;
	private String value;
	private int pcaseid;
	private int scaseid;
	
	public Position getPositon() {
		return positon;
	}
	public void setPositon(Position positon) {
		this.positon = positon;
	}
	public String getParaName() {
		return paraName;
	}
	public void setParaName(String paraName) {
		this.paraName = paraName;
	}
	public int getPcaseid() {
		return pcaseid;
	}
	public void setPcaseid(int pcaseid) {
		this.pcaseid = pcaseid;
	}
	public int getScaseid() {
		return scaseid;
	}
	public void setScaseid(int scaseid) {
		this.scaseid = scaseid;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
