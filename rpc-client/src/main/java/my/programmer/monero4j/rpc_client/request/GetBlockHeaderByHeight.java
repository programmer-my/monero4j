package my.programmer.monero4j.rpc_client.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class GetBlockHeaderByHeight {
    private String id;
    private String version;
    // TODO: int or long?
    private Map<String, Object> params = new HashMap<>();

    public GetBlockHeaderByHeight() {
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

    public Map<String, Object> getParams() {
        return params;
    }

    @JsonProperty("params")
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public int getHeight() {
        return (int) this.params.get("height");
    }

    public void setHeight(int height) {
        this.params.put("height", height);
    }

    public boolean isFillPowHash() {
        return (boolean) this.params.get("fill_pow_hash");
    }

    public void setFillPowHash(boolean fillPowHash) {
        this.params.put("fill_pow_hash", fillPowHash);
    }
}
