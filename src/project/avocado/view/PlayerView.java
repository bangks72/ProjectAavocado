package project.avocado.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PlayerView extends JFrame {
	public JButton bt_top, bt_latest, bt_add, bt_select, bt_toPlayer;
	public JTable table_chart;
	public JTextField tf_select;
	public JComboBox<String> combo;
	DefaultTableModel dtm;

	public PlayerView() {
		setTitle("AVOCADO Music List");
		Object rowData[][] = new String[0][1];
		Object colNames[] = { "제목", "가수" };

		dtm = new DefaultTableModel(rowData, colNames);
		table_chart = new JTable(dtm);
		JScrollPane scrol_table = new JScrollPane(table_chart);
		scrol_table.setBounds(140, 100, 340, 300);

		tf_select = new JTextField();
		tf_select.setBounds(140, 55, 245, 30);

		bt_select = new JButton("검색");
		bt_top = new JButton("TOP 20");
		bt_latest = new JButton("최신곡");
		bt_add = new JButton("추가하기");
		bt_toPlayer = new JButton(">");

		bt_select.setBounds(395, 55, 80, 30);
		bt_top.setBounds(20, 100, 100, 30);
		bt_latest.setBounds(20, 140, 100, 30);
		bt_add.setBounds(385, 410, 95, 30);
		bt_toPlayer.setBounds(430, 20, 45, 30);

		combo = new JComboBox<>();
		combo.addItem("--장르선택--");
		combo.addItem("발라드");
		combo.addItem("힙합");
		combo.addItem("팝");
		combo.addItem("트로트");
		combo.setBounds(20, 180, 100, 30);

		setLayout(null);
		add(bt_select);
		add(bt_top);
		add(bt_latest);
		add(combo);
		add(bt_add);
		add(bt_toPlayer);
		add(scrol_table);
		add(tf_select);

		setBounds(400, 200, 500, 490);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}