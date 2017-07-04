package security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Encrypts String data using SpringSecurity BCrypt Algorithm for use in storing user passwords
 */
class Encryption {

    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    static String encryptString(String str) {
        return encoder.encode(str);
    }

    static boolean checkEncryptedStr(String unhashed, String encrypted) {
        return encoder.matches(unhashed, encrypted);
    }
}
