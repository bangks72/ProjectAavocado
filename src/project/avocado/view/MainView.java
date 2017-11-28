package project.avocado.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainView extends JFrame {

	public JButton bt_play, bt_pause, bt_stop, bt_next, bt_previous, bt_login, bt_toMain, bt_delete; // bt_add
																										// //bt_search
																										// //bt_select
	public JTable table_mylist;
	DefaultTableModel dtm;

	public MainView() {
		setTitle("AVOCADO Music Player");

		Object rowData[][] = new String[0][1];
		Object colNames[] = { "제목", "가수" };

		dtm = new DefaultTableModel(rowData, colNames);
		table_mylist = new JTable(dtm);

		JScrollPane scrol_table = new JScrollPane(table_mylist);
		scrol_table.setBounds(0, 220, 500, 180);
		bt_play = new JButton("▶");
		bt_pause = new JButton("||");
		bt_stop = new JButton("■");
		// bt_next = new JButton("다음곡");
		// bt_previous = new JButton("이전곡");
		bt_login = new JButton("로그인");
		bt_toMain = new JButton("<");
		bt_delete = new JButton("목록에서 삭제");

		bt_login.setBounds(390, 20, 80, 30);
		bt_toMain.setBounds(20, 20, 45, 30);
		bt_play.setBounds(210, 155, 80, 50);
		bt_pause.setBounds(120, 155, 80, 50);
		bt_stop.setBounds(300, 155, 80, 50);
		bt_delete.setBounds(350, 410, 130, 30);

		setLayout(null);
		add(bt_login);
		add(bt_toMain);
		add(bt_play);
		add(bt_pause);
		add(bt_stop);
		add(bt_delete);
		add(scrol_table);

		setBounds(900, 200, 500, 490);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new MainView();
		new PlayerView();
	}

}