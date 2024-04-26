package my.programmer.monero4j.rpc_client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetBlockHashResponse {
    private String id;
    private String version;
    private String result;

    public GetBlockHashResponse() {
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

    public String getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(String result) {
        this.result = result;
    }
}
