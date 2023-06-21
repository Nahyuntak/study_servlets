package com.example.study_servlets.controlls;

import java.util.UUID;

public class Commons {

    public String generateUUID() {
        return UUID.randomUUID().toString();
    }

}
