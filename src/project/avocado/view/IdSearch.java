package project.avocado.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class IdSearch extends JFrame {

	public JTextField tf_nick,tf_ssn;
	public JButton bt_submit, bt_cancle;
	JLabel la_nick, la_ssn;

	public IdSearch() {
		setTitle("아이디찾기");

		tf_nick = new JTextField();
		tf_ssn = new JTextField();
		

		bt_submit = new JButton("확인");
		bt_cancle = new JButton("취소");

		la_nick = new JLabel("닉네임");
		la_ssn = new JLabel("생년월일");

		tf_nick.setBounds(80, 30, 120, 25);
		tf_ssn.setBounds(80, 65, 120, 25);
		bt_submit.setBounds(20, 110, 80, 25);
		bt_cancle.setBounds(110, 110, 80, 25);
		la_nick.setBounds(8, 30, 80, 25);
		la_ssn.setBounds(8, 65, 90, 25);

		setLayout(null);
		add(tf_nick);
		add(tf_ssn);
		add(bt_submit);
		add(bt_cancle);
		add(la_nick);
		add(la_ssn);

		setBounds(400, 300, 220, 180);
		//setVisible(true);
		setResizable(false);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
	public void initText() {
		tf_nick.setText("");
		tf_ssn.setText("");
    	tf_nick.requestFocus();    	
    }//initText

}