package project.avocado.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MainView extends JFrame {

	public JButton bt_play, bt_pause, bt_stop, bt_next, bt_previous, bt_login, bt_toMain, bt_delete, bt_add; // bt_add
	// //bt_search
	// //bt_select
	public JTable table_mylist;
	DefaultTableModel dtm;

	public MainView() {

<<<<<<< HEAD
		Object rowData[][] = new String[0][1];
		Object colNames[] = { "¡¶∏Ò", "∞°ºˆ" };
=======
		JFrame frame = new JFrame("AVOCADO Music Player");
		// setTitle("AVOCADO Music Player");
		frame.addWindowListener(new WindowAdapter() { // JFrame Ï∞Ω Ï¢ÖÎ£å Î¶¨Ïä§ÎÑà
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		JFXPanel panel = new JFXPanel();

		Object colNames[] = { "Ï†úÎ™©", "Í∞ÄÏàò" };
		Object rowData[][] = /* new String[0][1]; */ { { "Î∞ïÌö®Ïã†", "ÎààÏùòÍΩÉ" }, { "Ïù¥Ïàò", "Ïñ¥ÎîîÏóêÎèÑ" }, { "Î≤ÑÏ¶à", "Í∞ÄÏãú" }, };

		TableModel dataModel = new AbstractTableModel() {

			@Override
			public Object getValueAt(int row, int col) {
				return rowData[row][col];
			}

			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				return rowData.length;
			}

			@Override
			public int getColumnCount() {
				return colNames.length;
			}

			/*
			 * public String getColumnName(int column) { return colNames[column]; }
			 */

			public Class getColumnClass(int col) {
				return getValueAt(0, col).getClass();
			}

			public void setValueAt(Object aValue, int row, int column) {
				rowData[row][column] = aValue;
			}
		};

		// dtm = new DefaultTableModel(rowData, colNames);
		table_mylist = new JTable(dataModel);

		table_mylist.addMouseListener(new MouseAdapter() {
			Media m = new Media("file:/c:/love.mp3");
			MediaPlayer p = new MediaPlayer(m);

			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {
					System.out.println(" double click");
					p.play();
>>>>>>> upstream/master

				}
			}
		});

		JScrollPane scrol_table = new JScrollPane(table_mylist);
		scrol_table.setBounds(0, 220, 500, 180);
		bt_play = new JButton("¢∫");
		bt_pause = new JButton("||");
		bt_stop = new JButton("°·");
		// bt_next = new JButton("¥Ÿ¿Ω∞Ó");
		// bt_previous = new JButton("¿Ã¿¸∞Ó");
		bt_login = new JButton("∑Œ±◊¿Œ");
		bt_toMain = new JButton("<");
<<<<<<< HEAD
		bt_delete = new JButton("∏Ò∑œø°º≠ ªË¡¶");
=======
		bt_delete = new JButton("Î™©Î°ùÏóêÏÑú ÏÇ≠Ï†ú");
		bt_add = new JButton("ÎÖ∏Îûò Ï∂îÍ∞Ä");
>>>>>>> upstream/master

		bt_login.setBounds(390, 20, 80, 30);
		bt_toMain.setBounds(20, 20, 45, 30);
		bt_play.setBounds(210, 155, 80, 50);
		bt_pause.setBounds(120, 155, 80, 50);
		bt_stop.setBounds(300, 155, 80, 50);
		bt_delete.setBounds(250, 410, 130, 30);
		bt_add.setBounds(350, 410, 130, 30);

		setLayout(null);
		add(bt_login);
		add(bt_toMain);
		add(bt_play);
		add(bt_pause);
		add(bt_stop);
		add(bt_delete);
		add(bt_add);
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