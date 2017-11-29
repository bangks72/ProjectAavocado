package project.avocado.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MusicAdminView extends JFrame {
	public JButton insert_bt;
	public JButton update_bt;
	public JButton del_bt;
	public JButton cancel_bt;
	JTable jt;
	JScrollPane scrol_table;

	JPanel southp;

	DefaultTableModel dtm;

	public MusicAdminView() {
		setTitle("음악관리");

		Object[][] data = new Object[0][5];
		Object[] columnNames = { "곡번호", "곡명", "가수명", "장르", "순위(플레이횟수)" };
		dtm = new DefaultTableModel(data, columnNames);

		jt = new JTable(dtm);
		scrol_table = new JScrollPane(jt);
		insert_bt = new JButton("추가");
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

	}

}