package project.avocado.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import project.avocado.vo.MemberVO;

public class MemberDAO {
	
	Connection conn;
	PreparedStatement ptmt;// sql���� ���� ����, �����͸� ���ߺ����� �����û
	ResultSet rs;

	Properties pro;
	Statement stmt;
	
	MemberVO vo;

	public MemberDAO() {
		try {
			pro = new Properties();
			pro.load(new FileReader("conn/conn.properties"));

			// ����̹� �ε�(��ǰ�� ����)
			Class.forName(pro.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// ������

	private void connect() {// ���ᰴü ����
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// connect

	private void disconnect() {// DB�ڿ� ��ȯ
		try {
			if (rs != null)
				rs.close();
			if (ptmt != null)
				ptmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// disconnect
	
	public boolean insert(MemberVO vo) {
		connect();
		try {
			stmt=conn.createStatement();
			String sql = "insert into Member values ("+vo.getId()+",'"+vo.getPwd()
						+"','"+vo.getNick()+"','"+vo.getTel()+"',"+vo.getSsn()
						+",'"+vo.getEmail()+"',"+"member_mbno_seq.nextval)";
			stmt.executeUpdate(sql);
			/*ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, vo.getId());
			ptmt.setString(2, vo.getPwd());
			ptmt.setString(3, vo.getNick());
			ptmt.setString(4, vo.getTel());
			ptmt.setInt(5, vo.getSsn());
			ptmt.setString(6, vo.getEmail());
			ptmt.executeUpdate();*/
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;	
	}//insert
	public boolean update(MemberVO vo) {
		connect();
		String sql ="update Member set pwd=?,nick=?,tel=?,ssn=?,email=? where id=?";
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, vo.getPwd());
			ptmt.setString(2, vo.getNick());
			ptmt.setString(3, vo.getTel());
			ptmt.setInt(4, vo.getSsn());
			ptmt.setString(5, vo.getEmail());
			ptmt.setString(6, vo.getId());
			int t = ptmt.executeUpdate();
			if(t == 1) {
				return true;	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		disconnect();
		}
		return false;
	}//update
	
	public boolean delete(String delId) {
		connect();
		
		try {
			String sql = "delete from Member where id=?";
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, delId);
			int t= ptmt.executeUpdate();
			if(t==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
			
		}
		return false;
	}//delete
	public MemberVO select(String id) {
		connect();
		
		try {
			stmt = conn.createStatement();
			String sql = "select id,pwd,nick,tel,ssn,email,mbno from Member where = "+id;
			rs = stmt.executeQuery(sql);
			String id2 = rs.getString("id");
			String pwd = rs.getString("pwd");
			String nick = rs.getString("nick");
			String tel = rs.getString("tel");
			int ssn = rs.getInt("ssn");
			String email = rs.getString("email");
			//int mbno = rs.getInt("mbno");
			MemberVO vo = new MemberVO(id2,pwd,nick,tel,ssn,email);
			return vo;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			disconnect();			
		}
		return vo;
	}
	public ArrayList<MemberVO> selectAll() {
		ArrayList<MemberVO> list = new ArrayList<>();
		connect();
		try {
			stmt=conn.createStatement();
			String sql = "select id,pwd,nick,tel,ssn,email,mbno from Member order by mbno";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new MemberVO(rs.getString("id"),rs.getString("pwd"),
						rs.getString("nick"),rs.getString("tel"),rs.getInt("ssn"),
						rs.getString("email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	public ArrayList<MemberVO> selectId(String searchId) {
		connect();
		ArrayList<MemberVO> list = new ArrayList<>();
		
		try {
			String sql = "select id,pwd,nick,tel,ssn,email,mbno "
					+ "from Member where id like ?";
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, "%"+searchId+"%");
			rs = ptmt.executeQuery();
			while(rs.next()) {
				list.add(new MemberVO(rs.getString("id"),rs.getString("pwd"),
						rs.getString("nick"),rs.getString("tel"),rs.getInt("ssn"),
						rs.getString("email")));
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();			
		}
		return list;
	}//selectId

}
