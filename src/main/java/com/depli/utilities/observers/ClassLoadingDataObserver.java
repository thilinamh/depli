package com.depli.utilities.observers;

import java.io.IOException;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;

/** ClassLoadingDataObserver
 *
 * Depli implementation for loading observers ClassLoadingMXBean
 * Load class loading system management interface of the observers JVM.
 *
 * Created by lpsandaruwan on 3/23/17.
 */

public class ClassLoadingDataObserver {

    private JMXConnectionObserver jmxConnectionObserver;
    private ClassLoadingMXBean classLoadingMXBean;
    private com.depli.data.objects.ClassLoadingData classLoadingData;

    public ClassLoadingDataObserver(JMXConnectionObserver jmxConnectionObserver) {
        this.jmxConnectionObserver = jmxConnectionObserver;
        this.classLoadingData = new com.depli.data.objects.ClassLoadingData();
    }

    public ClassLoadingMXBean getClassLoadingMXBean() {
        return classLoadingMXBean;
    }

    public com.depli.data.objects.ClassLoadingData getClassLoadingData() {
        return classLoadingData;
    }

    // Load observers ClassLoadingMXBean
    public ClassLoadingMXBean initialize() throws IOException {
        classLoadingMXBean = ManagementFactory.newPlatformMXBeanProxy(
                jmxConnectionObserver.getmBeanServerConnection(),
                ManagementFactory.CLASS_LOADING_MXBEAN_NAME,
                ClassLoadingMXBean.class
        );

        return classLoadingMXBean;
    }

    // Refresh and get ClassObjectLoadingData
    public com.depli.data.objects.ClassLoadingData refreshData() {
        classLoadingData.setData(
                classLoadingMXBean.getLoadedClassCount(),
                classLoadingMXBean.getTotalLoadedClassCount(),
                classLoadingMXBean.getUnloadedClassCount()
        );
        return classLoadingData;
    }
}
