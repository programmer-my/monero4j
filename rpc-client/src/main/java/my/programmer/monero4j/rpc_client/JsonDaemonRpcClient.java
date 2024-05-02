package my.programmer.monero4j.rpc_client;

import com.burgstaller.okhttp.digest.Credentials;
import com.burgstaller.okhttp.digest.DigestAuthenticator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.programmer.monero4j.rpc_client.request.*;
import my.programmer.monero4j.rpc_client.response.*;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("unused")
public class JsonDaemonRpcClient {
    private ObjectMapper objectMapper;
    private String jsonRpcBaseUrl;
    private RequestFactory requestFactory;
    private OkHttpClient httpClient;

    public JsonDaemonRpcClient(RpcConfig config, ObjectMapper objectMapper, OkHttpClient httpClient, RequestFactory requestFactory) {
        this.objectMapper = objectMapper;
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        this.httpClient = httpClient;
        this.jsonRpcBaseUrl = "http://" + config.getIpAddress() + ":" + config.getPort() + "/json_rpc";
        this.requestFactory = requestFactory;
    }

    public JsonDaemonRpcClient(RpcConfig config, ObjectMapper objectMapper, OkHttpClient.Builder httpBuilder, RequestFactory requestFactory) {
        DigestAuthenticator authenticator = new DigestAuthenticator(new Credentials(config.getUsername(), config.getPassword()));

        this.objectMapper = objectMapper;
        this.httpClient = httpBuilder.authenticator(authenticator).build();
        this.jsonRpcBaseUrl = "http://" + config.getIpAddress() + ":" + config.getPort() + "/json_rpc";
        this.requestFactory = requestFactory;
    }

    public GetBlockCountResponse getBlockCount() throws RpcException {
        GetBlockCountResponse retval = null;
        GenericRequest rpcRequest = requestFactory.newGetBlockCountRequest();

        try {
            String jsonRequest = objectMapper.writeValueAsString(rpcRequest);
            RequestBody requestBody = RequestBody.create(jsonRequest, MediaType.get("application/json"));
            Request httpRequest = new Request.Builder().url(jsonRpcBaseUrl).post(requestBody).build();

            try (Response response = httpClient.newCall(httpRequest).execute()) {
                assert response.body() != null;
                retval = objectMapper.readValue(response.body().string(), GetBlockCountResponse.class);
            } catch (IOException e) {
                throw e;
            }
        } catch (JsonProcessingException e) {
            throw new RpcException("JSON Serialization failed", e);
        } catch (IOException e) {
            throw new RuntimeException("HTTP request failed: " + e.getMessage(), e);
        }

        return retval;
    }

    public GetBlockHashResponse getBlockHashByHeight(int height) throws RpcException {
        GetBlockHashRequest rpcRequest = requestFactory.newGetBlockHashRequest(height);

        GetBlockHashResponse response = executeRequest(rpcRequest, GetBlockHashResponse.class);

        return response;
    }

