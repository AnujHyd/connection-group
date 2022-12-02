package com.facets.connectiongroup.dao;

import com.facets.connectiongroup.model.ConnectionGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class ConnectionGroupDao {
    private final Map<String, ConnectionGroup> nameConnectionGroupMap = new HashMap<>();

    public void add(String name, ConnectionGroup connectionGroup) {
        nameConnectionGroupMap.put(name, connectionGroup);
    }

    public ConnectionGroup getByName(String name) {
        return nameConnectionGroupMap.get(name);
    }


}
