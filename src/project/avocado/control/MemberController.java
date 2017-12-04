package project.avocado.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import project.avocado.dao.MemberDAO;
import project.avocado.view.AdminMainView;
import project.avocado.view.AdminView;
import project.avocado.view.IdSearch;
import project.avocado.view.JoinView;
import project.avocado.view.LoginView;
import project.avocado.view.MainView;
import project.avocado.view.MusicAdminView;
import project.avocado.view.PlayerView;
import project.avocado.view.PwdSearch;
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
	MainView mainview;
	PlayerView playerview;
	IdSearch idsearch;
	PwdSearch pwdsearch;

	public MemberController() {
		loginview = new LoginView();
		joinview = new JoinView();
		adminview = new AdminView();
		adminmianview = new AdminMainView();
		musicview = new MusicAdminView();
		upview = new UpView();
		mainview = new MainView();
		playerview = new PlayerView();
		idsearch = new IdSearch();
		pwdsearch = new PwdSearch();

		eventup();
	}// 생성자

	private void eventup() {
		// 회원가입
		joinview.submit_bt.addActionListener(this);
		joinview.cancle_bt.addActionListener(this);
		joinview.overlap_bt.addActionListener(this);

		// 로그인
		loginview.bt_login.addActionListener(this);
		loginview.bt_join.addActionListener(this);
		loginview.bt_idSearch.addActionListener(this);
		loginview.bt_pwdSearch.addActionListener(this);

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
		
		//아이디서치
		idsearch.bt_submit.addActionListener(this);
		idsearch.bt_cancle.addActionListener(this);
		
		//패스워드서치
		pwdsearch.bt_submit.addActionListener(this);
		pwdsearch.bt_cancle.addActionListener(this);

		// 회원가입 X처리
		joinview.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				loginview.initText();
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
		//아이디서치 X처리
		idsearch.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				idsearch.setVisible(false);
				loginview.setVisible(true);
			}
		});
		
		//패스워드서치 X처리
		pwdsearch.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);	
				pwdsearch.setVisible(false);
				loginview.setVisible(true);
			}
		});
	}// eventup

	public void actionPerformed(ActionEvent e) {// 이벤트처리부
		Object ob = e.getSource();

		if (ob == loginview.bt_login) {
			String id = loginview.tf_id.getText();
			String pwd = new String(loginview.tf_pass.getPassword());
			String admin = "admin";
			String pass2 = "admin";
			
			if (admin.equals(id) || pass2.equals(pwd)) {
				adminmianview.setVisible(true);
				loginview.setVisible(false);
				loginview.initText();
				return;
			}
			MemberDAO dao = new MemberDAO();
			if(dao.selectLogin(id, pwd)) {
				loginview.showMsg("로그인합니다.");
			}else {
				loginview.showMsg("계정을 확인해주세요");
				loginview.initText();
				return;
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
			
			if(!pass.equals(pass2)) {
				joinview.showMsg("비밀번호를 확인해주세요");
				joinview.tf_pwd.setText("");
				joinview.tf_pwd2.setText("");
				joinview.tf_pwd.requestFocus();
				return;
			}
			if(iskorean(id)) {
				joinview.showMsg("아이디는 영문및숫자조합으로 적어주세요");
				joinview.tf_id.setText("");
				joinview.tf_id.requestFocus();
				return;
			}
			
			if(emptyCheck(id,pass,pass2,nick,tel,ssn,email)) {
				joinview.showMsg("입력값을 확인하세요");
				return;
			}
			if(!numberCheck(ssn)) {
				joinview.showMsg("숫자만 입력해주세요");
				joinview.tf_ssn.setText("");
				return;
			}
			if(!numberCheck(tel)) {
				joinview.showMsg("숫자만 입력해주세요");
				joinview.tf_tel.setText("");
				return;
			}
			if(id.length()>15) {
				joinview.showMsg("아이디를 줄여주세요");
				joinview.tf_id.setText("");
				joinview.tf_id.requestFocus();
				return;
			}
			if(pass.length()>15||pass2.length()>15) {
				joinview.showMsg("패스워드를 줄여주세요");
				joinview.tf_pwd.setText("");
				joinview.tf_pwd2.setText("");
				joinview.tf_pwd.requestFocus();
				return;
			}
			if(nick.length()>30) {
				joinview.showMsg("닉네임을 줄여주세요");
				joinview.tf_nick.setText("");
				joinview.tf_nick.requestFocus();
				return;
			}
			if(tel.length()>13) {
				joinview.showMsg("전화번호는 - 없이 입력해주세요");
				joinview.tf_tel.setText("");
				joinview.tf_tel.requestFocus();
				return;
			}
			if(ssn.length()>6) {
				joinview.showMsg("생년월일만 적어주세요.(901130)");
				joinview.tf_ssn.setText("");
				joinview.tf_ssn.requestFocus();
				return;
			}
			if(ssn.length()<5) {
				joinview.showMsg("생년월일만 적어주세요.(901130)");
				joinview.tf_ssn.setText("");
				joinview.tf_ssn.requestFocus();
				return;
			} 

			MemberVO vo = new MemberVO(id, pass, nick, tel, ssn, email);
			MemberDAO dao = new MemberDAO();
			
			if (dao.insert(vo)) {
				joinview.showMsg("회원가입성공!");
				joinview.setVisible(false);
				loginview.setVisible(true);
				joinview.initText();
				joinview.submit_bt.setEnabled(false);
			} else {
				joinview.showMsg("빈칸을 확인해주세요");
			}

		} else if (ob == joinview.cancle_bt) {
			loginview.initText();
			joinview.setVisible(false);
			loginview.setVisible(true);
		} else if (ob == joinview.overlap_bt) {
			
			MemberDAO dao = new MemberDAO();
			String id = joinview.tf_id.getText();
			

			if(iskorean(id)) {
				joinview.showMsg("아이디는 영문및숫자조합으로 적어주세요");
				joinview.tf_id.setText("");
				joinview.tf_id.requestFocus();
		 	}else if(dao.overlap(id)) {
				joinview.showMsg("중복되는아이디입니다.");
				joinview.tf_id.setText("");
				joinview.tf_id.requestFocus();
			}else{
				joinview.showMsg("사용가능합니다.");
				joinview.submit_bt.setEnabled(true);
			}		
		} else if (ob == adminview.insert_bt) {
			String searchId = adminview.showInput("검색할 아이디:");
			MemberDAO dao = new MemberDAO();
			adminview.displayTable(dao.selectId(searchId));
		} else if (ob == adminview.update_bt) {
			String upid = upview.showInput("아이디를 적어주세요");
			MemberDAO dao = new MemberDAO();
			MemberVO vo = dao.select(upid);
			if(vo==null) {
				upview.showMsg("존재하지않는아이디입니다.");
			} else {
				upview.tf_id.setText(vo.getId());
				upview.tf_pwd.setText(vo.getPwd());
				upview.tf_nick.setText(vo.getNick());
				upview.tf_tel.setText(vo.getTel());
				upview.tf_ssn.setText(vo.getSsn());
				//upview.tf_email.setText(vo.getEmail());
				upview.setVisible(true);
			}
			
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
			String pwd2= new String(upview.tf_pwd2.getPassword());
			String nick = upview.tf_nick.getText();
			String tel = upview.tf_tel.getText();
			String ssn = upview.tf_ssn.getText();
			String email = upview.tf_email.getText() + "@" + (String) joinview.combo.getSelectedItem();
			
			
			if(!pwd.equals(pwd2)) {
				joinview.showMsg("비밀번호를 확인해주세요");
				joinview.tf_pwd.setText("");
				joinview.tf_pwd2.setText("");
				joinview.tf_pwd.requestFocus();
				return;
			}
			
			if(emptyCheck(pwd,nick,tel,ssn,email)) {
				upview.showMsg("입력값을 확인하세요");
				return;
			}
			if(!numberCheck(ssn)) {
				upview.showMsg("숫자만 입력해주세요");
				upview.tf_ssn.setText("");
				upview.tf_ssn.requestFocus();
				return;
			}
			if(!numberCheck(tel)) {
				upview.showMsg("숫자만 입력해주세요");
				upview.tf_tel.setText("");
				upview.tf_tel.requestFocus();
				return;
			}

			if(pwd.length()>15) {
				upview.showMsg("패스워드를 줄여주세요");
				upview.tf_pwd.setText("");
				upview.tf_pwd.requestFocus();
				return;
			}
			if(nick.length()>30) {
				upview.showMsg("닉네임을 줄여주세요");
				upview.tf_nick.setText("");
				upview.tf_nick.requestFocus();
				return;
			}
			if(tel.length()>13) {
				upview.showMsg("전화번호는 - 없이 입력해주세요");
				upview.tf_tel.setText("");
				upview.tf_tel.requestFocus();
				return;
			}
			if(ssn.length()>6) {
				upview.showMsg("생년월일만 적어주세요.(901130)");
				upview.tf_ssn.setText("");
				upview.tf_ssn.requestFocus();
				return;
			}
			if(ssn.length()<5) {
				upview.showMsg("생년월일만 적어주세요.(901130)");
				upview.tf_ssn.setText("");
				upview.tf_ssn.requestFocus();
				return;
			} 
			
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
		}else if (ob == loginview.bt_idSearch) {
			loginview.setVisible(false);
			idsearch.setVisible(true);
			idsearch.tf_nick.setText("");
			idsearch.tf_ssn.setText("");
		}else if (ob == loginview.bt_pwdSearch) {
			loginview.setVisible(false);
			pwdsearch.setVisible(true);
			pwdsearch.tf_id.setText("");
			pwdsearch.tf_ssn.setText("");
			pwdsearch.tf_tel.setText("");
		}else if (ob == idsearch.bt_submit) {
			String nick1 = idsearch.tf_nick.getText();
			String ssn1 = idsearch.tf_ssn.getText();
			MemberDAO dao = new MemberDAO();
			
			String id1 = dao.selectId(nick1, ssn1);
			if(id1 != null) {
				idsearch.showMsg("아이디는"+id1+"입니다.");
				idsearch.tf_nick.setText("");
				idsearch.tf_ssn.setText("");
			}else {
				idsearch.tf_nick.setText("");
				idsearch.tf_ssn.setText("");
				idsearch.showMsg("일치하는정보가 없습니다.");
			}
		}else if (ob == idsearch.bt_cancle) {
			idsearch.setVisible(false);
			loginview.setVisible(true);
		}else if (ob == pwdsearch.bt_submit) {
			String id1 = pwdsearch.tf_id.getText();
			String tel1 = pwdsearch.tf_tel.getText();
			String ssn1 = pwdsearch.tf_ssn.getText();
			MemberDAO dao = new MemberDAO();
			
			String pwd1 = dao.selectpwd(id1,tel1,ssn1);
			if(pwd1 != null) {
				pwdsearch.showMsg("아이디는"+pwd1+"입니다.");
				pwdsearch.tf_id.setText("");
				pwdsearch.tf_tel.setText("");
				pwdsearch.tf_ssn.setText("");
			}else {
				pwdsearch.tf_id.setText("");
				pwdsearch.tf_tel.setText("");
				pwdsearch.tf_ssn.setText("");
				pwdsearch.showMsg("일치하는정보가 없습니다.");
			}
		}else if (ob == pwdsearch.bt_cancle) {
			pwdsearch.setVisible(false);
			loginview.setVisible(true);
			}
		}
			
	public boolean numberCheck(String str) {
		if(str.matches("[\\d]+")) return true;
		return false;
	}

	public boolean emptyCheck(String...str) {
		for(int i=0;i<str.length;i++) {
		if(str[i].trim().length()==0) {
			return true;
		}
		}
		return false;
	}
	
	public boolean iskorean(String str) {
		return str.matches("^[가-힣ㄱ-ㅎㅏ-ㅣ]*$");
 
	}
	
	public static void main(String[] args) {
		new MemberController();
	}

}