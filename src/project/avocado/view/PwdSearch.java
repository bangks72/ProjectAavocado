package project.avocado.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PwdSearch extends JFrame {

	public JTextField tf_id,tf_ssn,tf_tel;
	public JButton bt_submit, bt_cancle;
	JLabel la_id, la_ssn, la_tel;

	public PwdSearch() {
		setTitle("비밀번호찾기");

		tf_id = new JTextField();
		tf_ssn = new JTextField();
		tf_tel = new JTextField();
		

		bt_submit = new JButton("확인");
		bt_cancle = new JButton("취소");

		la_id = new JLabel("아이디");
		la_tel = new JLabel("전화번호");
		la_ssn = new JLabel("생년월일");

		tf_id.setBounds(80, 30, 120, 25);
		tf_tel.setBounds(80, 65, 120, 25);
		tf_ssn.setBounds(80, 100, 120, 25);
		bt_submit.setBounds(20, 150, 80, 25);
		bt_cancle.setBounds(110, 150, 80, 25);
		la_id.setBounds(8, 30, 80, 25);
		la_tel.setBounds(8, 65, 80, 25);
		la_ssn.setBounds(8, 100, 80, 25);

		setLayout(null);
		add(tf_id);
		add(tf_tel);
		add(tf_ssn);
		add(bt_submit);
		add(bt_cancle);
		add(la_id);
		add(la_tel);
		add(la_ssn);

		setBounds(400, 300, 220, 220);
		//setVisible(true);
		setResizable(false);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

	public void initText() {
		tf_id.setText("");
		tf_ssn.setText("");
		tf_tel.setText("");
		tf_id.requestFocus();    	
    }//initText

}