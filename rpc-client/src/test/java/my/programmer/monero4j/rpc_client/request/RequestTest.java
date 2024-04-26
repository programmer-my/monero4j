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
    public void testGenericRequest() throws JsonProcessingException {
        GenericRequest request = new GenericRequest("1", "2.0", "test_method");
        String json = objectMapper.writeValueAsString(request);
        JsonNode tree = objectMapper.readTree(json);
        Assertions.assertEquals("1", tree.get("id").asText());
        Assertions.assertEquals("2.0", tree.get("jsonrpc").asText());
        Assertions.assertEquals("test_method", tree.get("method").asText());
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

    @Test
    public void testGetBlockHashRequest() throws JsonProcessingException {
        GetBlockHashRequest request = requestFactory.newGetBlockHashRequest(1337);
        String json = objectMapper.writeValueAsString(request);
        JsonNode tree = objectMapper.readTree(json);

        Assertions.assertEquals("0", tree.get("id").asText());
        Assertions.assertEquals("2.0", tree.get("jsonrpc").asText());
        Assertions.assertEquals("on_get_block_hash", tree.get("method").asText());
        JsonNode paramsNode = tree.get("params");
        Assertions.assertTrue(paramsNode.isArray());
        Assertions.assertEquals(1, paramsNode.size());
        Assertions.assertEquals(1337, paramsNode.get(0).asInt());
    }

    @Test
    public void testGetBlockHeaderByHashRequest() throws JsonProcessingException {
        GetBlockHeaderByHashRequest request = requestFactory.newGetBlockHeaderByHashRequest("e22cf75f39ae720e8b71b3d120a5ac03f0db50bba6379e2850975b4859190bc6", true);
        String json = objectMapper.writeValueAsString(request);
        JsonNode tree = objectMapper.readTree(json);

        Assertions.assertEquals(request.getId(), tree.get("id").asText());
        Assertions.assertEquals(request.getVersion(), tree.get("jsonrpc").asText());
        Assertions.assertEquals(request.getHash(), tree.get("hash").asText());
        Assertions.assertEquals(request.isFillPowHash(), tree.get("fill_pow_hash").asBoolean());
    }

    @Test
    public void testGetBlockHeaderByHeightRequest() throws JsonProcessingException {
        GetBlockHeaderByHeight request = requestFactory.newGetBlockHeaderByHeight(912345, true);
        String json = objectMapper.writeValueAsString(request);
        JsonNode tree = objectMapper.readTree(json);

        Assertions.assertEquals(request.getId(), tree.get("id").asText());
        Assertions.assertEquals(request.getVersion(), tree.get("jsonrpc").asText());

        JsonNode params = tree.get("params");
        Assertions.assertTrue(params.isObject());
        Assertions.assertEquals(request.getHeight(), params.get("height").asInt());
        Assertions.assertEquals(request.isFillPowHash(), params.get("fill_pow_hash").asBoolean());
    }

    @Test
    public void testGetBlockHeadersRangeRequest() throws JsonProcessingException {
        GetBlockHeadersRangeRequest request = requestFactory.newGetBlockHeadersRangeRequest(1545999, 1546000, true);
        String json = objectMapper.writeValueAsString(request);
        JsonNode tree = objectMapper.readTree(json);

        Assertions.assertEquals(request.getId(), tree.get("id").asText());
        Assertions.assertEquals(request.getVersion(), tree.get("jsonrpc").asText());

        JsonNode paramsTree = tree.get("params");
        Assertions.assertEquals(request.getParams().getStartHeight(), paramsTree.get("start_height").asInt());
        Assertions.assertEquals(request.getParams().getEndHeight(), paramsTree.get("end_height").asInt());
        Assertions.assertEquals(request.getParams().isFillPowHash(), paramsTree.get("fill_pow_hash").asBoolean());
    }
}
