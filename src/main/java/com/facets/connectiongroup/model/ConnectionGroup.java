package com.facets.connectiongroup.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class ConnectionGroup {
  @NonNull private String name;
  @NonNull private VirtualNode headNode;
}
