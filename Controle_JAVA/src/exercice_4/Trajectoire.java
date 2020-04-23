package exercice_4;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Trajectoire extends JFrame {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Trajectoire trajFrame = new Trajectoire();
	}

	public Trajectoire() {
		this.add(new FramePanel());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
	}
}
