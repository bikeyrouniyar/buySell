package application.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

@Service
public class ReadFileName {

	static final File dir = new File("/home/bikey/houseImage");

	static final String[] EXTENSIONS = new String[] { "jpg", "png" };
	static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

		@Override
		public boolean accept(final File dir, final String name) {
			for (final String ext : EXTENSIONS) {
				if (name.endsWith("." + ext)) {
					return (true);
				}
			}
			return (false);
		}
	};

//	public static String listImage() {
//		System.out.println("running" + dir);
//
//		if (dir.isDirectory()) {
//			System.out.println("inside is dir");
//			for (final File f : dir.listFiles(IMAGE_FILTER)) {
//				BufferedImage img = null;
//
//				try {
//					System.out.println("inside try");
//					img = ImageIO.read(f);
//					System.out.println("image: " + f.getName());
//
//				} catch (final IOException e) {
//					return null;
//				}
//				return f.getName();
//			}
//		}

//	}

}
