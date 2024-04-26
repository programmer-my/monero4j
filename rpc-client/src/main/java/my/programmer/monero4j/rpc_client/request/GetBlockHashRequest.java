package my.programmer.monero4j.rpc_client.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetBlockHashRequest {
    private String id;
    private String version;
    private int height;

    public GetBlockHashRequest(int height) {
        this.height = height;
    }

    @JsonProperty("id")
    public String getId() {
        return "0";
    }

    @JsonProperty("jsonrpc")
    public String getVersion() {
        return "2.0";
    }

    @JsonProperty("method")
    public String getMethod() {
        return "on_get_block_hash";
    }

    @JsonProperty("params")
    public List<Integer> getParams() {
        return List.of(height);
    }
}
