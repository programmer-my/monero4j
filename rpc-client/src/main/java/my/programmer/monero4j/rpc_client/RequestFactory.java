package my.programmer.monero4j.rpc_client;

import my.programmer.monero4j.rpc_client.request.*;

public class RequestFactory {
    public GenericRequest newGetBlockCountRequest() {
        return new GenericRequest("0", "2.0", "get_block_count");
    }

    public GetBlockHashRequest newGetBlockHashRequest(int height) {
        return new GetBlockHashRequest(height);
    }

    public GetBlockHeaderByHashRequest newGetBlockHeaderByHashRequest(String hash, boolean fillPowHash) {
        GetBlockHeaderByHashRequest request = new GetBlockHeaderByHashRequest();
        request.setId("1");
        request.setVersion("2.0");
        request.setHash(hash);
        request.setFillPowHash(fillPowHash);
        return request;
    }

    public GetBlockHeaderByHashRequest newGetBlockHeaderByHashRequest(String hash) {
        GetBlockHeaderByHashRequest request = new GetBlockHeaderByHashRequest();
        request.setHash(hash);
        request.setFillPowHash(false);
        return request;
    }

    // TODO: int or long?
    public GetBlockHeaderByHeight newGetBlockHeaderByHeight(int height, boolean fillPowHash) {
        GetBlockHeaderByHeight request = new GetBlockHeaderByHeight();
        request.setId("1");
        request.setVersion("2.0");
        request.setHeight(height);
        request.setFillPowHash(fillPowHash);
        return request;
    }

    public GetBlockHeadersRangeRequest newGetBlockHeadersRangeRequest(
            int startHeight,
            int endHeight,
            boolean fillPowHash
    ) {
        GetBlockHeadersRangeRequest request = new GetBlockHeadersRangeRequest();
        request.setId("1");
        request.setVersion("2.0");

        GetBlockHeadersRangeRequest.Params params = new GetBlockHeadersRangeRequest.Params();
        request.setParams(params);

        params.setStartHeight(startHeight);
        params.setEndHeight(endHeight);
        params.setFillPowHash(fillPowHash);

        return request;
    }

    public GetBlockByHeightRequest newGetBlockByHeightRequest(int height, boolean fillPowHash) {
        GetBlockByHeightRequest request = new GetBlockByHeightRequest();
        request.setId("1");
        request.setVersion("2.0");

        GetBlockByHeightRequest.Params params = new GetBlockByHeightRequest.Params();
        request.setParams(params);

        params.setFillPowHash(fillPowHash);
        params.setHeight(height);

        return request;
    }

    public GetBlockByHashRequest newGetBlockByHashRequest(String hash, boolean fillPowHash) {
        GetBlockByHashRequest request = new GetBlockByHashRequest();
        request.setId("1");
        request.setVersion("2.0");

        GetBlockByHashRequest.Params params = new GetBlockByHashRequest.Params();
        request.setParams(params);

        params.setFillPowHash(fillPowHash);
        params.setHash(hash);

        return request;
    }
}
