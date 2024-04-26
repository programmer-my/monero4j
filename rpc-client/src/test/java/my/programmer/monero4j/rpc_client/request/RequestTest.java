package my.programmer.monero4j.rpc_client.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.programmer.monero4j.rpc_client.RequestFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RequestTest {
    ObjectMapper objectMapper;
    RequestFactory requestFactory;

    @BeforeEach
    void setUp() {
        this.objectMapper = new ObjectMapper();
        this.requestFactory = new RequestFactory();
    }

    @Test
    public void testGetBlockCountRequest() throws JsonProcessingException {
        GenericRequest request = requestFactory.newGetBlockCountRequest();
        String json = objectMapper.writeValueAsString(request);
        JsonNode tree = objectMapper.readTree(json);

        Assertions.assertEquals("0", tree.get("id").asText());
        Assertions.assertEquals("2.0", tree.get("jsonrpc").asText());
        Assertions.assertEquals("get_block_count", tree.get("method").asText());
    }
}
