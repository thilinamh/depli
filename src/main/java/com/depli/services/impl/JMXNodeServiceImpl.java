package com.depli.services.impl;

import com.depli.entities.persistent.JMXNode;
import com.depli.repositories.persistent.JMXNodeRepository;
import com.depli.services.JMXNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lpsandaruwan on 3/23/17.
 */

@Service
public class JMXNodeServiceImpl implements JMXNodeService {

    @Autowired
    private JMXNodeRepository jmxNodeRepository;

    @Override
    public List<JMXNode> findAll() {
        return jmxNodeRepository.findAll();
    }

    @Override
    public JMXNode findByNodeId(long nodeId) {
        return jmxNodeRepository.findOne(nodeId);
    }

    @Override
    public void removeByNodeId(long nodeId) {
        jmxNodeRepository.delete(nodeId);
    }

    @Override
    public JMXNode save(JMXNode jmxNode) {
        return jmxNodeRepository.save(jmxNode);
    }
}
