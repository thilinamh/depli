package com.depli.data.objects;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

/**
 * Keeps runtime MX Bean data
 * <p>
 * Created by lpsandaruwan on 3/24/17.
 */

public class RuntimeData {

    private String[] bootstrapClassPath;
    private String[] systemClassPath;
    private List<String> inputArguments;
    private String[] javaLibraryPath;
    private String managementInterfaceVersion;
    private String runningJvmName;
    private String jvmStartTime;
    private String jvmName;
    private String jvmVendor;
    private String jvmVersion;

    // default constructor
    public RuntimeData() {
    }

    public void setData(String bootstrapClassPath,
                        String systemClassPath,
                        List<String> inputArguments,
                        String javaLibraryPath,
                        String managementInterfaceVersion,
                        String runningJvmName,
                        long jvmStartTime,
                        String jvmName,
                        String jvmVendor,
                        String jvmVersion) {
        this.bootstrapClassPath = bootstrapClassPath.split(":", -1);
        this.systemClassPath = systemClassPath.split(":", -1);
        this.inputArguments = inputArguments;
        this.javaLibraryPath = javaLibraryPath.split("::", -1);
        this.managementInterfaceVersion = managementInterfaceVersion;
        this.runningJvmName = runningJvmName;
        this.jvmStartTime = String.valueOf(LocalDateTime.ofInstant(Instant.ofEpochMilli(jvmStartTime), ZoneId.systemDefault())).replace("T", " ");
        this.jvmName = jvmName;
        this.jvmVendor = jvmVendor;
        this.jvmVersion = jvmVersion;
    }

    public String[] getBootstrapClassPath() {
        return bootstrapClassPath;
    }

    public void setBootstrapClassPath(String[] bootstrapClassPath) {
        this.bootstrapClassPath = bootstrapClassPath;
    }

    public String[] getSystemClassPath() {
        return systemClassPath;
    }

    public void setSystemClassPath(String[] systemClassPath) {
        this.systemClassPath = systemClassPath;
    }

    public List<String> getInputArguments() {
        return inputArguments;
    }

    public void setInputArguments(List<String> inputArguments) {
        this.inputArguments = inputArguments;
    }

    public String[] getJavaLibraryPath() {
        return javaLibraryPath;
    }

    public void setJavaLibraryPath(String[] javaLibraryPath) {
        this.javaLibraryPath = javaLibraryPath;
    }

    public String getManagementInterfaceVersion() {
        return managementInterfaceVersion;
    }

    public void setManagementInterfaceVersion(String managementInterfaceVersion) {
        this.managementInterfaceVersion = managementInterfaceVersion;
    }

    public String getRunningJvmName() {
        return runningJvmName;
    }

    public void setRunningJvmName(String runningJvmName) {
        this.runningJvmName = runningJvmName;
    }

    public String getJvmStartTime() {
        return jvmStartTime;
    }

    public void setJvmStartTime(String jvmStartTime) {
        this.jvmStartTime = jvmStartTime;
    }

    public String getJvmName() {
        return jvmName;
    }

    public void setJvmName(String jvmName) {
        this.jvmName = jvmName;
    }

    public String getJvmVendor() {
        return jvmVendor;
    }

    public void setJvmVendor(String jvmVendor) {
        this.jvmVendor = jvmVendor;
    }

    public String getJvmVersion() {
        return jvmVersion;
    }

    public void setJvmVersion(String jvmVersion) {
        this.jvmVersion = jvmVersion;
    }
}
