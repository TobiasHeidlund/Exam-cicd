package org.example.examcicd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CryptographyServiceTest {

    CryptographyService cryptographyService;

    @BeforeEach
    void setUp() {
        cryptographyService = new CryptographyService();
    }
    @Test
    void encryptInvalidInputs() {
        String sNull = null;
        String sEmpty = "";
        String sValid = "Hej";



        NullPointerException StringNullAssertion = assertThrows(NullPointerException.class,()-> cryptographyService.encrypt(sNull, sValid));
        NullPointerException SeedNullAssertion = assertThrows(NullPointerException.class,()-> cryptographyService.encrypt(sValid, sNull));
        NullPointerException StringEmptyAssertion = assertThrows(NullPointerException.class,()-> cryptographyService.encrypt(sEmpty, sValid));
        NullPointerException SeedEmptyAssertion = assertThrows(NullPointerException.class,()-> cryptographyService.encrypt(sValid, sEmpty));


        assertDoesNotThrow(()-> cryptographyService.encrypt(sValid, sValid));
        assertEquals("Input parameters can not be null",StringNullAssertion.getMessage());
        assertEquals("Input parameters can not be null",SeedNullAssertion.getMessage());
        assertEquals("Input parameters can not be empty",StringEmptyAssertion.getMessage());
        assertEquals("Input parameters can not be empty",SeedEmptyAssertion.getMessage());
    }

    @Test
    void decryptInvalidInputs() {
        String sNull = null;
        String sEmpty = "";
        String sValid = "Hej";



        NullPointerException StringNullAssertion = assertThrows(NullPointerException.class,()-> cryptographyService.decrypt(sNull, sValid));
        NullPointerException SeedNullAssertion = assertThrows(NullPointerException.class,()-> cryptographyService.decrypt(sValid, sNull));
        NullPointerException StringEmptyAssertion = assertThrows(NullPointerException.class,()-> cryptographyService.decrypt(sEmpty, sValid));
        NullPointerException SeedEmptyAssertion = assertThrows(NullPointerException.class,()-> cryptographyService.decrypt(sValid, sEmpty));


        assertDoesNotThrow(()-> cryptographyService.decrypt(sValid, sValid));
        assertEquals("Input parameters can not be null",StringNullAssertion.getMessage());
        assertEquals("Input parameters can not be null",SeedNullAssertion.getMessage());
        assertEquals("Input parameters can not be empty",StringEmptyAssertion.getMessage());
        assertEquals("Input parameters can not be empty",SeedEmptyAssertion.getMessage());

    }

    @Test
    void hashInvalidValues(){
        String sNull = null;
        String sEmpty = "";
        String sValid = "Hej";

        NullPointerException NullAssertion = assertThrows(NullPointerException.class,()-> cryptographyService.generateHash(sNull));
        NullPointerException EmptyAssertion = assertThrows(NullPointerException.class,()-> cryptographyService.generateHash(sEmpty));
        int ValidHash = cryptographyService.generateHash(sValid);

        assertEquals("Input parameters can not be null",NullAssertion.getMessage());
        assertEquals("Input parameters can not be empty",EmptyAssertion.getMessage());
        assertNotEquals(ValidHash, 0);
    }

    @Test
    void hashSameValuesEveryTime(){
        String testString1 = "This is a test";
        String testString2 = "This shoud give someting different";

        int hash1 = cryptographyService.generateHash(testString1);
        int hash2 = cryptographyService.generateHash(testString1);
        int hashError = cryptographyService.generateHash(testString2);

        assertEquals(hash1, hash2);
        assertNotEquals(hash1, hashError);
        assertNotEquals(hash2, hashError);
    }

    @Test
    void reversabiltiyOveralll(){
        String testString1 = "This is a test";
        String testString2 = "This shoud give someting different";
        String hash1 = "This is our hash";
        String hash2 = "This is a different hash";
        String encrypted1 = cryptographyService.encrypt(testString1,hash1);
        String decrypted1 = cryptographyService.decrypt(encrypted1,hash1);
        assertEquals(testString1, decrypted1);

    }
      @Test
    void diffrentHashesGivesDiffrentResults(){
        String testString1 = "This is a test";
        String hash1 = "This is our hash";
        String hash2 = "This is a different hash";
        String encrypted1 = cryptographyService.encrypt(testString1,hash1);
        String encrypted2 = cryptographyService.encrypt(testString1,hash2);
        assertNotEquals(encrypted1, encrypted2);

    }
    @Test
     void diffrentStringsGivesDiffrentResults(){
        String testString1 = "This is a test";
        String testString2 = "This shoud give someting different";
        String hash1 = "This is our hash";
        String encrypted1 = cryptographyService.encrypt(testString1,hash1);
        String encrypted2 = cryptographyService.encrypt(testString2,hash1);
        assertNotEquals(encrypted1, encrypted2);


     }



    @Test
    void reversablilityEncode3(){
        String s = "Hello World";
        String seed = "Hello Back";

        byte[] value = cryptographyService.encode3(s,seed);
        String result = cryptographyService.decode3(value,seed);

        assertEquals(s,result);
    }
    @Test
    void reversablilityBase64(){
        byte[] s = "Hello World".getBytes(StandardCharsets.UTF_8);

        String value = cryptographyService.toBase64(s);
        byte[] result = cryptographyService.fromBase64(value);

        assertTrue(Arrays.equals(s,result));
    }
}