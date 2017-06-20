package security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class Encryption {

    private static final int WORK_ROUNDS = 12;
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    static String encryptString(String str) {
        return encoder.encode(str);
    }

    static boolean checkEncryptedStr(String unhashed, String encrypted) {
        return encoder.matches(unhashed, encrypted);
    }
}
