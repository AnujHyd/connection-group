package com.facets.connectiongroup.service;

import com.facets.connectiongroup.model.ConnectionGroup;

public interface ConnectionGroupService {
  void add(ConnectionGroup connectionGroup);

  ConnectionGroup getByVirtualNodeName(String name);
}
