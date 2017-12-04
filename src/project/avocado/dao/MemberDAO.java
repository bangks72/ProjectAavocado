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
			String sql = "insert into Member values (?,?,?,?,?,?,member_mbno_seq.nextval)";
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, vo.getId());
			ptmt.setString(2, vo.getPwd());
			ptmt.setString(3, vo.getNick());
			ptmt.setString(4, vo.getTel());
			ptmt.setString(5, vo.getSsn());
			ptmt.setString(6, vo.getEmail());
			ptmt.executeUpdate();
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
			ptmt.setString(4, vo.getSsn());
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
	public MemberVO select(String upid) {
		connect();
		MemberVO vo =null;
		try {
			String sql = "select id,pwd,nick,tel,ssn,email from Member where id=?";
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, upid);
			rs = ptmt.executeQuery();
			if(rs.next()) {
				vo=new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setNick(rs.getString("nick"));
				vo.setTel(rs.getString("tel"));
				vo.setSsn(rs.getString("ssn"));
				//vo.setEmail(rs.getString("email"));
			}
			
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
						rs.getString("nick"),rs.getString("tel"),rs.getString("ssn"),
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
						rs.getString("nick"),rs.getString("tel"),rs.getString("ssn"),
						rs.getString("email")));
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();			
		}
		return list;
	}//selectId
	
	public boolean overlap(String id) {
		connect();
		
		try {
			String sql = "select count(*) from Member where id =?";
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, id);
			
			rs = ptmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if(count==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();			
		}
		return false;

	}//overlap
	
	public boolean selectLogin(String id, String pwd) {
		connect();	
		try {
			String sql = "select count(*) from Member where id =? and pwd =?";
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, pwd);
			rs = ptmt.executeQuery();
			
			rs.next();
			int count = rs.getInt(1);
			if(count==1) {
				return true;// 로그인 성공
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return false;// 로그인 실패
	}//selectLogin
	public String selectId(String nick, String ssn) {
		connect();	
		String id = null;
		try {
			String sql = "select id from Member where nick =? and ssn =?";
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, nick);
			ptmt.setString(2, ssn);
			rs = ptmt.executeQuery();
	         if (rs.next()) {
	            id = rs.getString(1);
	            return id;
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	      return id;
	   }//selectId
	public String selectpwd(String id, String tel, String ssn) {
		connect();	
		String pwd= null;
		try {
			String sql = "select pwd from Member where id =? and tel =? and ssn=?";
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, tel);
			ptmt.setString(3, ssn);
			rs = ptmt.executeQuery();
			if (rs.next()) {
	            pwd = rs.getString(1);
	            return pwd;
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	      return pwd;
	}//selectpwd

}
