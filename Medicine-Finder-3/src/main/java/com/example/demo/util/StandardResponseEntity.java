package com.example.demo.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class StandardResponseEntity {
    private int code;
    private String message;
    private Object data;
}
