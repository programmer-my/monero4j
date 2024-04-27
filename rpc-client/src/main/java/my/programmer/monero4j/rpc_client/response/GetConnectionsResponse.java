package my.programmer.monero4j.rpc_client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("unused")
public class GetConnectionsResponse {
    public static class Connection {
        private String address;
        private int addressType;
        private int avgDownload;
        private int avgUpload;
        private String connectionId;
        private int currentDownload;
        private int currentUpload;
        private int height;
        private String host;
        private boolean incoming;
        private String ip;
        private int liveTime; // TODO: int or long?
        private boolean localIp;
        private boolean localhost;
        private String peerId;
        private String port;
        private int pruningSeed;
        private int recvCount;
        private int recvIdleTime;
        private int rpcCreditsPerHash;
        private int rpcPort;
        private int sendCount;
        private int sendIdleTime;
        private String state;
        private int supportFlags;

        public Connection() {
        }

        public String getAddress() {
            return address;
        }

        @JsonProperty("address")
        public void setAddress(String address) {
            this.address = address;
        }

        public int getAddressType() {
            return addressType;
        }

        @JsonProperty("address_type")
        public void setAddressType(int addressType) {
            this.addressType = addressType;
        }

        public int getAvgDownload() {
            return avgDownload;
        }

        @JsonProperty("avg_download")
        public void setAvgDownload(int avgDownload) {
            this.avgDownload = avgDownload;
        }

        public int getAvgUpload() {
            return avgUpload;
        }

        @JsonProperty("avg_upload")
        public void setAvgUpload(int avgUpload) {
            this.avgUpload = avgUpload;
        }

        public String getConnectionId() {
            return connectionId;
        }

        @JsonProperty("connection_id")
        public void setConnectionId(String connectionId) {
            this.connectionId = connectionId;
        }

        public int getCurrentDownload() {
            return currentDownload;
        }

        @JsonProperty("current_download")
        public void setCurrentDownload(int currentDownload) {
            this.currentDownload = currentDownload;
        }

        public int getCurrentUpload() {
            return currentUpload;
        }

        @JsonProperty("current_upload")
        public void setCurrentUpload(int currentUpload) {
            this.currentUpload = currentUpload;
        }

        public int getHeight() {
            return height;
        }

        @JsonProperty("height")
        public void setHeight(int height) {
            this.height = height;
        }

        public String getHost() {
            return host;
        }

        @JsonProperty("host")
        public void setHost(String host) {
            this.host = host;
        }

        public boolean isIncoming() {
            return incoming;
        }

        @JsonProperty("incoming")
        public void setIncoming(boolean incoming) {
            this.incoming = incoming;
        }

        public String getIp() {
            return ip;
        }

        @JsonProperty
        public void setIp(String ip) {
            this.ip = ip;
        }

        public int getLiveTime() {
            return liveTime;
        }

        @JsonProperty("live_time")
        public void setLiveTime(int liveTime) {
            this.liveTime = liveTime;
        }

        public boolean isLocalIp() {
            return localIp;
        }

        @JsonProperty("local_ip")
        public void setLocalIp(boolean localIp) {
            this.localIp = localIp;
        }

        public boolean isLocalhost() {
            return localhost;
        }

        @JsonProperty
        public void setLocalhost(boolean localhost) {
            this.localhost = localhost;
        }

        public String getPeerId() {
            return peerId;
        }

        @JsonProperty("peer_id")
        public void setPeerId(String peerId) {
            this.peerId = peerId;
        }

        public String getPort() {
            return port;
        }

        @JsonProperty
        public void setPort(String port) {
            this.port = port;
        }

        public int getPruningSeed() {
            return pruningSeed;
        }

        @JsonProperty("pruning_seed")
        public void setPruningSeed(int pruningSeed) {
            this.pruningSeed = pruningSeed;
        }

        public int getRecvCount() {
            return recvCount;
        }

        @JsonProperty("recv_count")
        public void setRecvCount(int recvCount) {
            this.recvCount = recvCount;
        }

        public int getRecvIdleTime() {
            return recvIdleTime;
        }

        @JsonProperty("recv_idle_time")
        public void setRecvIdleTime(int recvIdleTime) {
            this.recvIdleTime = recvIdleTime;
        }

        public int getRpcCreditsPerHash() {
            return rpcCreditsPerHash;
        }

        @JsonProperty("rpc_credits_per_hash")
        public void setRpcCreditsPerHash(int rpcCreditsPerHash) {
            this.rpcCreditsPerHash = rpcCreditsPerHash;
        }

        public int getRpcPort() {
            return rpcPort;
        }

        @JsonProperty("rpc_port")
        public void setRpcPort(int rpcPort) {
            this.rpcPort = rpcPort;
        }

        public int getSendCount() {
            return sendCount;
        }

        @JsonProperty("send_count")
        public void setSendCount(int sendCount) {
            this.sendCount = sendCount;
        }

        public int getSendIdleTime() {
            return sendIdleTime;
        }

        @JsonProperty("send_idle_time")
        public void setSendIdleTime(int sendIdleTime) {
            this.sendIdleTime = sendIdleTime;
        }

        public String getState() {
            return state;
        }

        @JsonProperty
        public void setState(String state) {
            this.state = state;
        }

        public int getSupportFlags() {
            return supportFlags;
        }

        @JsonProperty("support_flags")
        public void setSupportFlags(int supportFlags) {
            this.supportFlags = supportFlags;
        }
    }

    public static class Result {
        private List<Connection> connections;
        private String status;
        private boolean untrusted;

        public Result() {
        }

        public List<Connection> getConnections() {
            return connections;
        }

        @JsonProperty("connections")
        public void setConnections(List<Connection> connections) {
            this.connections = connections;
        }

        public String getStatus() {
            return status;
        }

        @JsonProperty("status")
        public void setStatus(String status) {
            this.status = status;
        }

        public boolean isUntrusted() {
            return untrusted;
        }

        @JsonProperty("untrusted")
        public void setUntrusted(boolean untrusted) {
            this.untrusted = untrusted;
        }
    }

    private String id;
    private String version;
    private Result result;

    public GetConnectionsResponse() {
    }

    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    @JsonProperty("jsonrpc")
    public void setVersion(String version) {
        this.version = version;
    }

    public Result getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(Result result) {
        this.result = result;
    }
}
