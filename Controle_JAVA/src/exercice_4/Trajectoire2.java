package exercice_4;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Trajectoire2 extends JFrame {
	private FramePanel framePanel;
	
	public static void main(String[] args) {
		Trajectoire2 trajFrame = new Trajectoire2();
		
		trajFrame.updateLoop();
	}

	public Trajectoire2() {
		this.framePanel = new FramePanel();
		this.add(framePanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
	}

	public void updateLoop() {
		while(true) {
			try {
				TimeUnit.MICROSECONDS.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			framePanel.revalidate();
			framePanel.repaint();
		}
	}
}
