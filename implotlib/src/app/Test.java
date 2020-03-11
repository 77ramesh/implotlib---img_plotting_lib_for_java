package app;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import implotlib.ImPlotLib;
import plot.Im2DPlotter;

public class Test {

	public static void main(String[] args) throws IOException {
		
		BufferedImage src = ImageIO.read(new File("C:\\Users\\Ramesh\\Desktop\\sun.jpg"));
		ImPlotLib.imshow("Negative", src);
		
		//ImPlotLib.plot2D(src, ImPlotLib.COLOR_SCALE.RGB);
	}

}
