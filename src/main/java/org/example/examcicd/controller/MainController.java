package org.example.examcicd.controller;

import org.example.examcicd.CryptographyService;
import org.example.examcicd.models.MessageRequest;
import org.example.examcicd.models.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    CryptographyService cryptographyService;

    public MainController() {}
    public MainController(CryptographyService cryptographyService) {
        this.cryptographyService = cryptographyService;
    }


    @PostMapping("/Encode")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<ResponseMessage> encodeMessage(@RequestBody MessageRequest request) {
        if(request.getSeed() == null) {return new ResponseEntity<>(new ResponseMessage("Please enter a seed"), HttpStatus.BAD_REQUEST);}
        if(request.getSeed().isBlank()) {return new ResponseEntity<>(new ResponseMessage("Please enter a seed"), HttpStatus.BAD_REQUEST);}
        if(request.getString() == null) {return new ResponseEntity<>(new ResponseMessage("Please enter a string"), HttpStatus.BAD_REQUEST);}
        if(request.getString().isBlank()) {return new ResponseEntity<>(new ResponseMessage("Please enter string"), HttpStatus.BAD_REQUEST);}
        if(request.getString().length()<2) {return new ResponseEntity<>(new ResponseMessage("Please enter string a longer string (min 2 bytes utf-8)"), HttpStatus.BAD_REQUEST);}

        ResponseMessage encodedMessage = new ResponseMessage(cryptographyService.encrypt(request.getString(), request.getSeed()));
        return new ResponseEntity<>(encodedMessage, HttpStatus.OK);
    }

    @PostMapping("/Decode")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<ResponseMessage> decodeMessage(@RequestBody MessageRequest request) {
        if(request.getSeed() == null) {return new ResponseEntity<>(new ResponseMessage("Please enter a seed"), HttpStatus.BAD_REQUEST);}
        if(request.getSeed().isBlank()) {return new ResponseEntity<>(new ResponseMessage("Please enter a seed"), HttpStatus.BAD_REQUEST);}
        if(request.getString() == null) {return new ResponseEntity<>(new ResponseMessage("Please enter a string"), HttpStatus.BAD_REQUEST);}
        if(request.getString().isBlank()) {return new ResponseEntity<>(new ResponseMessage("Please enter string"), HttpStatus.BAD_REQUEST);}

        ResponseMessage decodedMessage = new ResponseMessage(cryptographyService.decrypt(request.getString(), request.getSeed()));
        return new ResponseEntity<>(decodedMessage, HttpStatus.OK);
    }

}

