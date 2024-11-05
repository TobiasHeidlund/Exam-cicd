package org.example.examcicd.controller;

import org.example.examcicd.models.MessageRequest;
import org.example.examcicd.models.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {

    @PostMapping("/Encode")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<ResponseMessage> encodeMessage(@RequestBody MessageRequest request) {
        if(request.getSeed() == null) {return new ResponseEntity<>(new ResponseMessage("Please enter a seed"), HttpStatus.BAD_REQUEST);}
        if(request.getSeed().isBlank()) {return new ResponseEntity<>(new ResponseMessage("Please enter a seed"), HttpStatus.BAD_REQUEST);}
        if(request.getString() == null) {return new ResponseEntity<>(new ResponseMessage("Please enter a string"), HttpStatus.BAD_REQUEST);}
        if(request.getString().isBlank()) {return new ResponseEntity<>(new ResponseMessage("Please enter string"), HttpStatus.BAD_REQUEST);}
        String message = request.getString();
        ResponseMessage encodedMessage = new ResponseMessage(encodeLogic(message));
        return new ResponseEntity<>(encodedMessage, HttpStatus.OK);
    }

    @PostMapping("/Decode")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<ResponseMessage> decodeMessage(@RequestBody MessageRequest request) {
        if(request.getSeed() == null) {return new ResponseEntity<>(new ResponseMessage("Please enter a seed"), HttpStatus.BAD_REQUEST);}
        if(request.getSeed().isBlank()) {return new ResponseEntity<>(new ResponseMessage("Please enter a seed"), HttpStatus.BAD_REQUEST);}
        if(request.getString() == null) {return new ResponseEntity<>(new ResponseMessage("Please enter a string"), HttpStatus.BAD_REQUEST);}
        if(request.getString().isBlank()) {return new ResponseEntity<>(new ResponseMessage("Please enter string"), HttpStatus.BAD_REQUEST);}
        String message = request.getString();

        ResponseMessage decodedMessage = new ResponseMessage(encodeLogic(message));
        return new ResponseEntity<>(decodedMessage, HttpStatus.OK);
    }


    private String encodeLogic(String message) {

        return new StringBuilder(message).reverse().toString();
    }
}