    /**
     *
     * @param rpcRequest
     * @param respClass
     * @return R
     * @param <T> Type of request we are executing
     * @param <R> Type of response that the request will give
     */
    public <T, R> R executeRequest(T rpcRequest, Class<R> respClass) throws RpcException {
        R retval = null;

        try {
            String jsonRequest = objectMapper.writeValueAsString(rpcRequest);
            RequestBody requestBody = RequestBody.create(jsonRequest, MediaType.get("application/json"));
            Request httpRequest = new Request.Builder().url(jsonRpcBaseUrl).post(requestBody).build();

            try (Response response = httpClient.newCall(httpRequest).execute()) {
                assert response.body() != null;

                if (!response.isSuccessful()) {
                    if (response.code() == 401) {
                        throw new RpcException(String.format("Authentication failed: %s", response.message()));
                    }

                    throw new RpcException(String.format("HTTP request failed (%d): %s", response.code(), response.message()));
                }

                String responseJson = response.body().string();
                retval = objectMapper.readValue(responseJson, respClass);
            } catch (IOException e) {
                throw e;
            }
        } catch (JsonProcessingException e) {
            throw new RpcException("JSON Serialization failed", e);
        } catch (IOException e) {
            throw new RpcException("HTTP request failed: " + e.getMessage(), e);
        }

        return retval;
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

    public GetLastBlockHeaderResponse getLastBlockHeader(boolean fillPowHash) throws RpcException {
        GenericRequest rpcRequest = new GenericRequest("1", "2.0", "get_last_block_header");

        GetLastBlockHeaderResponse response = executeRequest(rpcRequest, GetLastBlockHeaderResponse.class);

        return response;
    }

    public GetLastBlockHeaderResponse getLastBlockHeader() throws RpcException {
        return getLastBlockHeader(false);
    }

    public GetBlockHeaderByHashResponse getBlockHeaderByHash(
            String hash,
            boolean fillPowHash
    ) throws RpcException {
        GetBlockHeaderByHashRequest rpcRequest = requestFactory.newGetBlockHeaderByHashRequest(hash, fillPowHash);

        GetBlockHeaderByHashResponse response = executeRequest(rpcRequest, GetBlockHeaderByHashResponse.class);

        return response;
    }

    public GetBlockHeaderByHashResponse getBlockHeaderByHash(String hash) throws RpcException {
        return getBlockHeaderByHash(hash, false);
    }

    public GetBlockHeaderByHeightResponse getBlockHeaderByHeight(
            int height,
            boolean fillPowHash
    ) throws RpcException {
        GetBlockHeaderByHeight rpcRequest = requestFactory.newGetBlockHeaderByHeight(height, fillPowHash);

        GetBlockHeaderByHeightResponse response = executeRequest(rpcRequest, GetBlockHeaderByHeightResponse.class);

        return response;
    }

    public GetBlockHeaderByHeightResponse getBlockHeaderByHeight(int height) throws RpcException {
        return getBlockHeaderByHeight(height, false);
    }

    public GetBlockHeadersRangeResponse getBlockHeadersRange(
            int startHeight,
            int endHeight,
            boolean fillPowHash
    ) {
        GetBlockHeadersRangeRequest rpcRequest = requestFactory.newGetBlockHeadersRangeRequest(startHeight, endHeight, fillPowHash);

        GetBlockHeadersRangeResponse response = executeRequest(rpcRequest, GetBlockHeadersRangeResponse.class);

        return response;
    }

    public GetBlockHeadersRangeResponse getBlockHeadersRange(
            int startHeight,
            int endHeight
    ) {
        return getBlockHeadersRange(startHeight, endHeight, false);
    }

    public GetBlockResponse getBlockByHeight(int height, boolean fillPowHash)
        throws RpcException {
        GetBlockByHeightRequest request = requestFactory.newGetBlockByHeightRequest(height, fillPowHash);

        GetBlockResponse response = executeRequest(request, GetBlockResponse.class);

        return response;
    }

    public GetBlockResponse getBlockByHeight(int height)
        throws RpcException {
        return getBlockByHeight(height, false);
    }

    public GetBlockResponse getBlockByHash(String hash, boolean fillPowHash)
        throws RpcException {
        GetBlockByHashRequest request = requestFactory.newGetBlockByHashRequest(hash, fillPowHash);

        GetBlockResponse response = executeRequest(request, GetBlockResponse.class);

        return response;
    }

    public GetBlockResponse getBlockByHash(String hash)
        throws RpcException {
        return getBlockByHash(hash, false);
    }

    public GetConnectionsResponse getConnections()
        throws RpcException {
        GenericRequest request = requestFactory.newGetConnectionsRequest();

        GetConnectionsResponse response = executeRequest(request, GetConnectionsResponse.class);

        return response;
    }

    public GetInfoResponse getInfo() {
        GenericRequest request = new GenericRequest("1", "2.0", "get_info");

        return executeRequest(request, GetInfoResponse.class);
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
