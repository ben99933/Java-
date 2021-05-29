package encryptor.utility;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class ClipBoardUtility {
	
	private ClipBoardUtility(){
		
	}
	public static void CopyToClipBoard(String string) {
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();  
        Transferable tText = new StringSelection(string);  
        clip.setContents(tText, null); 
	}

}
