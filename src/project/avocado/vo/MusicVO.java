package project.avocado.vo;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicVO {

	private String mname;
	private String sname;
	private String genre;
	private String rank;
	private String cd;
	private static final int BUFFER_SIZE = 2200;
	private SourceDataLine audioLine;

	public MusicVO(String mname, String sname, String genre, String rank, String cd) {
		super();
		this.mname = mname;
		this.sname = sname;
		this.genre = genre;
		this.rank = rank;
		this.cd = cd;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public MusicVO() {
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	class musicPlay extends Thread {
		// play song function
		public void playSong() {

			try {
				// we have to change the songpath to a URL object
				URL url = new URL("music/love.mp3");
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
				AudioFormat format = audioStream.getFormat();
				DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
				audioLine = (SourceDataLine) AudioSystem.getLine(info);
				audioLine.open(format);
				audioLine.start();

				// song should begin
				System.out.println("Playback started.");

				byte[] bytesBuffer = new byte[BUFFER_SIZE];
				int bytesRead = -1;
				while ((bytesRead = audioStream.read(bytesBuffer)) != -1) {
					audioLine.write(bytesBuffer, 0, bytesRead);
				}

				audioLine.drain();
				audioLine.close();
				audioStream.close();

				// song should end
				System.out.println("Playback completed.");

			} catch (UnsupportedAudioFileException ex) {
				System.out.println("The specified audio file is not supported.");
				ex.printStackTrace();
			} catch (LineUnavailableException ex) {
				System.out.println("Audio line for playing back is unavailable.");
				ex.printStackTrace();
			} catch (IOException ex) {
				System.out.println("Error playing the audio file.");
				ex.printStackTrace();
			}
		}

		public void run() {
			this.playSong();
		}
	}

	public Thread playTheSong() {
		musicPlay mp = new musicPlay();
		mp.start();
		return mp;
	}
	
	public static void main(String[] args) {
		MusicVO vo = new MusicVO();
		vo.playTheSong();
	}


	
}
