package encryptor.utility;

import java.io.File;

import javax.swing.JFileChooser;

public class FileChooser {

	private FileChooser() {
		
	}
	public static File chooseFile() {
		File selectedFile = null;
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(fileChooser);
		if(returnValue == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
		}
		return selectedFile;
	}
}
