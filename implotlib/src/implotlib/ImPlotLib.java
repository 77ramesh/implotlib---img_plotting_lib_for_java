package implotlib;

import java.awt.image.BufferedImage;

import img.ImPlotLibImg;

public class ImPlotLib {

	static public enum COLOR_SCALE {
			RGB,
			HSV,
			CMYK
	}
	
	public static void imshow(String title, BufferedImage src) {
		ImPlotLibImg.show(title, src);
	}
	
	public static void plot2D(BufferedImage src, COLOR_SCALE plot) {
		
		switch(plot) {
		
		case RGB:
			plotRGB(src);
			break;
		
		}
	}
	
	private static void plotRGB(BufferedImage src) {
		ImPlotLibImg.plotRGB(src);
	}
}
