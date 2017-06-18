package security;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EncryptionTest {

    private final String TEST_STR = "test";
    private final String TEST_HASH = "$2a$10$OmBiKcqPc1gvbs4eVPuhrOIHfZDoEmWwcp/aN.VvoofATtp1775T2";

    @Test
    public void testEncryptString() {
        String TEST_HASH_GEN = Encryption.encryptString(TEST_STR);
        assertTrue(Encryption.checkEncryptedStr(TEST_STR, TEST_HASH_GEN));
    }

    @Test
    public void testCheckEncryptedStr() {
        assertTrue(Encryption.checkEncryptedStr(TEST_STR, TEST_HASH));
    }
}
