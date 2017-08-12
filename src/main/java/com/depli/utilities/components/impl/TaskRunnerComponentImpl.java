package com.depli.utilities.components.impl;

import com.depli.services.JMXNodeService;
import com.depli.utilities.components.DataInitializerComponent;
import com.depli.utilities.components.DataRefresherComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * TaskRunner
 * Make connections to all the JMX nodes using services threads and keep node information updated by polling.
 * <p>
 * Created by lpsandaruwan on 3/22/17.
 */

@Component
public class TaskRunnerComponentImpl implements CommandLineRunner {

    private final DataInitializerComponent dataInitializerComponent;
    private final DataRefresherComponent dataRefresherComponent;

    @Autowired
    private JMXNodeService jmxNodeService;

    public TaskRunnerComponentImpl(DataInitializerComponent dataInitializerComponent, DataRefresherComponent dataRefresherComponent) {
        this.dataInitializerComponent = dataInitializerComponent;
        this.dataRefresherComponent = dataRefresherComponent;
    }

    @Override
    public void run(String... args) throws Exception {
        // Initialize node data map
        dataInitializerComponent.pollInitializeData(jmxNodeService);

        // poll and refresh node data map
        dataRefresherComponent.iterateAndRefreshInstantNodeDataMap();
        dataRefresherComponent.iterateAndRefreshNodeDataMap();
    }
}
