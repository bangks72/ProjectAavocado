package project.avocado.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminMainView extends JFrame{
	
	public JButton music_bt,member_bt;
	JPanel panel;
	
	public AdminMainView() {
		setTitle("包府磊");
	music_bt = new JButton("澜厩包府");
	member_bt = new JButton("雀盔包府");
	
	music_bt.setBounds(30, 130, 220, 50);
	member_bt.setBounds(30, 30, 220, 50);
	
	
	panel = new JPanel();
	panel.setLayout(null);
	panel.add(music_bt);
	panel.add(member_bt);
	
	add(panel);
	
	setBounds(300,300,300,300);
	//setVisible(true);
	}

}
