package project.avocado.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.avocado.view.MainView;
import project.avocado.view.PlayerView;

public class PlayerController implements ActionListener {
	
	MainView mainview;
	PlayerView playerview;
	
	public PlayerController() {
		
		mainview = new MainView();
		playerview = new PlayerView();
		
		eventUp();
		
	}
	
	
	
	
	public void eventUp() {
		
		//MainView 
		
		mainview.bt_play.addActionListener(this);
		mainview.bt_pause.addActionListener(this);
		mainview.bt_stop.addActionListener(this);
		mainview.bt_previous.addActionListener(this);
		mainview.bt_next.addActionListener(this);
		mainview.bt_login.addActionListener(this);
		mainview.bt_delete.addActionListener(this);
		mainview.bt_toMain.addActionListener(this);
		
		//PlayerView
		
		playerview.bt_add.addActionListener(this);
		playerview.bt_add.addActionListener(this);
		playerview.bt_add.addActionListener(this);
		playerview.bt_add.addActionListener(this);
		playerview.bt_add.addActionListener(this);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent mu) {
		
		Object ob = mu.getSource();
		
		if(ob == mainview.bt_play) {
			
		} 
		
	}

	public static void main(String[] args) {
		new PlayerController();
	}
	
}
