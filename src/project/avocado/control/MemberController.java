package project.avocado.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.omg.PortableServer.ServantRetentionPolicyValue;

import project.avocado.view.JoinView;
import project.avocado.view.LoginView;

public class MemberController implements ActionListener{
	JoinView join;
	LoginView login;
	
	public MemberController() {
		join = new JoinView();
		login = new LoginView();
		
		eventup();
	}
	
	
	
	
	
	
	private void eventup() {
		
		//회원가입
		join.submit_bt.addActionListener(this);
		join.cancle_bt.addActionListener(this);
		
		//로그인
		login.bt_login.addActionListener(this);
		login.bt_join.addActionListener(this);
		//회원가입 X처리
		join.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				join.setVisible(false);
				login.setVisible(true);
			}
		});
		//로그인X처리
		login.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				login.setVisible(false);
			}
		});
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob==login.bt_login) {
			
		}else if(ob==login.bt_join) {
			
			join.setVisible(true);
			login.setVisible(false);
		}else if(ob==join.submit_bt) {
			
		}else if(ob==join.cancle_bt){
			join.setVisible(false);
		//}else if(ob==join.overlap_bt){
			
		}else{
		
		}
		
	}



	private void mian() {
		new MemberController();
	}






}
