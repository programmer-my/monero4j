package my.programmer.monero4j.rpc_client.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResponseTest {
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        ObjectMapper mapper = new ObjectMapper();
        this.objectMapper = mapper;
        mapper.configure(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION.mappedFeature(), true);
    }

    @Test
    public void testGetBlockCountResponse() throws JsonProcessingException {
        String json = """
                { \s
                  "id": "0", \s
                  "jsonrpc": "2.0", \s
                  "result": { \s
                    "count": 993163, \s
                    "status": "OK", \s
                    "untrusted": "false" \s
                  } \s
                } \s""";

        GetBlockCountResponse response = objectMapper.readValue(json, GetBlockCountResponse.class);

        Assertions.assertEquals("0", response.getId());
        Assertions.assertEquals("2.0", response.getVersion());

        GetBlockCountResponse.Result result = response.getResult();

        Assertions.assertEquals(993163, result.getCount());
        Assertions.assertEquals("OK", result.getStatus());
        Assertions.assertFalse(result.isUntrusted());

    }
}
