package my.programmer.monero4j.rpc_client.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetBlockHeadersRangeRequest {
    public static class Params {
        int startHeight;
        int endHeight;
        boolean fillPowHash;

        public Params() {
        }

        public int getStartHeight() {
            return startHeight;
        }

        @JsonProperty("start_height")
        public void setStartHeight(int startHeight) {
            this.startHeight = startHeight;
        }

        public int getEndHeight() {
            return endHeight;
        }

        @JsonProperty("end_height")
        public void setEndHeight(int endHeight) {
            this.endHeight = endHeight;
        }

        public boolean isFillPowHash() {
            return fillPowHash;
        }

        @JsonProperty("fill_pow_hash")
        public void setFillPowHash(boolean fillPowHash) {
            this.fillPowHash = fillPowHash;
        }
    }

    String id;
    String version;
    Params params;

    public GetBlockHeadersRangeRequest() {
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
