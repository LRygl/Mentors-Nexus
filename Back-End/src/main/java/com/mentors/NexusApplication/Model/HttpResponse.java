package com.mentors.NexusApplication.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.Map;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss", timezone = "Europe/Prague")
    private Date httpTimestamp;
    private int httpStatusCode;
    private HttpStatus httpStatus;
    private String httpStatusReason;
    private String httpStatusMessage;
    private String httpDeveloperMessage;
    private Map<?,?> httpResponseData;
}
