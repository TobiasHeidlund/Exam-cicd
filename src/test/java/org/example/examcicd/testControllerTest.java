package org.example.examcicd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testControllerTest {

    @Test
    public void verifyFuctionality(){
        org.example.examcicd.MessageRequest mr = new org.example.examcicd.MessageRequest("apa123");

        testController tc = new testController();
        org.example.examcicd.ResponseMessage ec = tc.encodeMessage(mr);
        assertEquals(ec.getResult(),"APA123");
    }

}