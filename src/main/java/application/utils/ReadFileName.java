package application.utils;

import java.io.File;
import java.io.FilenameFilter;

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

	public static String[] readFileNames() {
		String[] files;

		files = dir.list();

		return files;
	}

}
