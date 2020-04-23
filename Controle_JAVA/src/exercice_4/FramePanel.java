package exercice_4;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FramePanel extends JPanel implements ActionListener{
	private ArrayList<Point> points;
	
	public FramePanel() {
		points = new ArrayList<Point>();
		
		JButton traceButton =  new JButton("tracer");
		traceButton.addActionListener(this);
		this.add(traceButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.revalidate();
		this.repaint();
	}
	
	@Override
    public void paintComponent(Graphics g){
		parseDocument();
        super.paintComponent(g);
        Point previousPoint = points.get(0);
        
        for(Point currentP : points) {
        	g.drawLine(previousPoint.x, previousPoint.y, currentP.x, currentP.y);
        	previousPoint = currentP;
        }
    }
	
	public void parseDocument() {
		points = new ArrayList<Point>();
		Point currentPoint;
		
		try(BufferedReader br = new BufferedReader(new FileReader("positions.txt"))) {
			String line = br.readLine();

			while (line != null) {
				currentPoint = new Point();
				currentPoint.x = Integer.parseInt(line.split(":")[0]);
				currentPoint.y = Integer.parseInt(line.split(":")[1]);
				points.add(currentPoint);
				
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
