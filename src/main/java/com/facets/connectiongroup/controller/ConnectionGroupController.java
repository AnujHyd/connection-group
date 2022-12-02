package com.facets.connectiongroup.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/connection-group")
public class ConnectionGroupController {
  @GetMapping
  public Dto healthCheck() {
    Dto dto = new Dto();
    dto.setAbc("abc");
    dto.setDef("def");
    return dto;
  }

  @Getter
  @Setter
  private static class Dto {
    private String abc;
    private String def;
  }
}
