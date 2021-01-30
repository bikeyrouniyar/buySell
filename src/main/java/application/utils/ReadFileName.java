package application.utils;

import java.io.File;

public class ReadFileName {

	//static final File dir = new File("/home/bikey/houseImage");
	static final File dir = new File("images/");

	public static String[] readFileNames() {
		String[] files;

		files = dir.list();

		return files;
	}
	
	public static void deleteFile(String fileName) {
		try {
			File dir = new File("images/"+fileName);
			dir.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
