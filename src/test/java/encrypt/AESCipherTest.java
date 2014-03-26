package encrypt;

import org.junit.Test;

public class AESCipherTest {

	@Test
	public void test01() throws Exception {
		AESCipher tool = new AESCipher("encrypt/cipher.aes.key.txt", true);
		
		System.out.println(tool.encrypt("1111111111111112"));
	}
}
