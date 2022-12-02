package com.facets.connectiongroup.model;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class VirtualNode {
  @NonNull private String name;
  private List<VirtualNode> children;
}
