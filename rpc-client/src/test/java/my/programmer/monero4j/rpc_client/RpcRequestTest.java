package my.programmer.monero4j.rpc_client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.programmer.monero4j.rpc_client.request.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RpcRequestTest {
    @Test
    public void testRpcRequestSerializesToJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Request request = new Request();

        String json = objectMapper.writeValueAsString(request);

        System.out.println("JSON: " + json);
        Assertions.assertNotNull(json);
    }
}
