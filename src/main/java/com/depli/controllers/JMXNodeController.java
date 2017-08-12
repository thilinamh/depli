package com.depli.controllers;

import com.depli.entities.persistent.JMXNode;
import com.depli.services.JMXNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * JMXNodeController
 * REST API to manage JMX node metadata and credentials.
 * <p>
 * Created by lpsandaruwan on 3/25/17.
 */

@RestController
public class JMXNodeController {

    @Autowired
    private JMXNodeService jmxNodeServiceImpl;

    @RequestMapping(value = "/nodes", method = RequestMethod.GET)
    public List<JMXNode> getAllJMXNodes() {
        return jmxNodeServiceImpl.findAll();
    }

    @RequestMapping(value = "/nodes/{nodeId}", method = RequestMethod.GET)
    public JMXNode getByNodeId(@PathVariable long nodeId) {
        if (jmxNodeServiceImpl.findByNodeId(nodeId) == null) {
            return null;
        }
        return jmxNodeServiceImpl.findByNodeId(nodeId);
    }

    @RequestMapping(value = "/nodes/save", method = RequestMethod.POST)
    public JMXNode saveNodeData(@RequestBody JMXNode jmxNode) {
        return jmxNodeServiceImpl.save(jmxNode);
    }

    @RequestMapping(value = "/nodes/{nodeId}", method = RequestMethod.DELETE)
    public Long deleteByNodeId(@PathVariable long nodeId) {
         jmxNodeServiceImpl.removeByNodeId(nodeId);

         return Long.valueOf(1);
    }
}
