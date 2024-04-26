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

    @Test
    public void testGetBlockHashResponse() throws JsonProcessingException {
        String json = """
                {
                  "id": "0",
                  "jsonrpc": "2.0",
                  "result": "e22cf75f39ae720e8b71b3d120a5ac03f0db50bba6379e2850975b4859190bc6"
                }""";

        GetBlockHashResponse response = objectMapper.readValue(json, GetBlockHashResponse.class);

        Assertions.assertEquals("0", response.getId());
        Assertions.assertEquals("2.0", response.getVersion());
        Assertions.assertEquals("e22cf75f39ae720e8b71b3d120a5ac03f0db50bba6379e2850975b4859190bc6", response.getResult());
    }

    @Test
    public void testGetLastBlockHeaderResponse() throws JsonProcessingException {
        String json = """
                {
                  "id": "0",
                  "jsonrpc": "2.0",
                  "result": {
                    "block_header": {
                      "block_size": 5500,
                      "block_weight": 5500,
                      "cumulative_difficulty": 86164894009456483,
                      "cumulative_difficulty_top64": 0,
                      "depth": 0,
                      "difficulty": 227026389695,
                      "difficulty_top64": 0,
                      "hash": "a6ad87cf357a1aac1ee1d7cb0afa4c2e653b0b1ab7d5bf6af310333e43c59dd0",
                      "height": 2286454,
                      "long_term_weight": 5500,
                      "major_version": 14,
                      "miner_tx_hash": "a474f87de1645ff14c5e90c477b07f9bc86a22fb42909caa0705239298da96d0",
                      "minor_version": 14,
                      "nonce": 249602367,
                      "num_txes": 3,
                      "orphan_status": false,
                      "pow_hash": "",
                      "prev_hash": "fa17fefe1d05da775a61a3dc33d9e199d12af167ef0ab37e52b51e8487b50f25",
                      "reward": 1181337498013,
                      "timestamp": 1612088597,
                      "wide_cumulative_difficulty": "0x1321e83bb8af763",
                      "wide_difficulty": "0x34dbd3cabf"
                    },
                    "credits": 0,
                    "status": "OK",
                    "top_hash": "",
                    "untrusted": false
                  }
                }
                """;

        GetLastBlockHeaderResponse response = objectMapper.readValue(json, GetLastBlockHeaderResponse.class);
        Assertions.assertEquals("0", response.getId());
        Assertions.assertEquals("2.0", response.getVersion());

        GetLastBlockHeaderResponse.Result result = response.getResult();
        Assertions.assertEquals(0, result.getCredits());
        Assertions.assertEquals("OK", result.getStatus());
        Assertions.assertEquals("", result.getTopHash());
        Assertions.assertFalse(result.isUntrusted());

        GetLastBlockHeaderResponse.Result.BlockHeader blockHeader = result.getBlockHeader();
        Assertions.assertEquals(5500, blockHeader.getBlockSize());
        Assertions.assertEquals(5500, blockHeader.getBlockWeight());
        Assertions.assertEquals(86164894009456483L, blockHeader.getCumulativeDifficulty());
        Assertions.assertEquals(0, blockHeader.getCumulativeDifficultyTop64());
        Assertions.assertEquals(0, blockHeader.getDepth());
        Assertions.assertEquals(227026389695L, blockHeader.getDifficulty());
        Assertions.assertEquals(0, blockHeader.getDifficultyTop64());
        Assertions.assertEquals("a6ad87cf357a1aac1ee1d7cb0afa4c2e653b0b1ab7d5bf6af310333e43c59dd0", blockHeader.getHash());
        Assertions.assertEquals(2286454, blockHeader.getHeight());
        Assertions.assertEquals(5500, blockHeader.getLongTermWeight());
        Assertions.assertEquals(14, blockHeader.getMajorVersion());
        Assertions.assertEquals("a474f87de1645ff14c5e90c477b07f9bc86a22fb42909caa0705239298da96d0", blockHeader.getMinerTxHash());
        Assertions.assertEquals(14, blockHeader.getMinorVersion());
        Assertions.assertEquals(249602367, blockHeader.getNonce());
        Assertions.assertEquals(3, blockHeader.getTxCount());
        Assertions.assertEquals(false, blockHeader.isOrphan());
        Assertions.assertEquals("", blockHeader.getPowHash());
        Assertions.assertEquals("fa17fefe1d05da775a61a3dc33d9e199d12af167ef0ab37e52b51e8487b50f25", blockHeader.getPrevHash());
        Assertions.assertEquals(1181337498013L, blockHeader.getReward());
        Assertions.assertEquals(1612088597L, blockHeader.getTimestamp());
        Assertions.assertEquals("0x1321e83bb8af763", blockHeader.getWideCumulativeDifficulty());
        Assertions.assertEquals("0x34dbd3cabf", blockHeader.getWideDifficulty());

    }
}
