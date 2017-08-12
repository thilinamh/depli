package com.depli.utilities.observers;

import com.depli.data.objects.MemoryUsageData;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

/**
 * MemoryDataObserver
 *
 * Depli implementation for loading observers MemoryMXBean
 * Load non persistent management interface of the observers JVM.
 *
 * @author Lahiru Pathirage
 * @since 3/23/17
 */

public class MemoryDataObserver {

    private JMXConnectionObserver jmxConnectionObserver;
    private MemoryMXBean memoryMXBean;
    private MemoryUsageData memoryUsageData;

    public MemoryDataObserver(JMXConnectionObserver jmxConnectionObserver) {
        this.jmxConnectionObserver = jmxConnectionObserver;
        this.memoryUsageData = new MemoryUsageData();
    }

    public MemoryMXBean getMemoryMXBean() {
        return memoryMXBean;
    }

    public MemoryUsageData getMemoryUsageData() {
        return memoryUsageData;
    }

    // Initialize Memory MemoryMXBean connection
    public MemoryMXBean initialize() throws IOException {
        memoryMXBean = ManagementFactory.newPlatformMXBeanProxy(
                jmxConnectionObserver.getmBeanServerConnection(),
                ManagementFactory.MEMORY_MXBEAN_NAME,
                MemoryMXBean.class
        );

        return memoryMXBean;
    }

    // Refresh and get MemoryDataObserver
    public MemoryUsageData refreshData() {
        memoryUsageData.setData(
                memoryMXBean.getHeapMemoryUsage(),
                memoryMXBean.getNonHeapMemoryUsage(),
                memoryMXBean.getObjectPendingFinalizationCount()
        );
        return memoryUsageData;
    }
}
