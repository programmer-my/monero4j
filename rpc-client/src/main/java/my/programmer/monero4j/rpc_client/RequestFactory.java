package my.programmer.monero4j.rpc_client;

import my.programmer.monero4j.rpc_client.request.GenericRequest;
import my.programmer.monero4j.rpc_client.request.GetBlockHashRequest;

public class RequestFactory {
    public GenericRequest newGetBlockCountRequest() {
        return new GenericRequest("0", "2.0", "get_block_count");
    }

    public GetBlockHashRequest newGetBlockHashRequest(int height) {
        return new GetBlockHashRequest(height);
    }
}
