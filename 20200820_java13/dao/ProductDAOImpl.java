package com.ssafy.hw14.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.hw14.vo.Product;

public class ProductDAOImpl implements ProductDAO {
	private static final String addSQL = "insert into product values"
			+ "(?, ?, ?, ?);";
	private static final String selectAllSQL = "select * from product;";
	private static final String selectSerialSQL = "select * from product where serial = ?;";
	private static final String selectNameSQL = "select * from product where name = ?;";
	private static final String selectCheapSQL = "select * from product where price <= ?;";
	private static final String deleteSerialSQL = "delete from product where serial = ?;";
	private static final String modiSerialSQL = "update product set price = ? where serial = ?;";

	@Override
	public boolean addProduct(Product product) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(addSQL);
			stmt.setString(1, product.getSerial());
			stmt.setString(2, product.getName());
			stmt.setInt(3, product.getPrice());
			stmt.setInt(4, product.getQuantity());
			int cnt = stmt.executeUpdate();
			if(cnt == 1) {
				flag = true;
			}
			System.out.println("add Success");
		}catch(SQLException e) {
			System.out.println("add e : " + e);
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return flag;
	}
	@Override
	public List <Product> getListAll() {
		List <Product> list = new ArrayList<Product> ();
		Connection con = null;
		ResultSet rst = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(selectAllSQL);
			rst = stmt.executeQuery();
			Product product = null;
			while(rst.next()) {
				product = new Product();
				product.setSerial(rst.getString(1));
				product.setName(rst.getString(2));
				product.setPrice(rst.getInt(3));
				product.setQuantity(rst.getInt(4));
				list.add(product);
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
	public void selectSerial(Product product) {
		Connection con = null;
		ResultSet rst = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(selectSerialSQL);
			stmt.setNString(1,  product.getSerial());
			rst = stmt.executeQuery();
			if(rst.next()) {
				product.setName(rst.getString(2));
				product.setPrice(rst.getInt(3));
				product.setQuantity(rst.getInt(4));
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
	public List<Product> getListCheap(int price) {
		List <Product> list = new ArrayList <Product> ();
		Connection con = null;
		ResultSet rst = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(selectCheapSQL);
			stmt.setInt(1, price);
			rst = stmt.executeQuery();
			Product product = null;
			while(rst.next()) {
				product = new Product();
				product.setSerial(rst.getString(1));
				product.setName(rst.getString(2));
				product.setPrice(rst.getInt(3));
				product.setQuantity(rst.getInt(4));
				list.add(product);
			}
			System.out.println("검색 success");
		}catch(SQLException e) {
			System.out.println("get cheap price e : " + e);
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return list;
	}
	@Override
	public void selectName(Product product) {
		Connection con = null;
		ResultSet rst = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(selectNameSQL);
			stmt.setNString(1,  product.getName());
			rst = stmt.executeQuery();
			if(rst.next()) {
				product.setSerial(rst.getString(1));
				product.setPrice(rst.getInt(3));
				product.setQuantity(rst.getInt(4));
			}
			System.out.println("검색 success");
		}catch(SQLException e){
			System.out.println("select Name e : " + e);
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
	@Override
	public void deleteSerial(Product product) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(deleteSerialSQL);
			stmt.setNString(1, product.getSerial());
			stmt.execute();
			System.out.println("삭제 success");
		}catch(SQLException e){
			System.out.println("delete Serial e : " + e);
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		
	}
	@Override
	public void modiSerial(Product product, int price) {
		Connection con = null;
//		ResultSet rst = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(modiSerialSQL);
			stmt.setInt(1, price);
			stmt.setNString(2, product.getSerial());
			stmt.execute();
			System.out.println("수정 success");
		}catch(SQLException e){
			System.out.println("select Name e : " + e);
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
}
