package seleniumPack;

import org.apache.commons.codec.binary.Base64;

public class Encrypt {

	public static void main(String[] args) {
//		String password = "Reveal@3434";
//		byte[] encodedBytes = Base64.encodeBase64(password.getBytes());
//		System.out.println("encodedBytes "+ new String(encodedBytes));
		
		String password = "UmV2ZWFsQDM0MzQ=";
		byte[] decodedBytes = Base64.decodeBase64(password.getBytes());
		System.out.println("decodedBytes "+ new String(decodedBytes));
	}

}
