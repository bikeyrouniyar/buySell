package application.utils;

import java.io.File;

public class Text {

	static final File dir = new File("images/");
	
	public static void main(String[] args) {

		String[] pathNames;
		
		pathNames=dir.list();
		
		for(String pathName : pathNames) {
			if(pathName.endsWith("jpg") ||pathName.endsWith("jpeg")) {
			System.out.println(pathName);
			String[] split=pathName.split("_",2);
			System.out.println("split: " + split[0]);
			}
		}
		
		System.out.println(pathNames.length);
		
		
		
		
	}

}
