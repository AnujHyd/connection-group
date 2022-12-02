package com.facets.connectiongroup.util;

import com.facets.connectiongroup.exception.CustomException;
import com.facets.connectiongroup.model.ConnectionGroup;
import com.facets.connectiongroup.model.VirtualNode;
import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.Set;

@UtilityClass
public class ConnectionGroupUtils {

  /**
   * Fetches a set of all node names from the connection group.
   *
   * @param connectionGroup the connection group
   * @return set of virtual node names.
   */
  public static Set<String> getAllNodes(ConnectionGroup connectionGroup) {
    Set<String> nodeNames = new HashSet<>();
    populate(nodeNames, connectionGroup.getHeadNode());
    return nodeNames;
  }

  private static void populate(Set<String> nodeNames, VirtualNode virtualNode) {
    if (virtualNode == null) {
      return;
    }
    nodeNames.add(virtualNode.getName());

    if (virtualNode.getChildren() != null) {
      for (VirtualNode child : virtualNode.getChildren()) {
        if (nodeNames.contains(child.getName())) {
          throw new CustomException("There are duplicate virtual nodes in your connection group.");
        }
        nodeNames.add(child.getName());
        populate(nodeNames, child);
      }
    }
  }
}
