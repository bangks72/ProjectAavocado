package project.avocado.view;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import project.avocado.vo.MemberVO;

public class AdminView extends JFrame {

	public JButton insert_bt;
	public JButton update_bt;
	public JButton del_bt;
	public JButton cancel_bt;
	JTable jt;
	JScrollPane scrol_table;

	JPanel southp;

	DefaultTableModel dtm;

	public AdminView() {
		setTitle("회원관리");

		Object[][] data = new Object[0][6];
		Object[] columnNames = { "아이디", "비밀번호", "닉네임", "전화번호", "주민번호", "이메일"};
		dtm = new DefaultTableModel(data, columnNames);

		jt = new JTable(dtm);
		scrol_table = new JScrollPane(jt);
		insert_bt = new JButton("검색");
		update_bt = new JButton("수정");
		del_bt = new JButton("삭제");
		cancel_bt = new JButton("닫기");

		southp = new JPanel();
		southp.add(insert_bt);
		southp.add(update_bt);
		southp.add(del_bt);
		southp.add(cancel_bt);

		add("Center", scrol_table);
		add("South", southp);

		setBounds(300, 200, 600, 600);
		// setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);

	}// 생성자
	
	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
	
	public String showInput(String msg) {
		return JOptionPane.showInputDialog(this,msg);
	}
	
	
	public void displayTable(List<MemberVO> mv) {
		dtm.setRowCount(0);
		for(int i=0; i<mv.size(); i++) {
			MemberVO vo = mv.get(i);
			Object[]rowData = {vo.getId(),vo.getPwd(),vo.getNick(),vo.getTel(),vo.getSsn(),vo.getEmail()};
			dtm.addRow(rowData);
		}
		

	}

}