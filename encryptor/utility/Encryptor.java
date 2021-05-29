package encryptor.utility;

public class Encryptor {
	
	private Encryptor() {
		
	}
	public static String enrypt(String string, int key) {
		String ansString = "";
		char c[] = new char[string.length()];
		for(int i = 0;i<c.length;i++) {
			c[i] = (char)(string.charAt(i) + key);
			ansString  = ansString + c[i];
		}
		return ansString;
	}

}
