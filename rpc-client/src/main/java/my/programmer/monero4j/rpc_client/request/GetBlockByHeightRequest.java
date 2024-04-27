package my.programmer.monero4j.rpc_client.request;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public class GetBlockByHeightRequest {
    public static class Params {
        private int height;
        private boolean fillPowHash;

        public Params() {
        }

        public int getHeight() {
            return height;
        }

        @JsonProperty("height")
        public void setHeight(int height) {
            this.height = height;
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

    public GetBlockByHeightRequest() {
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
