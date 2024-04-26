package my.programmer.monero4j.rpc_client;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonDaemonRpcClient {
    private RpcConfig config;
    private ObjectMapper objectMapper;

    public JsonDaemonRpcClient(RpcConfig config, ObjectMapper objectMapper) {
        this.config = config;
        this.objectMapper = objectMapper;
    }

    public Object getBlockCount() {
        return null;
    }

    public Object getBlockHashByHeight(int height) {
        return null;
    }

    public Object getBlockTemplate(
            String walletAddress,
            int reserveSize
    ) {
        assert reserveSize >= 0;
        return null;
    }

    public Object submitBlock() {
        return null;
    }

    public Object generateBlocks() {
        return null;
    }

    public Object getLastBlockHeader(boolean fillPowHash) {
        return null;
    }

    public Object getLastBlockHeader() {
        return getLastBlockHeader(false);
    }

    public Object getBlockHeaderByHash(
            String hash,
            boolean fillPowHash
    ) {
        return null;
    }

    public Object getBlockHeaderByHash(String hash) {
        return getBlockHeaderByHash(hash, false);
    }

    public Object getBlockHeaderByHeight(
            int height,
            boolean fillPowHash
    ) {
        return null;
    }

    public Object getBlockHeaderByHeight(
        int height
    ) {
        return getBlockHeaderByHeight(height, false);
    }

    public Object getBlockHeadersRange(
            int startHeight,
            int endHeight,
            boolean fillPowHash
    ) {
        return null;
    }

    public Object getBlockHeadersRange(
            int startHeight,
            int endHeight
    ) {
        return getBlockHeadersRange(startHeight, endHeight, false);
    }

    public Object getBlock(
            int height,
            String hash,
            boolean fillPowHash
    ) {
        return null;
    }

    public Object getBlock(
            int height,
            String hash
    ) {
        return getBlock(height, hash, false);
    }

    public Object getConnections() {
        return null;
    }

    public Object getInfo() {
        return null;
    }

    public Object hardForkInfo() {
        return null;
    }

    public Object setBans(List<Object> bans) {
        return null;
    }

    public Object getBans() {
        return null;
    }

    public Object isBanned(String ipAddress) {
        return null;
    }

    public Object flushTxPool(List<String> txIds) {
        return null;
    }

    public Object getOutputHistogram(
            List<Integer> amounts,
            int minCount,
            int maxCount,
            boolean unlocked,
            int recentCutoff
    ) {
        return null;

    }

    public Object getCoinbaseTxSum(
            int height,
            int count
    ) {
        return null;
    }

    public Object getNodeVersion() {
        return null;
    }

    public Object getFeeEstimate(
            int graceBlocks
    ) {
        return null;
    }

    public Object getFeeEstimate() {
        return null;
    }

    public Object getAlternateChains() {
        return null;
    }

    public Object relayTx(
            List<String> txIds
    ) {
        return null;
    }

    public Object getSyncInfo() {
        return null;
    }

    public Object getTxPoolBacklog() {
        return null;
    }

    public Object getOutputDistribution(
            List<Integer> amounts,
            boolean cumulative,
            int fromHeight,
            int toHeight
    ) {
        return null;
    }

    public Object getMinerData() {
        return null;
    }

    public Object pruneBlockchain(boolean check) {
        return null;
    }

    public Object pruneBlockchain() {
        return pruneBlockchain(false);
    }

    public Object calculatePowHash(
            int majorVersion,
            int height,
            Object blockBlob,
            String seedHash
    ) {
        return null;
    }

    public Object flushCache(
            boolean badTxs,
            boolean badBlocks
    ) {
        return null;
    }

    public Object flushCache() {
        return flushCache(false, false);
    }

    public Object addAuxPow(
            String blockTemplateBlob,
            List<Object> auxPow
    ) {
        return null;
    }

    public Object getHeight() {
        return null;
    }

    public Object getTransactions(
            List<String> txHashes,
            boolean prune,
            boolean split
    ) {
        return null;
    }

    public Object getAltBlockHashes() {
        return null;
    }

    public Object isKeyImageSpent(List<String> keyImages) {
        return null;
    }

    public Object sendRawTransaction(String rawTx, boolean doNotRelay) {
        return null;
    }

    public Object sendRawTransaction(String rawTx) {
        return sendRawTransaction(rawTx, false);
    }

    public Object startMining(
            boolean background,
            boolean ignoreBattery,
            String minerAddress,
            int threadCount
    ) {
        return null;
    }

    public Object startMining(
            String minerAddress
    ) {
        return startMining(true, true, minerAddress, 1);
    }

    public Object stopMining() {
        return null;
    }

    public Object getMiningStatus() {
        return null;
    }

    public Object saveBlockchain() {
        return null;
    }

    public Object getPeerList() {
        return null;
    }


}
