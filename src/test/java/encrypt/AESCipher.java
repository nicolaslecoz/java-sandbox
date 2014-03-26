package encrypt;

import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESCipher {
    private SecretKeySpec keySpec;
    private static final int SALT_LENGTH = 36;

    private AESCipher() {
        super();
    }

    public AESCipher(final String keyfile, final boolean fromClasspath) throws IOException {
        this();
        byte[] rawKey;
        if (fromClasspath) {
            rawKey = AESKeyUtils.readKeyFromClasspath(keyfile, Thread.currentThread().getContextClassLoader());
        } else {
            rawKey = AESKeyUtils.readKeyFromFilesystem(keyfile);
        }
        keySpec = new SecretKeySpec(rawKey, "AES");
    }

    public final String decrypt(final String source) {
        String result = null;
        try {
            Cipher desCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            byte[] ciphertext = Base64Coder.decode(source, Base64Coder.URL_SAFE);
            desCipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] cleartext = desCipher.doFinal(ciphertext);
            String decrypted = new String(cleartext);
            result = decrypted.substring(SALT_LENGTH + 1, decrypted.length() - SALT_LENGTH - 1);
        } catch (Exception e) {
        }
        return result;
    }

    public final String encrypt(String source) {
        String result = null;
        try {
            source = getSalt() + "/" + source + "/" + getSalt();
            Cipher desCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            desCipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] cleartext = source.getBytes();
            byte[] ciphertext = desCipher.doFinal(cleartext);
            result = Base64Coder.encodeBytes(ciphertext, Base64Coder.URL_SAFE);
        } catch (Exception e) {
        }
        return result;
    }

    private static String getSalt() {
        return java.util.UUID.randomUUID().toString();
    }
}
