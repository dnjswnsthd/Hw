package com.ssafy.hw15.vo;

public class Emp {
	private int empno;
	private String name;
	private String position;
	private String dept;
	
	public Emp() {
		super();
	}
	public Emp(int empno, String name, String position, String dept) {
		super();
		this.empno = empno;
		this.name = name;
		this.position = position;
		this.dept = dept;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", name=" + name + ", position=" + position + ", dept=" + dept + "]";
	}
}
