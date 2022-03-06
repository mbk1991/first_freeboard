package com.tistory.mabb.freeboard.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.tistory.mabb.freeboard.BoardVo;

public class BoardDao {
	private static String dburl = "jdbc:mysql://localhost:3306/board";
	private static String dbuser = "root";
	private static String dbpassword = "0000";
	
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
		
	public ArrayList<BoardVo> selectBoard() {
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
			String sql = "SELECT * FROM freeboard ORDER BY num desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int num = rs.getInt("num");
				String sub = rs.getString("sub");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date writetime = rs.getDate("writetime");
				
				BoardVo vo = new BoardVo(num, sub, content, writer, writetime);
				list.add(vo);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {rs.close();} catch (Exception e2) {e2.printStackTrace();}
			 	}
			if(ps != null) {
				try {ps.close();} catch (Exception e2) {e2.printStackTrace();}
				}
			if(conn != null) {
				try {conn.close();} catch (Exception e2) {e2.printStackTrace();}
				}			
			}		
		return list;
		}
	
	public void insertBoard(String sub,String content,String writer) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
				
				String sql = "insert into freeboard(num,sub,content,writer) "
						+ "values( (select num from (select max(num)+1 as num from freeboard)as freeboard_t),"
						+ "?,?,?);";
				
				ps = conn.prepareStatement(sql);	
				ps.setString(1, sub);
				ps.setString(2, content);
				ps.setString(3, writer);
				
				ps.executeUpdate();
				
								
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(ps != null) {
					try {ps.close();} catch (Exception e2) {e2.printStackTrace();}
					}
				if(conn != null) {
					try {conn.close();} catch (Exception e2) {e2.printStackTrace();}
					}			
				}				
	}
	
	public BoardVo contentBoard(int num_c) {
		
		BoardVo vo = new BoardVo();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
			String sql = "SELECT * FROM freeboard WHERE num = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num_c);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				vo.setNum(rs.getInt("num"));
				vo.setSub(rs.getString("sub"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWritetime(rs.getDate("writetime"));												
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {rs.close();} catch (Exception e2) {e2.printStackTrace();}
			 	}
			if(ps != null) {
				try {ps.close();} catch (Exception e2) {e2.printStackTrace();}
				}
			if(conn != null) {
				try {conn.close();} catch (Exception e2) {e2.printStackTrace();}
				}			
			}	
		return vo;
	}

}
