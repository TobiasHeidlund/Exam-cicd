package org.example.examcicd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CryptographyServiceTest {

    CryptographyService cryptographyService;

    @BeforeEach
    void setUp() {
        cryptographyService = new CryptographyService();
    }
    @Test
    void encrypt() {
    }

    @Test
    void decrypt() {
    }



    @Test
    void reversablilityEncode(){
        String s = "Hello World";
        String seed = "Hello Back";

        byte[] value = cryptographyService.encode3(s,seed);
        String result = cryptographyService.decode3(value,seed);

        assertEquals(s,result);
    }
    @Test
    void reversablilityBase64(){
        String s = "Hello World";

        String value = cryptographyService.toBase64(s);
        String result = cryptographyService.fromBase64(value);

        assertEquals(s,result);
    }
}