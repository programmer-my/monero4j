package my.programmer.monero4j.rpc_client.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public class GetBlockByHashRequest {
    public static class Params {
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String hash;
        private boolean fillPowHash;

        public Params() {
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

    @JsonProperty
    private String id;

    @JsonProperty
    private String version;

    @JsonProperty
    private Params params;

    public GetBlockByHashRequest() {
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

    public Params getParams() {
        return params;
    }

    @JsonProperty("params")
    public void setParams(Params params) {
        this.params = params;
    }
}
