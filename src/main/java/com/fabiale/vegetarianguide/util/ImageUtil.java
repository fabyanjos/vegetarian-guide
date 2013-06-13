package com.fabiale.vegetarianguide.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

@Service
public class ImageUtil {

	public BufferedImage resizeImage(InputStream imageStream) throws IOException {
		BufferedImage originalImage = ImageIO.read(imageStream);
		BufferedImage resizedImage = new BufferedImage(originalImage.getWidth() / 5, originalImage.getHeight() / 5, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, originalImage.getWidth() / 5, originalImage.getHeight() / 5, null);
		g.dispose();

		return resizedImage;
	}
	
	public static void main(String[] args) throws IOException {
		ImageUtil util = new ImageUtil();
		File file = new File("/Users/alefabi/Downloads/P1000192.JPG");
		BufferedImage image = util.resizeImage(new FileInputStream(file));
		ImageIO.write(image, "jpg", new File("/Users/alefabi/Downloads/P1000192_2.JPG"));
		System.out.println("end");
	}
}
