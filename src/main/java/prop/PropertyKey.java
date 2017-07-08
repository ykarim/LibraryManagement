package prop;


public enum PropertyKey {

    PORT("PORT"),
    MIN_PASS_LENGTH("MIN_PASSWORD_LENGTH"),
    MAX_PASS_LENGTH("MAX_PASSWORD_LENGTH"),
    COMPANY_NAME("COMPANY_NAME");

    private String key;

    PropertyKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
