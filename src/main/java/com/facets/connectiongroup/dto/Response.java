package com.facets.connectiongroup.dto;

import com.facets.connectiongroup.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Response<T> {
  private T payload;

  private ResponseStatus status;

  private String errorMessage;

  public static <T> Response<T> success(T payload) {
    return new Response<>(payload, ResponseStatus.SUCCESS, null);
  }

  public static <T> Response<T> failure(String errorMessage) {
    return new Response<>(null, ResponseStatus.FAILURE, errorMessage);
  }
}
