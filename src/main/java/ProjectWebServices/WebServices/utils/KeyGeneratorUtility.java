package ProjectWebServices.WebServices.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

/**
 * Klass som generarar ett RSA-nyckelpar som kan signera och verifiera en JWT (JSON Web Token)
 */

public class KeyGeneratorUtility {

    public static KeyPair generateRSAKey() {
        KeyPair keyPair;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            throw new IllegalStateException();
        }
        return keyPair;
    }
}
