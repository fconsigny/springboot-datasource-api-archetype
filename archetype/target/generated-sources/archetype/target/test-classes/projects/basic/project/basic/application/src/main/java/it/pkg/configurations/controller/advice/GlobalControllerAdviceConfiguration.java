package it.pkg.configurations.controller.advice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerAdviceConfiguration {

    // Example of a Global Handler
    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<GlobalErrorInfo> handleItemIdAlreadyExists(HttpServletRequest req, Exception ex) {
        GlobalErrorInfo errorInfo = new GlobalErrorInfo(req.getRequestURI(), ex);
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

}
