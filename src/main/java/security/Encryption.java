package security;

import org.mindrot.jbcrypt.BCrypt;

class Encryption {

    private static final int WORK_ROUNDS = 12;

    static String encryptString(String str) {
        return BCrypt.hashpw(str, BCrypt.gensalt(WORK_ROUNDS));
    }

    static boolean checkEncryptedStr(String unhashed, String encrypted) {
        return BCrypt.checkpw(unhashed, encrypted);
    }
}
