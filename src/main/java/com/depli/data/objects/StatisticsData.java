package com.depli.data.objects;

import java.util.concurrent.TimeUnit;

/**
 * Created by lpsandaruwan on 3/26/17.
 */

public class StatisticsData {
    // jmx node status
    private boolean isConnected;

    // class loading data
    private int loadedClassCount;

    // cpu loading data
    private float jvmCpuUsage;
    private float[] JvmCpuUsageData;

    // memory loading data
    private float usedHeapMemory;
    private float usedNonHeapMemory;

    // runtime data
    private String jvmUptime;

    // thread loading data
    private int daemonThreadCount;
    private int peakThreadCount;
    private int liveThreadCount;
    private long totalStartedThreadCount;

    // host operating system data
    private float hostCpuUsage;
    private float[] hostCpuUsageData;

    private float hostFreePhysicalMemory;
    private float hostTotalPhysicalMemory;

    public StatisticsData() {
        this.JvmCpuUsageData = new float[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        this.hostCpuUsageData = new float[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        this.isConnected = false;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    public int getLoadedClassCount() {
        return loadedClassCount;
    }

    public void setLoadedClassCount(int loadedClassCount) {
        this.loadedClassCount = loadedClassCount;
    }

    public float getUsedHeapMemory() {
        return usedHeapMemory;
    }

    public void setUsedHeapMemory(float usedHeapMemory) {
        this.usedHeapMemory = usedHeapMemory;
    }

    public float getUsedNonHeapMemory() {
        return usedNonHeapMemory;
    }

    public void setUsedNonHeapMemory(float usedNonHeapMemory) {
        this.usedNonHeapMemory = usedNonHeapMemory;
    }

    public int getDaemonThreadCount() {
        return daemonThreadCount;
    }

    public void setDaemonThreadCount(int daemonThreadCount) {
        this.daemonThreadCount = daemonThreadCount;
    }

    public int getPeakThreadCount() {
        return peakThreadCount;
    }

    public void setPeakThreadCount(int peakThreadCount) {
        this.peakThreadCount = peakThreadCount;
    }

    public int getLiveThreadCount() {
        return liveThreadCount;
    }

    public void setLiveThreadCount(int liveThreadCount) {
        this.liveThreadCount = liveThreadCount;
    }

    public long getTotalStartedThreadCount() {
        return totalStartedThreadCount;
    }

    public void setTotalStartedThreadCount(long totalStartedThreadCount) {
        this.totalStartedThreadCount = totalStartedThreadCount;
    }

    public float getHostCpuUsage() {
        return hostCpuUsage;
    }

    public void setHostCpuUsage(float hostCpuUsage) {
        this.hostCpuUsage = hostCpuUsage;

        // update host cpu usage data array
        int index = 1;

        while (index < hostCpuUsageData.length) {
            hostCpuUsageData[index - 1] = hostCpuUsageData[index];
            index++;
        }

        hostCpuUsageData[index - 1] = hostCpuUsage;
    }

    public float getHostFreePhysicalMemory() {
        return hostFreePhysicalMemory;
    }

    public void setHostFreePhysicalMemory(float hostFreePhysicalMemory) {
        this.hostFreePhysicalMemory = hostFreePhysicalMemory;
    }

    public float getHostTotalPhysicalMemory() {
        return hostTotalPhysicalMemory;
    }

    public void setHostTotalPhysicalMemory(float hostTotalPhysicalMemory) {
        this.hostTotalPhysicalMemory = hostTotalPhysicalMemory;
    }

    public String getJvmUptime() {
        return jvmUptime;
    }

    public void setJvmUptime(long jvmUptime) {
        this.jvmUptime = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(jvmUptime),
                TimeUnit.MILLISECONDS.toMinutes(jvmUptime) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(jvmUptime) % TimeUnit.MINUTES.toSeconds(1));
    }

    public float getJvmCpuUsage() {
        return jvmCpuUsage;
    }

    public float[] getJvmCpuUsageData() {
        return JvmCpuUsageData;
    }

    public void setJvmCpuUsageData(float jvmCpuUsage) {
        this.jvmCpuUsage = jvmCpuUsage;

        // update cpu usage data array
        int index = 1;

        while (index < JvmCpuUsageData.length) {
            JvmCpuUsageData[index - 1] = JvmCpuUsageData[index];
            index++;
        }

        JvmCpuUsageData[index - 1] = jvmCpuUsage;
    }

    public float[] getHostCpuUsageData() {
        return hostCpuUsageData;
    }
}
