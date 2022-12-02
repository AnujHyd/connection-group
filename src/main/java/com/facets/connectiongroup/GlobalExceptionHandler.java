package com.facets.connectiongroup;

import com.facets.connectiongroup.dto.Response;
import com.facets.connectiongroup.exception.CustomException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(CustomException.class)
  @ResponseBody
  public Response<String> handleCustomException(CustomException customException) {
    return Response.failure(customException.getMessage());
  }

  @ExceptionHandler(Exception.class)
  @ResponseBody
  public Response<String> handleException(Exception exception) {
    return Response.failure(exception.getMessage());
  }
}
