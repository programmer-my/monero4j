package my.programmer.monero4j.rpc_client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public class GetBlockCountResponse {
    static class Result {
        int count;
        String status;
        boolean untrusted;

        public Result() {
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public boolean isUntrusted() {
            return untrusted;
        }

        public void setUntrusted(boolean untrusted) {
            this.untrusted = untrusted;
        }
    }

    private String id;
    private String version;
    private GetBlockCountResponse.Result result;

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

    @JsonProperty("result")
    public GetBlockCountResponse.Result getResult() {
        return result;
    }

    public void setResult(GetBlockCountResponse.Result result) {
        this.result = result;
    }
}
