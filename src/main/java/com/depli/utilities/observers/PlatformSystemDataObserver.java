package com.depli.utilities.observers;


import com.depli.data.objects.PlatformSystemData;

import java.io.IOException;
import java.lang.management.ManagementFactory;

/** DPEOperatingSystemMXBEan
 *
 * Depli implementation for initializing observers com.sun.management.OperatingSystemMxBean
 * Load operating system monitoring interface of the observers
 *
 * Created by lpsandaruwan on 3/26/17.
 */

public class PlatformSystemDataObserver {

    private JMXConnectionObserver JMXConnectionObserver;
    private PlatformSystemData platformSystemData;

    private com.sun.management.OperatingSystemMXBean peOperatingSystemMXBean;

    public PlatformSystemDataObserver(JMXConnectionObserver JMXConnectionObserver) {
        this.JMXConnectionObserver = JMXConnectionObserver;
        this.platformSystemData = new PlatformSystemData();
    }

    public PlatformSystemData getPlatformSystemData() {
        return platformSystemData;
    }

    public com.sun.management.OperatingSystemMXBean getPeOperatingSystemMXBean() {
        return peOperatingSystemMXBean;
    }

    // Initialize observers sun OperatingSystemMXBean
    public com.sun.management.OperatingSystemMXBean initialize() throws IOException {
        peOperatingSystemMXBean = ManagementFactory.newPlatformMXBeanProxy(
                JMXConnectionObserver.getmBeanServerConnection(),
                ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME,
                com.sun.management.OperatingSystemMXBean.class
        );

        return peOperatingSystemMXBean;
    }

    // Refresh PlatformSystemData
    public PlatformSystemData refreshData() {
        platformSystemData.setData(
                peOperatingSystemMXBean.getSystemCpuLoad(),
                peOperatingSystemMXBean.getFreeSwapSpaceSize(),
                peOperatingSystemMXBean.getFreePhysicalMemorySize(),
                peOperatingSystemMXBean.getProcessCpuLoad(),
                peOperatingSystemMXBean.getTotalPhysicalMemorySize(),
                peOperatingSystemMXBean.getTotalSwapSpaceSize()
        );
        return platformSystemData;
    }
}
