package project.avocado.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import project.avocado.view.JoinView;
import project.avocado.view.LoginView;

public class MemberController implements ActionListener{
	//����
	JoinView joinview;
	LoginView loginview;
	
	public MemberController() {
		loginview = new LoginView();
		joinview = new JoinView();
		
		eventup();
	}//������
	
	private void eventup() {
		//ȸ������
		joinview.submit_bt.addActionListener(this);
		joinview.cancle_bt.addActionListener(this);
		
		//�α���
		loginview.bt_login.addActionListener(this);
		loginview.bt_join.addActionListener(this);
		
		//ȸ������ Xó��
		joinview.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				joinview.setVisible(false);
				loginview.setVisible(true);
			}
		});
		//�α���Xó��
		loginview.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				loginview.setVisible(false);
			}
		});
		
		
	}//eventup

	public void actionPerformed(ActionEvent e) {//�̺�Ʈó����
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
