package com.lcpan.m02;

import java.sql.*;

public class test {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezon=UTC";
			conn = DriverManager.getConnection(url,"root","89757pkz");
			
			String sql = "select ename,salary from employee";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.print("name = "+rs.getString(1));
				System.out.println(", salary = "+rs.getInt(2));
			}
			rs.close(); stmt.close();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
}
