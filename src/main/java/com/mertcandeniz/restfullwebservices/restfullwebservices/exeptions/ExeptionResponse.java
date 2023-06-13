package com.mertcandeniz.restfullwebservices.restfullwebservices.exeptions;

import java.util.Date;

public class ExeptionResponse {

    private Date timeStamp;
    private String message;
    private String details;

    public ExeptionResponse(Date timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
    
}
