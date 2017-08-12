package com.depli.data.objects;

/**
 * PlatformSystemData
 * Platform extension operating system data. Keeps host operating system's statistics data.
 * <p>
 * Created by lpsandaruwan on 3/28/17.
 */

public class PlatformSystemData {

    private float hostCpuUsage;
    private float freePhysicalMemory;
    private float freeSwapSpace;
    private float jvmCpuUsage;
    private float totalPhysicalMemory;
    private float totalSwapSpace;

    // default constructor
    public PlatformSystemData() {
    }

    public void setData(double hostCpuUsage,
                        long freeSwapSpace,
                        long freePhysicalMemory,
                        double jvmCpuUsage,
                        long totalPhysicalMemory,
                        long totalSwapSpace) {
        if (hostCpuUsage == -1) {
            this.hostCpuUsage = -1;
        } else {
            this.hostCpuUsage = Math.round(hostCpuUsage * 100f * 10f) / 10f;
        }

        if (freeSwapSpace == -1) {
            this.freeSwapSpace = -1;
        } else {
            this.freeSwapSpace = Math.round((freeSwapSpace / (1024f * 1024f)) * 10f) / 10f;
        }

        if (freePhysicalMemory == -1) {
            this.freePhysicalMemory = -1;
        } else {
            this.freePhysicalMemory = Math.round((freePhysicalMemory / (1024f * 1024f)) * 10f) / 10f;
        }

        if (jvmCpuUsage == -1) {
            this.jvmCpuUsage = -1;
        } else {
            this.jvmCpuUsage = Math.round(jvmCpuUsage * 10f) / 10f;
        }

        if (totalPhysicalMemory == -1) {
            this.totalPhysicalMemory = -1;
        } else {
            this.totalPhysicalMemory = Math.round((totalPhysicalMemory / (1024f * 1024f)) * 10f) / 10f;
        }

        if (totalSwapSpace == -1) {
            this.totalSwapSpace = -1;
        } else {
            this.totalSwapSpace = Math.round((totalSwapSpace / (1024f * 1024f)) * 10f) / 10f;
        }
    }

    public float getHostCpuUsage() {
        return hostCpuUsage;
    }

    public void setHostCpuUsage(float hostCpuUsage) {
        this.hostCpuUsage = hostCpuUsage;
    }

    public float getFreeSwapSpace() {
        return freeSwapSpace;
    }

    public void setFreeSwapSpace(float freeSwapSpace) {
        this.freeSwapSpace = freeSwapSpace;
    }

    public float getFreePhysicalMemory() {
        return freePhysicalMemory;
    }

    public void setFreePhysicalMemory(float freePhysicalMemory) {
        this.freePhysicalMemory = freePhysicalMemory;
    }

    public float getJvmCpuUsage() {
        return jvmCpuUsage;
    }

    public void setJvmCpuUsage(float jvmCpuUsage) {
        this.jvmCpuUsage = jvmCpuUsage;
    }

    public float getTotalPhysicalMemory() {
        return totalPhysicalMemory;
    }

    public void setTotalPhysicalMemory(float totalPhysicalMemory) {
        this.totalPhysicalMemory = totalPhysicalMemory;
    }

    public float getTotalSwapSpace() {
        return totalSwapSpace;
    }

    public void setTotalSwapSpace(float totalSwapSpace) {
        this.totalSwapSpace = totalSwapSpace;
    }
}
