package security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Encrypts String data using SpringSecurity BCrypt Algorithm for use in storing user passwords
 */
class Encryption {

    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * Encrypts String using BCrypt
     *
     * @param str to encrypt
     * @return encrypted String
     */
    static String encryptString(String str) {
        return encoder.encode(str);
    }

    /**
     * Verifies if unhashed, raw string is equal to encrypted string and returns boolean
     *
     * @param unhashed string
     * @param encrypted string typically obtained from db
     * @return true if unhashed is equal to encrypted string's original text value
     */
    static boolean checkEncryptedStr(String unhashed, String encrypted) {
        return encoder.matches(unhashed, encrypted);
    }
}
