package com.ssafy.hw15.service;

import java.util.List;

import com.ssafy.hw15.vo.Emp;

public interface EmpService {
	boolean addEmp(Emp emp);
	List <Emp> getListAll();
	void selectEmp(Emp emp);
	List <Emp> selectName(String name);
	void modiEmp(Emp emp, String dept);
	void deleteEmpno(Emp emp);
}
