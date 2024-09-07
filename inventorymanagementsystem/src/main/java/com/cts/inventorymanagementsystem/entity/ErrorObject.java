package com.cts.inventorymanagementsystem.entity;

import java.util.Date;

import lombok.Data;

@Data

public class ErrorObject {

    public Integer statusCode;

    public String message;

    public Date timestamp;

}

