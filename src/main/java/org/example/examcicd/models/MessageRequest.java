package org.example.examcicd.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageRequest {

    private String string;
    private String seed;


}
