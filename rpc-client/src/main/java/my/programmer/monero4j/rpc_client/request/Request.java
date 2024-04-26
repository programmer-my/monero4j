package my.programmer.monero4j.rpc_client.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {
    String version = "2.0";
    String id = "0";

    @JsonProperty("jsonrpc")
    public String getVersion() {
        return "2.0";
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("id")
    public String getId() {
        return "0";
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("method")
    public String getMethod() {
        return "set_daemon";
    }


}
