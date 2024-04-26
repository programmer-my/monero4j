package my.programmer.monero4j.rpc_client.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericRequest {
    String id;
    String version;
    String method;

    public GenericRequest(String id, String version, String method) {
        this.id = id;
        this.version = version;
        this.method = method;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("jsonrpc")
    public String getVersion() {
        return version;
    }

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }
}
