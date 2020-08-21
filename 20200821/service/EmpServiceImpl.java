package com.ssafy.hw15.service;

import java.util.List;

import com.ssafy.hw15.dao.EmpDAO;
import com.ssafy.hw15.dao.EmpDAOImpl;
import com.ssafy.hw15.vo.Emp;

public class EmpServiceImpl implements EmpService {
	EmpDAO dao = new EmpDAOImpl();

	@Override
	public boolean addEmp(Emp emp) {
		return dao.addEmp(emp);
	}
	public List <Emp> getListAll(){
		return dao.getListAll();
	}
	@Override
	public void selectEmp(Emp emp) {
		dao.selectEmp(emp);
	}
	@Override
	public List<Emp> selectName(String name) {
		return dao.selectName(name);
	}
	@Override
	public void modiEmp(Emp emp, String dept) {
		dao.modiEmp(emp, dept);
	}
	@Override
	public void deleteEmpno(Emp emp) {
		dao.deleteEmpno(emp);
	}
	
}
