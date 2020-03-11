package plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Im2DPlotter {

	public static void RGB(BufferedImage src) {
		
		int h = src.getHeight();
		int w = src.getWidth();
		
		//array of colors from image to plot
		int[] r = new int[h*w], g = new int[h*w], b = new int[h*w];
		
		int index = 0;
		
		for(int y=0;y<h;y++) {
			for(int x=0;x<w;x++) {
				
				Color rgb = new Color(src.getRGB(x, y));
				
				r[index] = rgb.getRed();
				g[index] = rgb.getGreen();
				b[index] = rgb.getBlue();
				
			}
		}
		
		initFrame(r, g, b);
		
	}
	
	//plotting frame
	private static void initFrame(int[] r, int[] g, int[] b) {
		
		JFrame frame = new JFrame("Im2DPlotter");
		frame.setSize((2*350), (700));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(new Graph(r, g, b));
	}

}


class Graph extends JPanel {

	private static final long serialVersionUID = 1L;
	
	int[] RVALUES, GVALUES, BVALUES;
	
	//default constructor
	public Graph() {}
	
	public Graph(int[] RVALUES, int[] GVALUES, int[]  BVALUES) {
		this.RVALUES = RVALUES;
		this.GVALUES = GVALUES;
		this.BVALUES = BVALUES;
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		//graph
		g2d.draw(new Line2D.Double(50, 50, 50, 600));
		g2d.draw(new Line2D.Double(50, 600, 600, 600));
		
		partition(g2d);
		drawTexts(g2d);
		
		fillRGB(RVALUES, GVALUES, BVALUES, g2d);
	}
	
	//filing RGB on Frame
	private void fillRGB(int[] r, int[] g, int[] b, Graphics2D g2d) {
		
		//position for every color Space, RGB
		//for R
		int rx = 230;
		int ry = 595;
		
		Random rand = new Random();
		
		g2d.setPaint(Color.RED);
		
		for(int i=0;i<1000;i++) {
			if(r[i] < 50) {
				
				rx = rand.nextInt(200);
				ry = rand.nextInt(50) + 550;
				
				g2d.fill(new Ellipse2D.Double(rx + 50, ry, 2, 2));
			}
		}
		
		//for G
		int gx = 0;
		int gy = 0;
				
		g2d.setPaint(Color.GREEN);
		
		for(int i=0;i<1000;i++) {
			if(g[i] < 50) {
				
				gx = rand.nextInt(200) + 200;
				gy = rand.nextInt(50) + 550;
				
				g2d.fill(new Ellipse2D.Double(gx, gy, 2, 2));
			}
		}
		
	}
	
	//partitioning RGB box and drawing lines
	private void partition(Graphics2D g2d) {
		int times = 1;
		
		//partition for RGB
		for(int i=230;i<=230*3;i+=230) {
			
			if(times != 1)
				i = i - 50;
			g2d.draw(new Line2D.Double(i, 50, i, 600));
			
			times+=1;
		}
		
		int x = 50;
		//height of y-axis - parameter
		//600 - 5
		int y = 595;
		
		//numbers in y-axis
		for(int i=5;i<=255;i+=10) {
			g2d.drawString(String.valueOf(i), x, y);
			
			y = y - 20;
		}
	}
	
	//R G B text on x-axis
	private void drawTexts(Graphics2D g2d) {
		g2d.drawString("R", 165, 615);
		g2d.drawString("G", 380, 615);
		g2d.drawString("B", 595, 615);
	}
	
	
}

