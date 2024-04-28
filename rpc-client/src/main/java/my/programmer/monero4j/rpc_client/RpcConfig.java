package my.programmer.monero4j.rpc_client;

@SuppressWarnings("unused")
public class RpcConfig {
    private String ip;
    private String port;
    private String username;
    private String password;

    public RpcConfig(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }

    public RpcConfig(String ip, String port, String username, String password) {
        this.ip = ip;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String getIpAddress() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
