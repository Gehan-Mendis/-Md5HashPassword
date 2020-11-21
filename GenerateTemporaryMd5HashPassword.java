package generateTemporaryMd5HashPassword;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Random;

import javax.xml.bind.DatatypeConverter;

public class GenerateTemporaryMd5HashPassword {

	private HashMap<String,String> generateTemporaryMd5HashPassword() throws Exception {

		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		HashMap<String,String> tempMd5PasswordMap = new HashMap<String,String>();

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		String tempMd5password = generatedString;
		tempMd5PasswordMap.put("tempMd5password", tempMd5password);

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(tempMd5password.getBytes());
		byte[] digest = md.digest();
		String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();

		tempMd5PasswordMap.put("tempMd5passwordHash", myHash);

		return tempMd5PasswordMap;
	}

}
