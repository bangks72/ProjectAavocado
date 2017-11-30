package project.avocado.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import project.avocado.dao.MemberDAO;
import project.avocado.view.AdminMainView;
import project.avocado.view.AdminView;
import project.avocado.view.JoinView;
import project.avocado.view.LoginView;
import project.avocado.view.MusicAdminView;
import project.avocado.view.UpView;
import project.avocado.vo.MemberVO;

public class MemberController implements ActionListener {
	// 뷰등록
	JoinView joinview;
	LoginView loginview;
	AdminView adminview;
	AdminMainView adminmianview;
	MusicAdminView musicview;
	UpView upview;

	public MemberController() {
		loginview = new LoginView();
		joinview = new JoinView();
		adminview = new AdminView();
		adminmianview = new AdminMainView();
		musicview = new MusicAdminView();
		upview = new UpView();

		eventup();
	}// 생성자

	private void eventup() {
		// 회원가입
		joinview.submit_bt.addActionListener(this);
		joinview.cancle_bt.addActionListener(this);

		// 로그인
		loginview.bt_login.addActionListener(this);
		loginview.bt_join.addActionListener(this);

		// 회원관리
		adminview.insert_bt.addActionListener(this);
		adminview.update_bt.addActionListener(this);
		adminview.del_bt.addActionListener(this);
		adminview.cancel_bt.addActionListener(this);

		// 음악관리
		musicview.insert_bt.addActionListener(this);
		musicview.update_bt.addActionListener(this);
		musicview.del_bt.addActionListener(this);
		musicview.cancel_bt.addActionListener(this);

		// 관리자
		adminmianview.music_bt.addActionListener(this);
		adminmianview.member_bt.addActionListener(this);
		
		// 수정뷰
		upview.submit_bt.addActionListener(this);
		upview.cancle_bt.addActionListener(this);
		

		// 회원가입 X처리
		joinview.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				joinview.setVisible(false);
				loginview.setVisible(true);
			}
		});
		// 로그인X처리
		loginview.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				loginview.setVisible(false);
			}
		});
		// 맴버관리 X처리
		adminview.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				adminview.setVisible(false);
				adminmianview.setVisible(true);
			}
		});
		// 음악관리 X처리
		musicview.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				musicview.setVisible(false);
				adminmianview.setVisible(true);
			}
		});
		// 관리자 X처리
		adminmianview.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				loginview.initText();
				adminmianview.setVisible(false);
				loginview.setVisible(true);
			}
		});
		
		//업데이트뷰 X처리
		upview.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				upview.setVisible(false);
			}
		});
	}// eventup

	public void actionPerformed(ActionEvent e) {// 이벤트처리부
		Object ob = e.getSource();

		if (ob == loginview.bt_login) {
			String id = loginview.tf_id.getText();
			String pass = new String(loginview.tf_pass.getPassword());
			String admin = "admin";
			String pass2 = "1234";

			if (admin.equals(id) || pass2.equals(pass)) {
				adminmianview.setVisible(true);
				loginview.setVisible(false);
			} else {
				loginview.showMsg("계정을 확인해주세요");
				loginview.initText();
			}

		} else if (ob == loginview.bt_join) {
			joinview.initText();
			joinview.setVisible(true);
			loginview.setVisible(false);
		} else if (ob == joinview.submit_bt) {
			String id = joinview.tf_id.getText();
			String pass = new String(joinview.tf_pwd.getPassword());
			String pass2 = new String(joinview.tf_pwd2.getPassword());
			String nick = joinview.tf_nick.getText();
			String tel = joinview.tf_tel.getText();
			String ssn = joinview.tf_ssn.getText();
			String email = joinview.tf_email.getText() + "@" + (String) joinview.combo.getSelectedItem();
			
			MemberVO vo = new MemberVO(id, pass, nick, tel, Integer.parseInt(ssn), email);
			MemberDAO dao = new MemberDAO();

			if (dao.insert(vo)) {
				joinview.showMsg("회원가입성공!");
				joinview.setVisible(false);
				loginview.setVisible(true);
				joinview.initText();
			} else {
				joinview.showMsg("빈칸을 확인해주세요");
			}

		} else if (ob == joinview.cancle_bt) {
			loginview.initText();
			joinview.setVisible(false);
			loginview.setVisible(true);
		} else if (ob == joinview.overlap_bt) {
			String id = joinview.tf_id.getText();
			
		} else if (ob == adminview.insert_bt) {
			String searchId = adminview.showInput("검색할 아이디:");
			MemberDAO dao = new MemberDAO();
			adminview.displayTable(dao.selectId(searchId));
		} else if (ob == adminview.update_bt) {
			upview.setVisible(true);

		} else if (ob == adminview.del_bt) {
			String delId = adminview.showInput("삭제할 아이디:");
			MemberDAO dao = new MemberDAO();
			if(dao.delete(delId)) {
				adminview.showMsg("삭제성공!");
				adminview.displayTable(dao.selectAll());
			}else {
				adminview.showMsg("존재하지않는 아이디입니다.");
			}
		} else if (ob == adminview.cancel_bt) {
			adminview.setVisible(false);
			adminmianview.setVisible(true);
		} else if (ob == adminmianview.member_bt) {
			MemberDAO dao = new MemberDAO();
			adminview.displayTable(dao.selectAll());
			adminmianview.setVisible(false);
			adminview.setVisible(true);
		} else if (ob == adminmianview.music_bt) {
			adminmianview.setVisible(false);
			musicview.setVisible(true);
		} else if (ob == upview.submit_bt) {
			String id = upview.tf_id.getText();
			String pwd= new String(upview.tf_pwd.getPassword());
			String nick = upview.tf_nick.getText();
			String tel = upview.tf_tel.getText();
			int ssn = Integer.parseInt(upview.tf_ssn.getText());
			String email = upview.tf_email.getText() + "@" + (String) joinview.combo.getSelectedItem();
			
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setNick(nick);
			vo.setTel(tel);
			vo.setSsn(ssn);
			vo.setEmail(email);
			
			MemberDAO dao = new MemberDAO();
			if(dao.update(vo)) {
				adminview.displayTable(dao.selectAll());
				
				upview.setVisible(false);
				upview.initText();
			}else {
				upview.showMsg("입력데이터를 확인하세요");
			}
			
		}else if (ob == upview.cancle_bt) {
			upview.setVisible(false);
		}

	}

	public static void main(String[] args) {
		new MemberController();
	}

}