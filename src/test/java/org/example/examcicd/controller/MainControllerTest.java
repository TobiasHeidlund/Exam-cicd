package org.example.examcicd.controller;

import org.example.examcicd.CryptographyService;
import org.example.examcicd.models.MessageRequest;
import org.example.examcicd.models.ResponseMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {

    MainController controller;
    @BeforeEach
    void setUp() {
        controller = new MainController(new CryptographyService());
    }

    @Test
    void encodeInvalidInputs(){
        MessageRequest mStringNull = new MessageRequest(null,"aa");
        MessageRequest mStringEmpty = new MessageRequest("","aa");
        MessageRequest mStringOK = new MessageRequest("aa","aa");
        MessageRequest mSeedNull = new MessageRequest("aa",null);
        MessageRequest mSeedEmpty = new MessageRequest("aa","");
        MessageRequest mSeedOK = new MessageRequest("aa","aa");


        ResponseEntity<ResponseMessage> cStringNull = controller.encodeMessage(mStringNull);
        ResponseEntity<ResponseMessage> cStringEmpty = controller.encodeMessage(mStringEmpty);
        ResponseEntity<ResponseMessage> cStringOK = controller.encodeMessage(mStringOK);
        ResponseEntity<ResponseMessage> cSeedNull = controller.encodeMessage(mSeedNull);
        ResponseEntity<ResponseMessage> cSeedEmpty  = controller.encodeMessage(mSeedEmpty);
        ResponseEntity<ResponseMessage> cSeedOK = controller.encodeMessage(mSeedOK);


        assertNotEquals(cStringNull.getStatusCode() , HttpStatus.OK);
        assertNotEquals(cStringEmpty.getStatusCode(), HttpStatus.OK);
        assertEquals(cStringOK.getStatusCode() , HttpStatus.OK);
        assertNotEquals(cSeedNull.getStatusCode() , HttpStatus.OK);
        assertNotEquals(cSeedEmpty.getStatusCode()  , HttpStatus.OK);
        assertEquals(cSeedOK.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void decodeInvalidInputs(){
        MessageRequest mStringNull = new MessageRequest(null,"aa");
        MessageRequest mStringEmpty = new MessageRequest("","aa");
        MessageRequest mStringOK = new MessageRequest("aa","aa");
        MessageRequest mSeedNull = new MessageRequest("aa",null);
        MessageRequest mSeedEmpty = new MessageRequest("aa","");
        MessageRequest mSeedOK = new MessageRequest("aa","aa");


        ResponseEntity<ResponseMessage> cStringNull = controller.decodeMessage(mStringNull);
        ResponseEntity<ResponseMessage> cStringEmpty = controller.decodeMessage(mStringEmpty);
        ResponseEntity<ResponseMessage> cStringOK = controller.decodeMessage(mStringOK);
        ResponseEntity<ResponseMessage> cSeedNull = controller.decodeMessage(mSeedNull);
        ResponseEntity<ResponseMessage> cSeedEmpty  = controller.decodeMessage(mSeedEmpty);
        ResponseEntity<ResponseMessage> cSeedOK = controller.decodeMessage(mSeedOK);


        assertNotEquals(cStringNull.getStatusCode() , HttpStatus.OK);
        assertNotEquals(cStringEmpty.getStatusCode(), HttpStatus.OK);
        assertEquals(cStringOK.getStatusCode() , HttpStatus.OK);
        assertNotEquals(cSeedNull.getStatusCode() , HttpStatus.OK);
        assertNotEquals(cSeedEmpty.getStatusCode()  , HttpStatus.OK);
        assertEquals(cSeedOK.getStatusCode(), HttpStatus.OK);
    }

}