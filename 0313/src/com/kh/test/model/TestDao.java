package com.kh.test.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TestDao {
	
	public List<Test> selectList() {
		
		List<Test> list = new List<Test>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM TEST";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.3:1521:xe", "kh", "kh");
			
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				Test t = new Test();
				
				t.setSeq(rset.getInt("SEQ"));
				t.setWriter(rset.getString("WRITER"));
				t.setTitle(rset.getString("TITLE"));
				t.setContent(rset.getString("CONTENT"));
				t.setRegDate(rset.getDate("REGDATE"));
				
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rset.close();
			pstmt.close();
			conn.close();
		}
		
		return list;
	}
}
