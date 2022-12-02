package com.facets.connectiongroup.dao;

import com.facets.connectiongroup.model.ConnectionGroup;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConnectionGroupDao {
  /** Using a simple in-memory List of objects as a datastore. */
  private final List<ConnectionGroup> connectionGroups = new ArrayList<>();

  public void add(ConnectionGroup connectionGroup) {
    connectionGroups.add(connectionGroup);
  }

  public List<ConnectionGroup> getAll() {
    return connectionGroups;
  }
}
