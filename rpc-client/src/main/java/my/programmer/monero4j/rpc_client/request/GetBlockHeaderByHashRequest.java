package my.programmer.monero4j.rpc_client.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetBlockHeaderByHashRequest {
    private String id;
    private String version;
    private String hash;
    private boolean fillPowHash;

    public GetBlockHeaderByHashRequest() {
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

    public String getHash() {
        return hash;
    }

    @JsonProperty("hash")
    public void setHash(String hash) {
        this.hash = hash;
    }

    public boolean isFillPowHash() {
        return fillPowHash;
    }

    @JsonProperty("fill_pow_hash")
    public void setFillPowHash(boolean fillPowHash) {
        this.fillPowHash = fillPowHash;
    }
}
