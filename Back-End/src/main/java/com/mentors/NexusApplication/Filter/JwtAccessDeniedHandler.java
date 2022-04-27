package com.mentors.NexusApplication.Filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mentors.NexusApplication.Constants.SecurityConstant;
import com.mentors.NexusApplication.Model.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException exception) throws IOException, ServletException {
        HttpResponse httpResponse = new HttpResponse(
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED,
                HttpStatus.UNAUTHORIZED.getReasonPhrase().toUpperCase(),
                SecurityConstant.FORBIDDEN_MESSAGE);

        httpServletResponse.setContentType(APPLICATION_JSON_VALUE);
        httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
        //Vytvoření outputu
        OutputStream outputStream = httpServletResponse.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(outputStream,httpResponse);
        outputStream.flush();
    }
}
