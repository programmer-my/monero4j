package my.programmer.monero4j.rpc_client.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetBlockResponse {
    static class Result {
        private String blob;
        private BlockHeader header;
        private long credits;
        private String json;
        private String minerTxHash;
        private String status;
        private String topHash;
        private boolean untrusted;
        private List<String> txHashes;

        public Result() {
        }

        public String getBlob() {
            return blob;
        }

        @JsonProperty
        public void setBlob(String blob) {
            this.blob = blob;
        }

        public BlockHeader getHeader() {
            return header;
        }

        @JsonProperty("block_header")
        public void setHeader(BlockHeader header) {
            this.header = header;
        }

        public long getCredits() {
            return credits;
        }

        @JsonProperty
        public void setCredits(long credits) {
            this.credits = credits;
        }

        public String getJson() {
            return json;
        }

        @JsonProperty
        public void setJson(String json) {
            this.json = json;
        }

        public String getMinerTxHash() {
            return minerTxHash;
        }

        @JsonProperty("miner_tx_hash")
        public void setMinerTxHash(String minerTxHash) {
            this.minerTxHash = minerTxHash;
        }

        public String getStatus() {
            return status;
        }

        @JsonProperty
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

        @JsonProperty
        public void setUntrusted(boolean untrusted) {
            this.untrusted = untrusted;
        }

        public List<String> getTxHashes() {
            return txHashes;
        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("tx_hashes")
        public void setTxHashes(List<String> txHashes) {
            this.txHashes = txHashes;
        }
    }

    private String id;
    private String version;
    private Result result;

    public GetBlockResponse() {
    }

    public String getId() {
        return id;
    }

    @JsonProperty
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
