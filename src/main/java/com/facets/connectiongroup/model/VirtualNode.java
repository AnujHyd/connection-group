package com.facets.connectiongroup.model;

import lombok.Data;

import java.util.List;

@Data
public class VirtualNode {
  private String name;
  private List<VirtualNode> children;
}
