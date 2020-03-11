package img;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import plot.Im2DPlotter;

public abstract class ImPlotLibImg {

	public static void show(String title, BufferedImage src) {
		initFrame(title, src);
	}
	
	private static void initFrame(String title, BufferedImage src) {
		JFrame frame = new JFrame(title);
		frame.setSize(src.getWidth(), src.getHeight());
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel imgPanel = new JPanel();
		imgPanel.setSize(src.getWidth(), src.getHeight());
		frame.add(imgPanel);
		
		JLabel imgLabel = new JLabel();
		imgLabel.setIcon(new ImageIcon(src));
		imgPanel.add(imgLabel);	
	}
	
	public static void plotRGB(BufferedImage src) {
		Im2DPlotter.RGB(src);
	}
}
