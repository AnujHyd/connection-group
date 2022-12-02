package com.facets.connectiongroup.controller;

import com.facets.connectiongroup.dto.Response;
import com.facets.connectiongroup.model.ConnectionGroup;
import com.facets.connectiongroup.service.ConnectionGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/connection-group")
@RequiredArgsConstructor
public class ConnectionGroupController {

  private final ConnectionGroupService connectionGroupService;

  @PostMapping
  public Response<Boolean> add(@RequestBody ConnectionGroup connectionGroup) {
    connectionGroupService.add(connectionGroup);
    return Response.success(Boolean.TRUE);
  }

  @GetMapping
  public Response<ConnectionGroup> get(@RequestParam String virtualNodeName) {
    return Response.success(connectionGroupService.getByVirtualNodeName(virtualNodeName));
  }
}
