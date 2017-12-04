package project.avocado.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MypageView extends JFrame{
	
	public JLabel ticketImg,sub_title;
	public JButton pay_bt, paylog_bt, infoCorrect_bt, withdraw_bt, logout_bt;
	
	public MypageView() {
		setTitle("마이페이지");
		setLayout(null);
		//label
//		public void setSubtitle(String nick) {
//			
//		}메소드필요
		sub_title=new JLabel("...님의 마이페이지");
		add(sub_title);
		sub_title.setBounds(50, 10, 150, 80);
		//이미지
//		ticketImg=new JLabel(new ImageIcon("src"));//메소드필요
		ticketImg=new JLabel("imgimgimgimgimgimg");
		add(ticketImg);
		ticketImg.setBounds(50, 100, 300, 250);
		
		//버튼
		pay_bt=new JButton("결제");
		paylog_bt=new JButton("결제정보");
		infoCorrect_bt=new JButton("정보수정");
		logout_bt=new JButton("로그아웃");
		withdraw_bt=new JButton("회원탈퇴");
		add(pay_bt);
		add(paylog_bt);
		add(infoCorrect_bt);
		add(logout_bt);
		add(withdraw_bt);
		pay_bt.setBounds(50, 250, 230, 40);
		paylog_bt.setBounds(50, 250, 230, 40);
		infoCorrect_bt.setBounds(50, 290, 230, 40);
		logout_bt.setBounds(50, 330, 230, 40);
		withdraw_bt.setBounds(50, 370, 230, 40);
		
		
		// setVisible(true);
		setSize(350, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}//생성자
	
	
	public static void main(String[] args) {
		new MypageView();
	}
	
}
