package project.avocado.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminView extends JFrame{
	
	public JButton insert_bt;
	public JButton update_bt;
	public JButton del_bt;
	public JButton cancel_bt;
	JTable jt;
	JScrollPane scrol_table;
	
	JPanel southp;
	
	DefaultTableModel dtm;
	
	public AdminView() {
		setTitle("ȸ������");
		
		Object [][]data = new Object[0][7];
		Object []columnNames= {"���̵�","��й�ȣ","�г���","��ȭ��ȣ","�ֹι�ȣ","�̸���","ȸ����ȣ"};
		dtm = new DefaultTableModel(data, columnNames);
		
		jt = new JTable(dtm);
		scrol_table = new JScrollPane(jt);
		insert_bt = new JButton("�߰�");
		update_bt = new JButton("����");
		del_bt = new JButton("����");
		cancel_bt = new JButton("�ݱ�");
		
		southp = new JPanel();
		southp.add(insert_bt);
		southp.add(update_bt);
		southp.add(del_bt);
		southp.add(cancel_bt);
		
		add("Center",scrol_table);
	    add("South",southp);
		
		setBounds(300,200,600,600);
		//setVisible(true);    
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}//������
	

}
