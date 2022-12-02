package com.facets.connectiongroup.model;

import lombok.Data;

@Data
public class ConnectionGroup {
  private String name;
  private VirtualNode headNode;
}
