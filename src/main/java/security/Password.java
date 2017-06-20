package security;

import util.Constants;

public class Password {

    private static int minLength = Constants.PASSWORD_MIN_LENGTH, maxLength = Constants.PASSWORD_MAX_LENGTH;
    private String passwordHashed;

    public Password(String password) {
        passwordHashed = Encryption.encryptString(password);
    }

    public static void setMinLength(int minLength) {
        Password.minLength = minLength;
    }

    public static void setMaxLength(int maxLength) {
        Password.maxLength = maxLength;
    }

    public String getPassword() {
        return passwordHashed;
    }

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
