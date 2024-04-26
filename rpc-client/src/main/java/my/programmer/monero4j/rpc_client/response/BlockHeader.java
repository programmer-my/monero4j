package my.programmer.monero4j.rpc_client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
class BlockHeader {
    int blockSize;
    int blockWeight;
    long cumulDifficulty;
    long cumulDifficultyTop64;
    int depth;
    long difficulty;
    long difficultyTop64;
    String hash;
    int height;
    int longTermWeight;
    int majorVersion;
    String minerTxHash;
    int minorVersion;
    long nonce;
    int txCount;
    boolean orphan;
    String powHash;
    String prevHash;
    long reward;
    long timestamp;
    String wideCumulDifficulty;
    String wideDifficulty;

    public BlockHeader() {
    }

    public int getBlockSize() {
        return blockSize;
    }

    @JsonProperty("block_size")
    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public int getBlockWeight() {
        return blockWeight;
    }

    @JsonProperty("block_weight")
    public void setBlockWeight(int blockWeight) {
        this.blockWeight = blockWeight;
    }

    public long getCumulativeDifficulty() {
        return cumulDifficulty;
    }

    @JsonProperty("cumulative_difficulty")
    public void setCumulativeDifficulty(long cumulDifficulty) {
        this.cumulDifficulty = cumulDifficulty;
    }

    public long getCumulativeDifficultyTop64() {
        return cumulDifficultyTop64;
    }

    @JsonProperty("cumulative_difficulty_top64")
    public void setCumulativeDifficultyTop64(long cumulDifficultyTop64) {
        this.cumulDifficultyTop64 = cumulDifficultyTop64;
    }

    public int getDepth() {
        return depth;
    }

    @JsonProperty("depth")
    public void setDepth(int depth) {
        this.depth = depth;
    }

    public long getDifficulty() {
        return difficulty;
    }

    @JsonProperty("difficulty")
    public void setDifficulty(long difficulty) {
        this.difficulty = difficulty;
    }

    public long getDifficultyTop64() {
        return difficultyTop64;
    }

    @JsonProperty("difficulty_top64")
    public void setDifficultyTop64(long difficultyTop64) {
        this.difficultyTop64 = difficultyTop64;
    }

    public String getHash() {
        return hash;
    }

    @JsonProperty("hash")
    public void setHash(String hash) {
        this.hash = hash;
    }

    @JsonProperty("height")
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @JsonProperty("long_term_weight")
    public int getLongTermWeight() {
        return longTermWeight;
    }

    public void setLongTermWeight(int longTermWeight) {
        this.longTermWeight = longTermWeight;
    }

    @JsonProperty("major_version")
    public int getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    public String getMinerTxHash() {
        return minerTxHash;
    }

    @JsonProperty("miner_tx_hash")
    public void setMinerTxHash(String minerTxHash) {
        this.minerTxHash = minerTxHash;
    }

    @JsonProperty("minor_version")
    public int getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }

    @JsonProperty("nonce")
    public long getNonce() {
        return nonce;
    }

    public void setNonce(long nonce) {
        this.nonce = nonce;
    }

    public int getTxCount() {
        return txCount;
    }

    @JsonProperty("num_txes")
    public void setTxCount(int txCount) {
        this.txCount = txCount;
    }

    public boolean isOrphan() {
        return orphan;
    }

    @JsonProperty("orphan_status")
    public void setOrphan(boolean orphan) {
        this.orphan = orphan;
    }

    public String getPowHash() {
        return powHash;
    }

    @JsonProperty("pow_hash")
    public void setPowHash(String powHash) {
        this.powHash = powHash;
    }

    public String getPrevHash() {
        return prevHash;
    }

    @JsonProperty("prev_hash")
    public void setPrevHash(String prevHash) {
        this.prevHash = prevHash;
    }

    @JsonProperty("reward")
    public long getReward() {
        return reward;
    }

    public void setReward(long reward) {
        this.reward = reward;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
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