package project.avocado.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import project.avocado.view.JoinView;
import project.avocado.view.LoginView;

public class MemberController implements ActionListener{
	//뷰등록
	JoinView joinview;
	LoginView loginview;
	
	public MemberController() {
		loginview = new LoginView();
		joinview = new JoinView();
		
		eventup();
	}//생성자
	
	private void eventup() {
		//회원가입
		joinview.submit_bt.addActionListener(this);
		joinview.cancle_bt.addActionListener(this);
		
		//로그인
		loginview.bt_login.addActionListener(this);
		loginview.bt_join.addActionListener(this);
		
		//회원가입 X처리
		joinview.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				joinview.setVisible(false);
				loginview.setVisible(true);
			}
		});
		//로그인X처리
		loginview.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				loginview.setVisible(false);
			}
		});
		
		
	}//eventup

	public void actionPerformed(ActionEvent e) {//이벤트처리부
		Object ob = e.getSource();
		
		if(ob==loginview.bt_login) {
			String id = loginview.tf_id.getText();
			String pass = new String(loginview.tf_pass.getPassword());
			
		}else if(ob==loginview.bt_join) {
			
			joinview.setVisible(true);
			loginview.setVisible(false);
		}else if(ob==joinview.submit_bt) {
			String id = joinview.tf_id.getText();
			String pass = joinview.tf_pwd.getText();
			String pass2 = joinview.tf_pwd2.getText();
			String nick = joinview.tf_nick.getText();
			String tel = joinview.tf_tel.getText();
			String ssn = joinview.tf_ssn.getText();
			String email = joinview.tf_email.getText();
			String domain = (String) joinview.combo.getSelectedItem();
			
		}else if(ob==joinview.cancle_bt){
			joinview.setVisible(false);
			loginview.setVisible(true);
		}else if(ob==joinview.overlap_bt){
			String id = joinview.tf_id.getText();
		}else{
		}
		
	}
	
	public static void main(String[] args) {
		new MemberController();
	}






}
