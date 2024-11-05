package org.example.examcicd;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class testController {
    @PostMapping("/test")
    public ResponseMessage encodeMessage(@RequestBody MessageRequest request) {
        // Hämta meddelandet från JSON-objektet
        String message = request.getString();
        // Här kan du lägga till kodlogik för att koda meddelandet
        ResponseMessage encodedMessage = new ResponseMessage(message.toUpperCase()); // Anta att encodeLogic är en metod du skapar
        return encodedMessage; // Returnera det kodade meddelandet
    }

    private String encodeLogic(String message) {
        // En enkel kodningslogik, till exempel omvända strängen
        return new StringBuilder(message).reverse().toString();
    }



}

