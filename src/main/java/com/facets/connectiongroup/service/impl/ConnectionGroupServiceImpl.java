package com.facets.connectiongroup.service.impl;

import com.facets.connectiongroup.dao.ConnectionGroupDao;
import com.facets.connectiongroup.exception.CustomException;
import com.facets.connectiongroup.model.ConnectionGroup;
import com.facets.connectiongroup.service.ConnectionGroupService;
import com.facets.connectiongroup.util.ConnectionGroupUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConnectionGroupServiceImpl implements ConnectionGroupService {
  private final ConnectionGroupDao connectionGroupDao;

  @Override
  public void add(ConnectionGroup connectionGroup) {
    Set<String> nodes = ConnectionGroupUtils.getAllNodes(connectionGroup);
    List<ConnectionGroup> connectionGroups = connectionGroupDao.getAll();
    if (connectionGroups.stream()
        .map(ConnectionGroup::getName)
        .anyMatch(connectionGroup.getName()::equals)) {
      throw new CustomException("A connection group with the given name already exists!");
    }
    if (connectionGroups.stream()
        .map(ConnectionGroupUtils::getAllNodes)
        .flatMap(Set::stream)
        .anyMatch(nodes::contains)) {
      throw new CustomException(
          "One of the nodes being added is present in another connection group.");
    }

    connectionGroupDao.add(connectionGroup);
  }

  @Override
  public ConnectionGroup getByVirtualNodeName(String name) {
    return connectionGroupDao.getAll().stream()
        .filter(connectionGroup -> ConnectionGroupUtils.getAllNodes(connectionGroup).contains(name))
        .findAny()
        .orElseThrow(
            () ->
                new CustomException(
                    "Cannot find a connection group containing the given virtual node."));
  }
}
