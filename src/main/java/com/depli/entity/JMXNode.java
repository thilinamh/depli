package com.depli.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by lpsandaruwan on 3/22/17.
 */

@Entity
@Table(name = "jmx_nodes")
public class JMXNode {

    @Column(name = "node_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long nodeId;

    @Column(name = "node_name")
    @NotNull
    @Size(max = 30)
    private String nodeName;

    @Column(name = "hostname")
    @NotNull
    @Size(max = 50)
    private String hostname;

    @Column(name = "port")
    @NotNull
    private int port;

    @Column(name="auth_required")
    @NotNull
    private boolean authRequired;

    @Column(name = "ssl_required")
    @NotNull
    private boolean sslRequired;

    @Column(name="username")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(max = 50)
    private String username;

    @Column(name="password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(max = 50)
    private String password;

    protected JMXNode() {}

    public JMXNode(String nodeName,
                   String hostname,
                   int port,
                   boolean authRequired,
                   boolean sslRequired) {
        this.nodeName = nodeName;
        this.hostname = hostname;
        this.port = port;
        this.authRequired = authRequired;
        this.sslRequired = sslRequired;
    }

    public long getNodeId() {
        return nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public String getHostname() {
        return hostname;
    }

    public Integer getPort() {
        return port;
    }

    public boolean isAuthRequired() {
        return authRequired;
    }

    public boolean isSslRequired() {
        return sslRequired;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setAuthRequired(boolean authRequired) {
        this.authRequired = authRequired;
    }

    public void setSslRequired(boolean sslRequired) {
        this.sslRequired = sslRequired;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
