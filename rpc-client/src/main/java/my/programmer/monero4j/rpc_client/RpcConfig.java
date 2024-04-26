package my.programmer.monero4j.rpc_client;

import java.net.InetAddress;

public class RpcConfig {
    private String ip;
    private String port;

    public RpcConfig(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIpAddress() {
        return ip;
    }

    public String getPort() {
        return port;
    }
}
