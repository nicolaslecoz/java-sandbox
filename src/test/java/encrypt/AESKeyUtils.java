package encrypt;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESKeyUtils {

    public static byte[] readKeyFromFilesystem(final String fileName) throws IOException {
        final FileInputStream fis = new FileInputStream(fileName);
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
        final String keyAsString = bufferedReader.readLine();
        final byte[] raw = Base64Coder.decode(keyAsString);

        return raw;
    }

    public static byte[] readKeyFromClasspath(final String file, final ClassLoader cl) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cl.getResourceAsStream(file)));
        final String keyAsString = bufferedReader.readLine();
        final byte[] raw = Base64Coder.decode(keyAsString);

        return raw;
    }

    private static void generateKeyFile(final String fileName) throws FileNotFoundException, NoSuchAlgorithmException, IOException {
        SecretKeySpec KEY;
        FileOutputStream fos = new FileOutputStream(fileName);
        DataOutputStream dos = new DataOutputStream(fos);

        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128); // 192 and 256 bits may not be available

        SecretKey skey = kgen.generateKey();
        byte[] raw = skey.getEncoded();
        KEY = new SecretKeySpec(raw, "AES");
        byte[] key = KEY.getEncoded();

        String encodedString = Base64Coder.encodeBytes(key);

        dos.write(encodedString.getBytes());
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            throw new IllegalArgumentException("Mandatory argument : <fileName>");
        }
        generateKeyFile(args[0]);
    }
}
