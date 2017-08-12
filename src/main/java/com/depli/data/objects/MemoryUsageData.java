package com.depli.data.objects;

import java.lang.management.MemoryUsage;

/**
 * Keeps non persistent MX Bean data
 * 
 * @author Lahiru Pathirage
 * @since 3/24/17
 */

public class MemoryUsageData {

    private final MemoryBlock heapMemory;
    private final MemoryBlock nonHeapMemory;
    private int awaitFinalizationObjectCount;

    public MemoryUsageData() {
        heapMemory = new MemoryBlock();
        nonHeapMemory = new MemoryBlock();
    }

    public void setData(MemoryUsage heapMemory, MemoryUsage nonHeapMemory, int awaitFinalizationObjectCount) {
        this.heapMemory.setData(heapMemory);
        this.nonHeapMemory.setData(nonHeapMemory);
        this.awaitFinalizationObjectCount = awaitFinalizationObjectCount;
    }

    public MemoryBlock getHeapMemory() {
        return heapMemory;
    }

    public MemoryBlock getNonHeapMemory() {
        return nonHeapMemory;
    }

    public int getAwaitFinalizationObjectCount() {
        return awaitFinalizationObjectCount;
    }

    public void setAwaitFinalizationObjectCount(int awaitFinalizationObjectCount) {
        this.awaitFinalizationObjectCount = awaitFinalizationObjectCount;
    }
}

