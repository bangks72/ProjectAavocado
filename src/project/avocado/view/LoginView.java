package project.avocado.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {

	public JTextField tf_id;
	public JPasswordField tf_pass;
	public JButton bt_login, bt_join,  bt_idSearch, bt_pwdSearch;
	JLabel la_id, la_pass;

	public LoginView() {
		setTitle("로그인");

		tf_id = new JTextField();
		tf_pass = new JPasswordField();

		bt_login = new JButton("로그인");
		bt_join = new JButton("신규가입");
		bt_idSearch = new JButton("아이디찾기");
		bt_pwdSearch = new JButton("비밀번호찾기");

		la_id = new JLabel("I  D");
		la_pass = new JLabel("Password");

		tf_id.setBounds(80, 30, 100, 25);
		tf_pass.setBounds(80, 65, 100, 25);
		bt_login.setBounds(90, 110, 80, 25);
		bt_join.setBounds(190, 30, 120, 25);
		bt_idSearch.setBounds(190, 65, 120, 25);
		bt_pwdSearch.setBounds(190, 100, 120, 25);
		la_id.setBounds(8, 30, 80, 25);
		la_pass.setBounds(8, 65, 90, 25);

		setLayout(null);
		add(tf_id);
		add(tf_pass);
		add(bt_login);
		add(bt_join);
		add(bt_idSearch);
		add(bt_pwdSearch);
		add(la_id);
		add(la_pass);

		setBounds(400, 300, 330, 180);
		setVisible(true);
		setResizable(false);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
	public void initText() {
    	tf_id.setText("");
    	tf_pass.setText("");
    	tf_id.requestFocus();    	
    }//initText

}