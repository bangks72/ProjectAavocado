package project.avocado.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import project.avocado.view.MainView;
import project.avocado.view.PlayerView;

public class PlayerController implements ActionListener {

	MainView mainview;
	PlayerView playerview;

	Media m;
	MediaPlayer p;

	public PlayerController() {

		mainview = new MainView();
		playerview = new PlayerView();
		m = new Media("file:/c:/love.mp3");
		p = new MediaPlayer(m);
		eventUp();

	}

	public void eventUp() {

		// MainView

		mainview.bt_play.addActionListener(this);
		mainview.bt_pause.addActionListener(this);
		mainview.bt_stop.addActionListener(this);
		// mainview.bt_previous.addActionListener(this);
		// mainview.bt_next.addActionListener(this);
		mainview.bt_login.addActionListener(this);
		mainview.bt_delete.addActionListener(this);
		mainview.bt_toMain.addActionListener(this);

		mainview.table_mylist.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					System.out.println(" double click");
					p.play();
				}
			}
		});

		// PlayerView

		playerview.bt_add.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent mu) {

		Object ob = mu.getSource();

		if (ob == mainview.bt_play) {
			p.play();
		} else if (ob == mainview.bt_pause) {
			p.pause();
		} else if (ob == mainview.bt_stop) {
			p.stop();
		}

		mainview.bt_play.addActionListener(this);
		mainview.bt_pause.addActionListener(this);
		mainview.bt_stop.addActionListener(this);
		// mainview.bt_previous.addActionListener(this);
		// mainview.bt_next.addActionListener(this);
		mainview.bt_login.addActionListener(this);
		mainview.bt_delete.addActionListener(this);
		mainview.bt_toMain.addActionListener(this);

	}

	public static void main(String[] args) {
		new PlayerController();
	}

}