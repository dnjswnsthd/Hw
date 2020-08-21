package com.ssafy.hw15.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.hw15.vo.Emp;

public class EmpDAOImpl implements EmpDAO {
	private static final String addSQL = "insert into emp values"
			+ "(?, ?, ?, ?);";
	private static final String selectAllSQL = "select * from emp;";
	private static final String selectSerialSQL = "select * from emp where empno = ?;";
	private static final String selectNameSQL = "select * from emp where name = ?;";
	private static final String modiSerialSQL = "update emp set dept = ? where empno = ? ";
	private static final String deleteSerialSQL = "delete from emp where empno = ?;";

	
	@Override
	public boolean addEmp(Emp emp) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(addSQL);
			stmt.setInt(1, emp.getEmpno());
			stmt.setString(2, emp.getName());
			stmt.setString(3, emp.getPosition());
			stmt.setString(4, emp.getDept());
			int cnt = stmt.executeUpdate();
			if(cnt == 1) {
				flag = true;
			}
			System.out.println("add Success");
		}catch(SQLException e) {
			System.out.println("add e " + e);
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return flag;
	}
	@Override
	public List<Emp> getListAll() {
		List <Emp> list = new ArrayList<Emp> ();
		Connection con = null;
		ResultSet rst = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(selectAllSQL);
			rst = stmt.executeQuery();
			Emp emp = null;
			while(rst.next()) {
				emp = new Emp();
				emp.setEmpno(rst.getInt(1));
				emp.setName(rst.getString(2));
				emp.setPosition(rst.getString(3));
				emp.setDept(rst.getString(4));
				list.add(emp);
			}
			System.out.println("검색 success");
			System.out.println("select All Success");
		}catch(SQLException e) {
			System.out.println("select All e : " + e);
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return list;
	}
	@Override
	public void selectEmp(Emp emp) {
		Connection con = null;
		ResultSet rst = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(selectSerialSQL);
			stmt.setInt(1, emp.getEmpno());
			rst = stmt.executeQuery();
			if(rst.next()) {
				emp.setName(rst.getString(2));
				emp.setPosition(rst.getString(3));
				emp.setDept(rst.getString(4));
			}
			System.out.println("검색 success");
		}catch(SQLException e){
			System.out.println("select Serial e : " + e);
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
	@Override
	public List<Emp> selectName(String name) {
		List <Emp> list = new ArrayList<Emp> ();
		Connection con = null;
		ResultSet rst = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(selectNameSQL);
			stmt.setNString(1, name);
			rst = stmt.executeQuery();
			Emp emp = null;
			while(rst.next()) {
				emp = new Emp();
				emp.setEmpno(rst.getInt(1));
				emp.setName(rst.getString(2));
				emp.setPosition(rst.getString(3));
				emp.setDept(rst.getString(4));
				list.add(emp);
			}
			System.out.println("검색 success");
			System.out.println("select Name Success");
		}catch(SQLException e) {
			System.out.println("select Name e : " + e);
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return list;
	}
	@Override
	public void modiEmp(Emp emp, String dept) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(modiSerialSQL);
			stmt.setNString(1, dept);
			stmt.setInt(2, emp.getEmpno());
			stmt.execute();
			System.out.println("수정 success");
		}catch(SQLException e){
			System.out.println("select Name e : " + e);
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		
	}
	@Override
	public void deleteEmpno(Emp emp) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(deleteSerialSQL);
			stmt.setInt(1, emp.getEmpno());
			stmt.execute();
			System.out.println("삭제 success");
		}catch(SQLException e){
			System.out.println("delete Serial e : " + e);
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
}
