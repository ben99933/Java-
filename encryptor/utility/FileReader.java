package encryptor.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	private FileReader() {
		
	}
	public static String getString(File file) throws FileNotFoundException {
		String valueString = "";
		List<String> list = new ArrayList<String>();
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext()) {
			list.add(scanner.nextLine());
		}
		int len = list.size();
		for(int i = 0;i<len-1;i++) {
			valueString += list.get(i) + "\n";
		}
		valueString += list.get(list.size()-1);
		scanner.close();
		return valueString;
	}

}
