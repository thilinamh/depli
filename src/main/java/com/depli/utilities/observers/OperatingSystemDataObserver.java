package com.depli.utilities.observers;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

/**OperatingSystemDataObserver
 *
 * Depli implementation for initializing observers OperatingSystemMxBean
 * Load operating system monitoring interface of the observers
 *
 * Created by lpsandaruwan on 3/23/17.
 */

public class OperatingSystemDataObserver {

    private JMXConnectionObserver jmxConnectionObserver;
    private OperatingSystemMXBean operatingSystemMXBean;
    private com.depli.data.objects.OperatingSystemData operatingSystemData;

    public OperatingSystemDataObserver(JMXConnectionObserver jmxConnectionObserver) {
        this.jmxConnectionObserver = jmxConnectionObserver;
        this.operatingSystemData = new com.depli.data.objects.OperatingSystemData();
    }

    public OperatingSystemMXBean getOperatingSystemMXBean() {
        return operatingSystemMXBean;
    }

    public com.depli.data.objects.OperatingSystemData getOperatingSystemData() {
        return operatingSystemData;
    }

    // Initialize observers OperatingSystemMXBean
    public OperatingSystemMXBean initialize() throws IOException {
        operatingSystemMXBean = ManagementFactory.newPlatformMXBeanProxy(
                jmxConnectionObserver.getmBeanServerConnection(),
                ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME,
                OperatingSystemMXBean.class
        );

        return operatingSystemMXBean;
    }

    // Refresh and get OperatingSystemDataObserver objects
    public com.depli.data.objects.OperatingSystemData refreshData() {
        operatingSystemData.setData(
                operatingSystemMXBean.getArch(),
                operatingSystemMXBean.getAvailableProcessors(),
                operatingSystemMXBean.getName(),
                operatingSystemMXBean.getVersion()
        );
        return operatingSystemData;
    }
}
