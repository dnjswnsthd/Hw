package com.ssafy.hw15.util;

import java.util.List;

import com.ssafy.hw15.service.EmpService;
import com.ssafy.hw15.service.EmpServiceImpl;
import com.ssafy.hw15.vo.Emp;

public class EmpManager {
	private static EmpManager instance;
	EmpService service = new EmpServiceImpl();
	private EmpManager() {}
	public static EmpManager getInstance() {
		if(instance == null) {
			instance = new EmpManager();
		}
		return instance;
	}
	public boolean addEmp(Emp emp) {
		return service.addEmp(emp);
	}
	public List <Emp> getListAll(){
		return service.getListAll();
	}
	public void selectEmp(Emp emp) {
		service.selectEmp(emp);
	}
	public List <Emp> selectName(String name){
		return service.selectName(name);
	}
	public void modiEmp(Emp emp, String dept) {
		service.modiEmp(emp, dept);
	}
	public void deleteEmpno(Emp emp) {
		service.deleteEmpno(emp);
	}
}
