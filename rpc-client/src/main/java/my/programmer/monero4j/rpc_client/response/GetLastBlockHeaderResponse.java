package my.programmer.monero4j.rpc_client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public class GetLastBlockHeaderResponse {
    public static class Result {
        int credits;
        String status;
        String topHash;
        boolean untrusted;
        BlockHeader blockHeader;

        public Result() {
        }

        public int getCredits() {
            return credits;
        }

        @JsonProperty("credits")
        public void setCredits(int credits) {
            this.credits = credits;
        }

        public String getStatus() {
            return status;
        }

        @JsonProperty("status")
        public void setStatus(String status) {
            this.status = status;
        }

        public String getTopHash() {
            return topHash;
        }

        @JsonProperty("top_hash")
        public void setTopHash(String topHash) {
            this.topHash = topHash;
        }

        public boolean isUntrusted() {
            return untrusted;
        }

        @JsonProperty("untrusted")
        public void setUntrusted(boolean untrusted) {
            this.untrusted = untrusted;
        }

        public BlockHeader getBlockHeader() {
            return blockHeader;
        }

        @JsonProperty("block_header")
        public void setBlockHeader(BlockHeader blockHeader) {
            this.blockHeader = blockHeader;
        }
    }

    private String id;
    private String version;
    private GetLastBlockHeaderResponse.Result result;

    public GetLastBlockHeaderResponse() {
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

    public Result getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(Result result) {
        this.result = result;
    }
}
