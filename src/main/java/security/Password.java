package security;

import util.Constants;

/**
 * Stores user password in encrypted format
 */
public class Password {

    private static int minLength = Constants.DEFAULT_PASSWORD_MIN_LENGTH, maxLength = Constants.DEFAULT_PASSWORD_MAX_LENGTH;
    private String passwordHashed;

    /**
     * Stores hashed password
     *
     * @param password
     */
    public Password(String password) {
        passwordHashed = Encryption.encryptString(password);
    }

    public static void setCustomMinLength(int minLength) {
        Password.minLength = minLength;
    }

    public static void setCustomMaxLength(int maxLength) {
        Password.maxLength = maxLength;
    }

    public String getPassword() {
        return passwordHashed;
    }

    /**
     * Randomly generates password of random length between min. and max. using ASCII characters #32-126
     */
    public void generateRandomPassword() {
        StringBuilder stringBuilder = new StringBuilder();
        final int firstAsciiChar = 32;
        final int lastAsciiChar = 126;
        for (int index = 0; index < (int) (Math.random() * ((maxLength - minLength) + 1)) + minLength; index++) {
            stringBuilder.append(Character.toString((char) ((int) (Math.random() * ((lastAsciiChar - firstAsciiChar) + 1)) + firstAsciiChar)));
        }
        passwordHashed = Encryption.encryptString(stringBuilder.toString());
    }
}
