package com.nmeo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseMessage {

    public String status;
    public String errorMessage = "";

}
