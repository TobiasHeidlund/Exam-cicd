package org.example.examcicd;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class testController {
    @PostMapping("/test")
    public org.example.examcicd.ResponseMessage encodeMessage(@RequestBody org.example.examcicd.MessageRequest request) {
        // Hämta meddelandet från JSON-objektet
        String message = request.getString();
        // Här kan du lägga till kodlogik för att koda meddelandet
        org.example.examcicd.ResponseMessage encodedMessage = new org.example.examcicd.ResponseMessage(message.toUpperCase()); // Anta att encodeLogic är en metod du skapar
        return encodedMessage; // Returnera det kodade meddelandet
    }

    private String encodeLogic(String message) {
        // En enkel kodningslogik, till exempel omvända strängen
        return new StringBuilder(message).reverse().toString();
    }



}

