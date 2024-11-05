package org.example.examcicd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testControllerTest {

    @Test
    public void verifyFuctionality(){
        MessageRequest mr = new MessageRequest("apa123");

        testController tc = new testController();
        ResponseMessage ec = tc.encodeMessage(mr);
        assertEquals(ec.getResult(),"APA123");
    }

}