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
import project.avocado.vo.MemberVO;

public class MemberController implements ActionListener {
	// 뷰등록
	JoinView joinview;
	LoginView loginview;
	AdminView adminview;
	AdminMainView adminmianview;
	MusicAdminView musicview;

	public MemberController() {
		loginview = new LoginView();
		joinview = new JoinView();
		adminview = new AdminView();
		adminmianview = new AdminMainView();
		musicview = new MusicAdminView();

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
				loginview.tf_id.setText("");
				loginview.tf_pass.setText("");
				adminmianview.setVisible(false);
				loginview.setVisible(true);
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
			}

		} else if (ob == loginview.bt_join) {
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

			int count = 1;
			count++;

			MemberVO vo = new MemberVO(id, pass, nick, tel, Integer.parseInt(ssn), email, count);
			MemberDAO dao = new MemberDAO();

			if (dao.insert(vo)) {
				joinview.showMsg("회원가입성공!");
				joinview.setVisible(false);
				loginview.setVisible(true);
			} else {
				joinview.showMsg("빈칸을 확인해주세요");
			}

		} else if (ob == joinview.cancle_bt) {
			loginview.tf_id.setText("");
			loginview.tf_pass.setText("");

			joinview.setVisible(false);
			loginview.setVisible(true);
		} else if (ob == joinview.overlap_bt) {
			String id = joinview.tf_id.getText();
		} else if (ob == adminview.insert_bt) {

		} else if (ob == adminview.update_bt) {

		} else if (ob == adminview.del_bt) {

		} else if (ob == adminview.cancel_bt) {
			adminview.setVisible(false);
			adminmianview.setVisible(true);
		} else if (ob == adminmianview.member_bt) {
			adminmianview.setVisible(false);
			adminview.setVisible(true);
		} else if (ob == adminmianview.music_bt) {
			adminmianview.setVisible(false);
			musicview.setVisible(true);
		}

	}

	public static void main(String[] args) {
		new MemberController();
	}

}