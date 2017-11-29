package project.avocado.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import project.avocado.vo.MemberVO;

public class MemberDAO {
	
	Connection conn;
	PreparedStatement stmt;// sql문을 먼저 전송, 데이터를 나중보내서 실행요청
	ResultSet rs;

	Properties pro;

	public MemberDAO() {
		try {
			pro = new Properties();
			pro.load(new FileReader("conn/conn.properties"));

			// 드라이버 로딩(제품군 선택)
			Class.forName(pro.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// 생성자

	private void connect() {// 연결객체 생성
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// connect

	private void disconnect() {// DB자원 반환
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// disconnect
	
	public boolean insert(MemberVO vo) {
		connect();
		try {
			String sql = "insert into Member values (?,?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPwd());
			stmt.setString(3, vo.getNick());
			stmt.setString(4, vo.getTel());
			stmt.setInt(5, vo.getSsn());
			stmt.setString(6, vo.getEmail());
			stmt.setInt(7, vo.getMbno());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;	
	}//insert
	private void update() {
		
	}
	
	private void delete() {
		
	}
	private void select() {
		
	}
	private void selectAll() {

	}

}
