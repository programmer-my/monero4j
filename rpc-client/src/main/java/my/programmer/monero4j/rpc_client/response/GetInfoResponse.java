package my.programmer.monero4j.rpc_client.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetInfoResponse {
    public static class Result {
        private long adjustedTime;
        private long altBlocksCount;
        private long blockWeightLimit;
        private long blockWeightMedian;
        private String bootstrapDaemonAddress;
        private boolean busySyncing;
        private long credits; // TODO: long or int?
        private long cumulativeDifficulty;
        private long top64cumulativeDifficulty;
        private long databaseSize;
        private long difficulty;
        private long top64difficulty;
        private long freeSpace;
        private int greyPeerlistSize;
        private long height; // TODO: long or int?
        private long heightWithoutBootstrap; // TODO: long or int?
        private int incomingConnectionsCount;
        private boolean mainnet;
        // Possible values: mainnet, stagenet, testnet
        // TODO: use enum?
        private String nettype;
        private boolean offline;
        private int outgoingConnectionsCount;
        private int rpcConnectionsCount;
        private boolean stagenet;
        private long startTime;
        private String status;
        private boolean synced;
        private long target;
        private long targetHeight;
        private boolean testnet;
        private String topBlockHash;
        private String topHash;
        private long txCount;
        private long txPoolSize;
        private boolean untrusted;
        private boolean updateAvail;
        private String version;
        private boolean bootstrapEverUsed;
        private int whitePeerlistSize;
        private String wideCumulDifficulty;
        private String wideDifficulty;

        public Result() {
        }

        public long getAdjustedTime() {
            return adjustedTime;
        }

        @JsonProperty("adjusted_time")
        public void setAdjustedTime(long adjustedTime) {
            this.adjustedTime = adjustedTime;
        }

        public long getAltBlocksCount() {
            return altBlocksCount;
        }

        @JsonProperty("alt_blocks_count")
        public void setAltBlocksCount(long altBlocksCount) {
            this.altBlocksCount = altBlocksCount;
        }

        public long getBlockWeightLimit() {
            return blockWeightLimit;
        }

        @JsonProperty("block_weight_limit")
        public void setBlockWeightLimit(long blockWeightLimit) {
            this.blockWeightLimit = blockWeightLimit;
        }

        public long getBlockWeightMedian() {
            return blockWeightMedian;
        }

        @JsonProperty("block_weight_median")
        public void setBlockWeightMedian(long blockWeightMedian) {
            this.blockWeightMedian = blockWeightMedian;
        }

        public String getBootstrapDaemonAddress() {
            return bootstrapDaemonAddress;
        }

        @JsonProperty("bootstrap_daemon_address")
        public void setBootstrapDaemonAddress(String bootstrapDaemonAddress) {
            this.bootstrapDaemonAddress = bootstrapDaemonAddress;
        }

        public boolean isBusySyncing() {
            return busySyncing;
        }

        @JsonProperty("busy_syncing")
        public void setBusySyncing(boolean busySyncing) {
            this.busySyncing = busySyncing;
        }

        public long getCredits() {
            return credits;
        }

        @JsonProperty("credits")
        public void setCredits(long credits) {
            this.credits = credits;
        }

        public long getCumulativeDifficulty() {
            return cumulativeDifficulty;
        }

        @JsonProperty("cumulative_difficulty")
        public void setCumulativeDifficulty(long cumulativeDifficulty) {
            this.cumulativeDifficulty = cumulativeDifficulty;
        }

        public long getCumulativeDifficultyTop64() {
            return top64cumulativeDifficulty;
        }

        @JsonProperty("cumulative_difficulty_top64")
        public void setCumulativeDifficultyTop64(long top64cumulativeDifficulty) {
            this.top64cumulativeDifficulty = top64cumulativeDifficulty;
        }

        public long getDatabaseSize() {
            return databaseSize;
        }

        @JsonProperty("database_size")
        public void setDatabaseSize(long databaseSize) {
            this.databaseSize = databaseSize;
        }

        public long getDifficulty() {
            return difficulty;
        }

        @JsonProperty("difficulty")
        public void setDifficulty(long difficulty) {
            this.difficulty = difficulty;
        }

        public long getDifficultyTop64() {
            return top64difficulty;
        }

        @JsonProperty("difficulty_top64")
        public void setDifficultyTop64(long top64difficulty) {
            this.top64difficulty = top64difficulty;
        }

        public long getFreeSpace() {
            return freeSpace;
        }

        @JsonProperty("free_space")
        public void setFreeSpace(long freeSpace) {
            this.freeSpace = freeSpace;
        }

        public int getGreyPeerlistSize() {
            return greyPeerlistSize;
        }

        @JsonProperty("grey_peerlist_size")
        public void setGreyPeerlistSize(int greyPeerlistSize) {
            this.greyPeerlistSize = greyPeerlistSize;
        }

        public long getHeight() {
            return height;
        }

        @JsonProperty("height")
        public void setHeight(long height) {
            this.height = height;
        }

        public long getHeightWithoutBootstrap() {
            return heightWithoutBootstrap;
        }

        @JsonProperty("height_without_bootstrap")
        public void setHeightWithoutBootstrap(long heightWithoutBootstrap) {
            this.heightWithoutBootstrap = heightWithoutBootstrap;
        }

        public int getIncomingConnectionsCount() {
            return incomingConnectionsCount;
        }

        @JsonProperty("incoming_connections_count")
        public void setIncomingConnectionsCount(int incomingConnectionsCount) {
            this.incomingConnectionsCount = incomingConnectionsCount;
        }

        public boolean isMainnet() {
            return mainnet;
        }

        @JsonProperty("mainnet")
        public void setMainnet(boolean mainnet) {
            this.mainnet = mainnet;
        }

        public String getNettype() {
            return nettype;
        }

        @JsonProperty("nettype")
        public void setNettype(String nettype) {
            this.nettype = nettype;
        }

        public boolean isOffline() {
            return offline;
        }

        @JsonProperty("offline")
        public void setOffline(boolean offline) {
            this.offline = offline;
        }

        @JsonProperty("outgoing_connections_count")
        public int getOutgoingConnectionsCount() {
            return outgoingConnectionsCount;
        }

        public void setOutgoingConnectionsCount(int outgoingConnectionsCount) {
            this.outgoingConnectionsCount = outgoingConnectionsCount;
        }

        @JsonProperty("rpc_connections_count")
        public int getRpcConnectionsCount() {
            return rpcConnectionsCount;
        }

        public void setRpcConnectionsCount(int rpcConnectionsCount) {
            this.rpcConnectionsCount = rpcConnectionsCount;
        }

        @JsonProperty("stagenet")
        public boolean isStagenet() {
            return stagenet;
        }

        public void setStagenet(boolean stagenet) {
            this.stagenet = stagenet;
        }

        @JsonProperty("start_time")
        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        @JsonProperty("status")
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @JsonProperty("synchronized")
        public boolean isSynced() {
            return synced;
        }

        public void setSynced(boolean synced) {
            this.synced = synced;
        }

        public long getTarget() {
            return target;
        }

        @JsonProperty("target")
        public void setTarget(long target) {
            this.target = target;
        }

        public long getTargetHeight() {
            return targetHeight;
        }

        @JsonProperty("target_height")
        public void setTargetHeight(long targetHeight) {
            this.targetHeight = targetHeight;
        }

        public boolean isTestnet() {
            return testnet;
        }

        @JsonProperty("testnet")
        public void setTestnet(boolean testnet) {
            this.testnet = testnet;
        }

        public String getTopBlockHash() {
            return topBlockHash;
        }

        @JsonProperty("top_block_hash")
        public void setTopBlockHash(String topBlockHash) {
            this.topBlockHash = topBlockHash;
        }

        public String getTopHash() {
            return topHash;
        }

        @JsonProperty("top_hash")
        public void setTopHash(String topHash) {
            this.topHash = topHash;
        }

        public long getTxCount() {
            return txCount;
        }

        @JsonProperty("tx_count")
        public void setTxCount(long txCount) {
            this.txCount = txCount;
        }

        public long getTxPoolSize() {
            return txPoolSize;
        }

        @JsonProperty("tx_pool_size")
        public void setTxPoolSize(long txPoolSize) {
            this.txPoolSize = txPoolSize;
        }

        public boolean isUntrusted() {
            return untrusted;
        }

        @JsonProperty("untrusted")
        public void setUntrusted(boolean untrusted) {
            this.untrusted = untrusted;
        }

        public boolean isUpdateAvailable() {
            return updateAvail;
        }

        @JsonProperty("update_available")
        public void setUpdateAvailable(boolean updateAvail) {
            this.updateAvail = updateAvail;
        }

        public String getVersion() {
            return version;
        }

        @JsonProperty("version")
        public void setVersion(String version) {
            this.version = version;
        }

        public boolean isBootstrapEverUsed() {
            return bootstrapEverUsed;
        }

        @JsonProperty("was_bootstrap_ever_used")
        public void setBootstrapEverUsed(boolean bootstrapEverUsed) {
            this.bootstrapEverUsed = bootstrapEverUsed;
        }

        public int getWhitePeerlistSize() {
            return whitePeerlistSize;
        }

        @JsonProperty("white_peerlist_size")
        public void setWhitePeerlistSize(int whitePeerlistSize) {
            this.whitePeerlistSize = whitePeerlistSize;
        }

        public String getWideCumulativeDifficulty() {
            return wideCumulDifficulty;
        }

        @JsonProperty("wide_cumulative_difficulty")
        public void setWideCumulativeDifficulty(String wideCumulDifficulty) {
            this.wideCumulDifficulty = wideCumulDifficulty;
        }

        public String getWideDifficulty() {
            return wideDifficulty;
        }

        @JsonProperty("wide_difficulty")
        public void setWideDifficulty(String wideDifficulty) {
            this.wideDifficulty = wideDifficulty;
        }
    }

    private String id;
    private String version;
    private Result result;

    public GetInfoResponse() {
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
