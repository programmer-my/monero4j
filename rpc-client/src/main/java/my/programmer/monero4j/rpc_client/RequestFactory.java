package my.programmer.monero4j.rpc_client;

import my.programmer.monero4j.rpc_client.request.GenericRequest;
import my.programmer.monero4j.rpc_client.request.GetBlockHashRequest;
import my.programmer.monero4j.rpc_client.request.GetBlockHeaderByHashRequest;

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
}
