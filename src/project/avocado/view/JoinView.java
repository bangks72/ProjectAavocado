package project.avocado.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JoinView extends JFrame {

	public JComboBox<String> combo;
	String emailbox[] = { "hamail.com", "gmail.com", "naver.com", "nate.com", "yahoo.co.kr", "hanmir.com", "empal.com ",
			"hitel.net ", "kebi.com ", "netian.com ", "dreamwiz.com", "orgio.net ", "korea.com ", "wail.co.kr ",
			"lycos.co.kr", "chol.com ", "intizen.com", "freechal.com " };
	public JTextField tf_id, tf_nick, tf_tel, tf_ssn, tf_email;
	public JLabel id, pwd, pwd2, nick, tel, ssn, email, whelk;
	public JButton overlap_bt, submit_bt, cancle_bt;
	public JPasswordField tf_pwd, tf_pwd2;
	public JPanel panel;

	GridBagLayout gb;
	GridBagConstraints gbc;

	public JoinView() {

		setTitle("회원가입");
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		// 아이디
		id = new JLabel("아이디:");
		tf_id = new JTextField(20);
		overlap_bt = new JButton("중복확인");
		JPanel idp = new JPanel(new GridLayout());
		idp.add(tf_id);
		idp.add(overlap_bt);

		gbAdd(id, 0, 0, 1, 1);
		gbAdd(idp, 1, 0, 3, 1);

		// 비밀번호
		pwd = new JLabel("비밀번호:");
		tf_pwd = new JPasswordField(20);
		gbAdd(pwd, 0, 1, 0, 1);
		gbAdd(tf_pwd, 1, 1, 0, 1);

		// 비밀번호확인
		pwd2 = new JLabel("비밀번호확인:");
		tf_pwd2 = new JPasswordField(20);
		gbAdd(pwd2, 0, 2, 1, 1);
		gbAdd(tf_pwd2, 1, 2, 3, 1);

		// 닉네임
		nick = new JLabel("닉네임:");
		tf_nick = new JTextField(20);
		gbAdd(nick, 0, 3, 1, 1);
		gbAdd(tf_nick, 1, 3, 3, 1);

		// 전화번호
		tel = new JLabel("전화번호:");
		tf_tel = new JTextField(20);
		gbAdd(tel, 0, 4, 1, 1);
		gbAdd(tf_tel, 1, 4, 3, 1);

		// 생년월일
		ssn = new JLabel("생년월일:");
		tf_ssn = new JTextField(20);
		gbAdd(ssn, 0, 5, 0, 1);
		gbAdd(tf_ssn, 1, 5, 0, 1);

		// 이메일
		email = new JLabel("이메일:");
		tf_email = new JTextField();
		whelk = new JLabel("@");
		combo = new JComboBox<String>(emailbox);
		JPanel ep = new JPanel(new GridLayout());
		ep.add(email);
		ep.add(tf_email);
		ep.add(whelk);
		ep.add(combo);
		gbAdd(ep, 0, 6, 4, 1);

		// 버튼
		panel = new JPanel();
		submit_bt = new JButton("확인");
		cancle_bt = new JButton("취소");
		panel.add(submit_bt);
		panel.add(cancle_bt);
		gbAdd(panel, 0, 7, 4, 1);

		// setVisible(true);
		setSize(350, 500);
	}

	private void gbAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gb.setConstraints(c, gbc);
		gbc.insets = new Insets(3, 3, 3, 3);
		add(c, gbc);
	}// gbAdd

	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
}