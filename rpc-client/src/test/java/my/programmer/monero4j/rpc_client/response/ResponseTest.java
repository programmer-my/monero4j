package my.programmer.monero4j.rpc_client.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResponseTest {
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        ObjectMapper mapper = new ObjectMapper();
        this.objectMapper = mapper;
        mapper.configure(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION.mappedFeature(), true);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
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

        assertEquals("0", response.getId());
        assertEquals("2.0", response.getVersion());

        GetBlockCountResponse.Result result = response.getResult();

        assertEquals(993163, result.getCount());
        assertEquals("OK", result.getStatus());
        assertFalse(result.isUntrusted());

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

        assertEquals("0", response.getId());
        assertEquals("2.0", response.getVersion());
        assertEquals("e22cf75f39ae720e8b71b3d120a5ac03f0db50bba6379e2850975b4859190bc6", response.getResult());
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
        assertEquals("0", response.getId());
        assertEquals("2.0", response.getVersion());

        GetLastBlockHeaderResponse.Result result = response.getResult();
        assertEquals(0, result.getCredits());
        assertEquals("OK", result.getStatus());
        assertEquals("", result.getTopHash());
        assertFalse(result.isUntrusted());

        BlockHeader blockHeader = result.getBlockHeader();
        assertEquals(5500, blockHeader.getBlockSize());
        assertEquals(5500, blockHeader.getBlockWeight());
        assertEquals(86164894009456483L, blockHeader.getCumulativeDifficulty());
        assertEquals(0, blockHeader.getCumulativeDifficultyTop64());
        assertEquals(0, blockHeader.getDepth());
        assertEquals(227026389695L, blockHeader.getDifficulty());
        assertEquals(0, blockHeader.getDifficultyTop64());
        assertEquals("a6ad87cf357a1aac1ee1d7cb0afa4c2e653b0b1ab7d5bf6af310333e43c59dd0", blockHeader.getHash());
        assertEquals(2286454, blockHeader.getHeight());
        assertEquals(5500, blockHeader.getLongTermWeight());
        assertEquals(14, blockHeader.getMajorVersion());
        assertEquals("a474f87de1645ff14c5e90c477b07f9bc86a22fb42909caa0705239298da96d0", blockHeader.getMinerTxHash());
        assertEquals(14, blockHeader.getMinorVersion());
        assertEquals(249602367, blockHeader.getNonce());
        assertEquals(3, blockHeader.getTxCount());
        assertFalse(blockHeader.isOrphan());
        assertEquals("", blockHeader.getPowHash());
        assertEquals("fa17fefe1d05da775a61a3dc33d9e199d12af167ef0ab37e52b51e8487b50f25", blockHeader.getPrevHash());
        assertEquals(1181337498013L, blockHeader.getReward());
        assertEquals(1612088597L, blockHeader.getTimestamp());
        assertEquals("0x1321e83bb8af763", blockHeader.getWideCumulativeDifficulty());
        assertEquals("0x34dbd3cabf", blockHeader.getWideDifficulty());

    }

    @Test
    public void testGetBlockHeadersRangeResponse() throws JsonProcessingException {
        String json = """
                {
                  "id": "0",
                  "jsonrpc": "2.0",
                  "result": {
                    "credits": 0,
                    "headers": [{
                      "block_size": 301413,
                      "block_weight": 301413,
                      "cumulative_difficulty": 13185267971483472,
                      "cumulative_difficulty_top64": 0,
                      "depth": 740464,
                      "difficulty": 134636057921,
                      "difficulty_top64": 0,
                      "hash": "86d1d20a40cefcf3dd410ff6967e0491613b77bf73ea8f1bf2e335cf9cf7d57a",
                      "height": 1545999,
                      "long_term_weight": 301413,
                      "major_version": 6,
                      "miner_tx_hash": "9909c6f8a5267f043c3b2b079fb4eacc49ef9c1dee1c028eeb1a259b95e6e1d9",
                      "minor_version": 6,
                      "nonce": 3246403956,
                      "num_txes": 20,
                      "orphan_status": false,
                      "pow_hash": "",
                      "prev_hash": "0ef6e948f77b8f8806621003f5de24b1bcbea150bc0e376835aea099674a5db5",
                      "reward": 5025593029981,
                      "timestamp": 1523002893,
                      "wide_cumulative_difficulty": "0x2ed7ee6db56750",
                      "wide_difficulty": "0x1f58ef3541"
                    },{
                      "block_size": 13322,
                      "block_weight": 13322,
                      "cumulative_difficulty": 13185402687569710,
                      "cumulative_difficulty_top64": 0,
                      "depth": 740463,
                      "difficulty": 134716086238,
                      "difficulty_top64": 0,
                      "hash": "b408bf4cfcd7de13e7e370c84b8314c85b24f0ba4093ca1d6eeb30b35e34e91a",
                      "height": 1546000,
                      "long_term_weight": 13322,
                      "major_version": 7,
                      "miner_tx_hash": "7f749c7c64acb35ef427c7454c45e6688781fbead9bbf222cb12ad1a96a4e8f6",
                      "minor_version": 7,
                      "nonce": 3737164176,
                      "num_txes": 1,
                      "orphan_status": false,
                      "pow_hash": "",
                      "prev_hash": "86d1d20a40cefcf3dd410ff6967e0491613b77bf73ea8f1bf2e335cf9cf7d57a",
                      "reward": 4851952181070,
                      "timestamp": 1523002931,
                      "wide_cumulative_difficulty": "0x2ed80dcb69bf2e",
                      "wide_difficulty": "0x1f5db457de"
                    }],
                    "status": "OK",
                    "top_hash": "",
                    "untrusted": false
                  }
                }""";

        GetBlockHeadersRangeResponse response = objectMapper.readValue(json, GetBlockHeadersRangeResponse.class);

        // TODO: assertions
    }

    @Test
    public void testGetBlockResponse_byHeight() throws JsonProcessingException {
        String json = """
                {
                  "id": "0",
                  "jsonrpc": "2.0",
                  "result": {
                    "blob": "1010c58bab9b06b27bdecfc6cd0a46172d136c08831cf67660377ba992332363228b1b722781e7807e07f502cef8a70101ff92f8a7010180e0a596bb1103d7cbf826b665d7a532c316982dc8dbc24f285cbc18bbcc27c7164cd9b3277a85d034019f629d8b36bd16a2bfce3ea80c31dc4d8762c67165aec21845494e32b7582fe00211000000297a787a000000000000000000000000",
                    "block_header": {
                      "block_size": 106,
                      "block_weight": 106,
                      "cumulative_difficulty": 236046001376524168,
                      "cumulative_difficulty_top64": 0,
                      "depth": 40,
                      "difficulty": 313732272488,
                      "difficulty_top64": 0,
                      "hash": "43bd1f2b6556dcafa413d8372974af59e4e8f37dbf74dc6b2a9b7212d0577428",
                      "height": 2751506,
                      "long_term_weight": 176470,
                      "major_version": 16,
                      "miner_tx_hash": "e49b854c5f339d7410a77f2a137281d8042a0ffc7ef9ab24cd670b67139b24cd",
                      "minor_version": 16,
                      "nonce": 4110909056,
                      "num_txes": 0,
                      "orphan_status": false,
                      "pow_hash": "",
                      "prev_hash": "b27bdecfc6cd0a46172d136c08831cf67660377ba992332363228b1b722781e7",
                      "reward": 600000000000,
                      "timestamp": 1667941829,
                      "wide_cumulative_difficulty": "0x3469a966eb2f788",
                      "wide_difficulty": "0x490be69168"
                    },
                    "credits": 0,
                    "json": "{\\n  \\"major_version\\": 16, \\n  \\"minor_version\\": 16, \\n  \\"timestamp\\": 1667941829, \\n  \\"prev_id\\": \\"b27bdecfc6cd0a46172d136c08831cf67660377ba992332363228b1b722781e7\\", \\n  \\"nonce\\": 4110909056, \\n  \\"miner_tx\\": {\\n    \\"version\\": 2, \\n    \\"unlock_time\\": 2751566, \\n    \\"vin\\": [ {\\n        \\"gen\\": {\\n          \\"height\\": 2751506\\n        }\\n      }\\n    ], \\n    \\"vout\\": [ {\\n        \\"amount\\": 600000000000, \\n        \\"target\\": {\\n          \\"tagged_key\\": {\\n            \\"key\\": \\"d7cbf826b665d7a532c316982dc8dbc24f285cbc18bbcc27c7164cd9b3277a85\\", \\n            \\"view_tag\\": \\"d0\\"\\n          }\\n        }\\n      }\\n    ], \\n    \\"extra\\": [ 1, 159, 98, 157, 139, 54, 189, 22, 162, 191, 206, 62, 168, 12, 49, 220, 77, 135, 98, 198, 113, 101, 174, 194, 24, 69, 73, 78, 50, 183, 88, 47, 224, 2, 17, 0, 0, 0, 41, 122, 120, 122, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0\\n    ], \\n    \\"rct_signatures\\": {\\n      \\"type\\": 0\\n    }\\n  }, \\n  \\"tx_hashes\\": [ ]\\n}",
                    "miner_tx_hash": "e49b854c5f339d7410a77f2a137281d8042a0ffc7ef9ab24cd670b67139b24cd",
                    "status": "OK",
                    "top_hash": "",
                    "untrusted": false
                  }
                }
                """;

        GetBlockResponse response = objectMapper.readValue(json, GetBlockResponse.class);
        assertEquals("0", response.getId());
        assertEquals("2.0", response.getVersion());

        GetBlockResponse.Result result = response.getResult();
        assertEquals("1010c58bab9b06b27bdecfc6cd0a46172d136c08831cf67660377ba992332363228b1b722781e7807e07f502cef8a70101ff92f8a7010180e0a596bb1103d7cbf826b665d7a532c316982dc8dbc24f285cbc18bbcc27c7164cd9b3277a85d034019f629d8b36bd16a2bfce3ea80c31dc4d8762c67165aec21845494e32b7582fe00211000000297a787a000000000000000000000000", result.getBlob());
        assertEquals(0, result.getCredits());
        // TODO: assertion on result.getJson()
        assertEquals("e49b854c5f339d7410a77f2a137281d8042a0ffc7ef9ab24cd670b67139b24cd", result.getMinerTxHash());
        assertEquals("OK", result.getStatus());
        assertEquals("", result.getTopHash());
        assertFalse(result.isUntrusted());

        BlockHeader header = result.getHeader();
        assertNotNull(header);

        // TODO: is it necessary to write assertions on header?
    }

    @Test
    public void testGetBlockResponse_byHash() throws JsonProcessingException {
        String json = """
                {
                  "id": "0",
                  "jsonrpc": "2.0",
                  "result": {
                    "blob": "1010d8faa89b06f8a36d0dbe4d27d2f52160000563896048d71067c31e99a3869bf9b7142227bb5328010b02a6f6a70101ffeaf5a70101a08bc8b3bb11036d6713f5aa552a1aaf33baed7591f795b86daf339e51029a9062dfe09f0f909b312b0124d6023d591c4d434000e5e31c6db718a1e96e865939930e90a7042a1cd4cbd202083786a78452fdfc000002a89e380a44d8dfc64b551baa171447a0f9c9262255be6e8f8ef10896e36e2bf90c4d343e416e394ad9cc10b7d2df7b2f39370a554730f75dfcb04944bd62c299",
                    "block_header": {
                      "block_size": 3166,
                      "block_weight": 3166,
                      "cumulative_difficulty": 235954020187853162,
                      "cumulative_difficulty_top64": 0,
                      "depth": 26,
                      "difficulty": 312527777859,
                      "difficulty_top64": 0,
                      "hash": "86d421322b700166dde2d7eba1cc8600925ef640abf6c0a2cc8ce0d6dd90abfd",
                      "height": 2751210,
                      "long_term_weight": 176470,
                      "major_version": 16,
                      "miner_tx_hash": "dabe07900d3123ed895612f4a151adb3e39681b145f0f85bfee23ea1fe47acf2",
                      "minor_version": 16,
                      "nonce": 184625235,
                      "num_txes": 2,
                      "orphan_status": false,
                      "pow_hash": "",
                      "prev_hash": "f8a36d0dbe4d27d2f52160000563896048d71067c31e99a3869bf9b7142227bb",
                      "reward": 600061380000,
                      "timestamp": 1667906904,
                      "wide_cumulative_difficulty": "0x34646ee649f516a",
                      "wide_difficulty": "0x48c41b7043"
                    },
                    "credits": 0,
                    "json": "{\\n  \\"major_version\\": 16, \\n  \\"minor_version\\": 16, \\n  \\"timestamp\\": 1667906904, \\n  \\"prev_id\\": \\"f8a36d0dbe4d27d2f52160000563896048d71067c31e99a3869bf9b7142227bb\\", \\n  \\"nonce\\": 184625235, \\n  \\"miner_tx\\": {\\n    \\"version\\": 2, \\n    \\"unlock_time\\": 2751270, \\n    \\"vin\\": [ {\\n        \\"gen\\": {\\n          \\"height\\": 2751210\\n        }\\n      }\\n    ], \\n    \\"vout\\": [ {\\n        \\"amount\\": 600061380000, \\n        \\"target\\": {\\n          \\"tagged_key\\": {\\n            \\"key\\": \\"6d6713f5aa552a1aaf33baed7591f795b86daf339e51029a9062dfe09f0f909b\\", \\n            \\"view_tag\\": \\"31\\"\\n          }\\n        }\\n      }\\n    ], \\n    \\"extra\\": [ 1, 36, 214, 2, 61, 89, 28, 77, 67, 64, 0, 229, 227, 28, 109, 183, 24, 161, 233, 110, 134, 89, 57, 147, 14, 144, 167, 4, 42, 28, 212, 203, 210, 2, 8, 55, 134, 167, 132, 82, 253, 252, 0\\n    ], \\n    \\"rct_signatures\\": {\\n      \\"type\\": 0\\n    }\\n  }, \\n  \\"tx_hashes\\": [ \\"a89e380a44d8dfc64b551baa171447a0f9c9262255be6e8f8ef10896e36e2bf9\\", \\"0c4d343e416e394ad9cc10b7d2df7b2f39370a554730f75dfcb04944bd62c299\\"\\n  ]\\n}",
                    "miner_tx_hash": "dabe07900d3123ed895612f4a151adb3e39681b145f0f85bfee23ea1fe47acf2",
                    "status": "OK",
                    "top_hash": "",
                    "tx_hashes": ["a89e380a44d8dfc64b551baa171447a0f9c9262255be6e8f8ef10896e36e2bf9","0c4d343e416e394ad9cc10b7d2df7b2f39370a554730f75dfcb04944bd62c299"],
                    "untrusted": false
                  }
                }
                """;

        GetBlockResponse response = objectMapper.readValue(json, GetBlockResponse.class);
        assertEquals("0", response.getId());
        assertEquals("2.0", response.getVersion());

        GetBlockResponse.Result result = response.getResult();
        assertEquals("1010d8faa89b06f8a36d0dbe4d27d2f52160000563896048d71067c31e99a3869bf9b7142227bb5328010b02a6f6a70101ffeaf5a70101a08bc8b3bb11036d6713f5aa552a1aaf33baed7591f795b86daf339e51029a9062dfe09f0f909b312b0124d6023d591c4d434000e5e31c6db718a1e96e865939930e90a7042a1cd4cbd202083786a78452fdfc000002a89e380a44d8dfc64b551baa171447a0f9c9262255be6e8f8ef10896e36e2bf90c4d343e416e394ad9cc10b7d2df7b2f39370a554730f75dfcb04944bd62c299", result.getBlob());
        assertEquals(0, result.getCredits());
        // TODO: assertion on result.getJson()
        assertEquals("dabe07900d3123ed895612f4a151adb3e39681b145f0f85bfee23ea1fe47acf2", result.getMinerTxHash());
        assertEquals("OK", result.getStatus());
        assertEquals("", result.getTopHash());

        var expectedTxHashes = new String[]{"a89e380a44d8dfc64b551baa171447a0f9c9262255be6e8f8ef10896e36e2bf9","0c4d343e416e394ad9cc10b7d2df7b2f39370a554730f75dfcb04944bd62c299"};
        assertArrayEquals(expectedTxHashes, result.getTxHashes().toArray());
        assertFalse(result.isUntrusted());
    }

    @Test
    public void testGetConnectionsResponse() throws JsonProcessingException {
        String json = """
                {
                  "id": "0",
                  "jsonrpc": "2.0",
                  "result": {
                    "connections": [{
                      "address": "51.75.162.171:44741",
                      "address_type": 1,
                      "avg_download": 0,
                      "avg_upload": 1,
                      "connection_id": "4420a6fcf9c642daaae41400ccfc1fd7",
                      "current_download": 0,
                      "current_upload": 1,
                      "height": 1,
                      "host": "51.75.162.171",
                      "incoming": true,
                      "ip": "51.75.162.171",
                      "live_time": 9,
                      "local_ip": false,
                      "localhost": false,
                      "peer_id": "ff561b6a65c2838c",
                      "port": "44741",
                      "pruning_seed": 0,
                      "recv_count": 382,
                      "recv_idle_time": 8,
                      "rpc_credits_per_hash": 0,
                      "rpc_port": 0,
                      "send_count": 15434,
                      "send_idle_time": 8,
                      "state": "normal",
                      "support_flags": 1
                    }],
                    "status": "OK",
                    "untrusted": false
                  }
                }""";

        GetConnectionsResponse response = objectMapper.readValue(json, GetConnectionsResponse.class);

        assertEquals("0", response.getId());
        assertEquals("2.0", response.getVersion());

        GetConnectionsResponse.Result result = response.getResult();

        assertEquals("OK", result.getStatus());
        assertFalse(result.isUntrusted());

        assertEquals(1, result.getConnections().size());

        GetConnectionsResponse.Connection connection = result.getConnections().get(0);

        assertEquals("51.75.162.171:44741", connection.getAddress());
        assertEquals(1, connection.getAddressType());
        assertEquals(0, connection.getAvgDownload());
        assertEquals(1, connection.getAvgUpload());
        assertEquals("4420a6fcf9c642daaae41400ccfc1fd7", connection.getConnectionId());
        assertEquals(0, connection.getCurrentDownload());
        assertEquals(1, connection.getCurrentUpload());
        assertEquals(1, connection.getHeight());
        assertEquals("51.75.162.171", connection.getHost());
        assertTrue(connection.isIncoming());
        assertEquals("51.75.162.171", connection.getIp());
        assertEquals(9, connection.getLiveTime());
        assertFalse(connection.isLocalIp());
        assertFalse(connection.isLocalhost());
        assertEquals("ff561b6a65c2838c", connection.getPeerId());
        assertEquals("44741", connection.getPort());
        assertEquals(0, connection.getPruningSeed());
        assertEquals(382, connection.getRecvCount());
        assertEquals(8, connection.getRecvIdleTime());
        assertEquals(0, connection.getRpcCreditsPerHash());
        assertEquals(0, connection.getRpcPort());
        assertEquals(15434, connection.getSendCount());
        assertEquals(8, connection.getSendIdleTime());
        assertEquals("normal", connection.getState());
        assertEquals(1, connection.getSupportFlags());
    }

    @Test
    public void testGetConnectionsResponse_ensureConnectionsNotNull() throws JsonProcessingException {
        String json = """
                {
                  "id": "1",
                  "jsonrpc": "2.0",
                  "result": {
                    "status": "OK",
                    "untrusted": false
                  }
                }""";

        GetConnectionsResponse response = objectMapper.readValue(json, GetConnectionsResponse.class);

        assertNotNull(response.getResult().getConnections());
    }

    @Test
    public void testGetInfoResponse() throws JsonProcessingException {
        String json = """
                {
                  "id": "0",
                  "jsonrpc": "2.0",
                  "result": {
                    "adjusted_time": 1612090533,
                    "alt_blocks_count": 2,
                    "block_size_limit": 600000,
                    "block_size_median": 300000,
                    "block_weight_limit": 600000,
                    "block_weight_median": 300000,
                    "bootstrap_daemon_address": "",
                    "busy_syncing": false,
                    "credits": 0,
                    "cumulative_difficulty": 86168732847545368,
                    "cumulative_difficulty_top64": 0,
                    "database_size": 34329849856,
                    "difficulty": 225889137349,
                    "difficulty_top64": 0,
                    "free_space": 10795802624,
                    "grey_peerlist_size": 4999,
                    "height": 2286472,
                    "height_without_bootstrap": 2286472,
                    "incoming_connections_count": 85,
                    "mainnet": true,
                    "nettype": "mainnet",
                    "offline": false,
                    "outgoing_connections_count": 16,
                    "rpc_connections_count": 1,
                    "stagenet": false,
                    "start_time": 1611915662,
                    "status": "OK",
                    "synchronized": true,
                    "target": 120,
                    "target_height": 2286464,
                    "testnet": false,
                    "top_block_hash": "b92720d8315b96e32020d04e14a0c54cc13e057d4a5beb4501be490d306fdd8f",
                    "top_hash": "",
                    "tx_count": 11239803,
                    "tx_pool_size": 21,
                    "untrusted": false,
                    "update_available": false,
                    "version": "0.17.1.9-release",
                    "was_bootstrap_ever_used": false,
                    "white_peerlist_size": 1000,
                    "wide_cumulative_difficulty": "0x1322201881f9c18",
                    "wide_difficulty": "0x34980ab2c5"
                  }
                }
                """;

        GetInfoResponse response = objectMapper.readValue(json, GetInfoResponse.class);

        assertEquals("0", response.getId());
        assertEquals("2.0", response.getVersion());

        GetInfoResponse.Result result = response.getResult();

        assertEquals(1612090533L, result.getAdjustedTime());
        assertEquals(2, result.getAltBlocksCount());
        assertEquals(600_000L, result.getBlockWeightLimit());
        assertEquals(300_000L, result.getBlockWeightMedian());
        assertEquals("", result.getBootstrapDaemonAddress());
        assertFalse(result.isBusySyncing());
        assertEquals(0, result.getCredits());
        assertEquals(86168732847545368L, result.getCumulativeDifficulty());
        assertEquals(0, result.getCumulativeDifficultyTop64());
        assertEquals(34329849856L, result.getDatabaseSize());
        assertEquals(225889137349L, result.getDifficulty());
        assertEquals(0, result.getDifficultyTop64());
        assertEquals(10795802624L, result.getFreeSpace());
        assertEquals(4999, result.getGreyPeerlistSize());
        assertEquals(2286472L, result.getHeight());
        assertEquals(2286472L, result.getHeightWithoutBootstrap());
        assertEquals(85, result.getIncomingConnectionsCount());
        assertTrue(result.isMainnet());
        assertFalse(result.isOffline());
        assertEquals(16, result.getOutgoingConnectionsCount());
        assertEquals(1, result.getRpcConnectionsCount());
        assertFalse(result.isStagenet());
        assertEquals(1611915662L, result.getStartTime());
        assertEquals("OK", result.getStatus());
        assertTrue(result.isSynced());
        assertEquals(120, result.getTarget());
        assertEquals(2286464L, result.getTargetHeight());
        assertFalse(result.isTestnet());
        assertEquals("b92720d8315b96e32020d04e14a0c54cc13e057d4a5beb4501be490d306fdd8f", result.getTopBlockHash());
        assertEquals("", result.getTopHash());
        assertEquals(11239803, result.getTxCount());
        assertEquals(21, result.getTxPoolSize());
        assertFalse(result.isUntrusted());
        assertFalse(result.isUpdateAvailable());
        assertFalse(result.isBootstrapEverUsed());
        assertEquals(1000, result.getWhitePeerlistSize());
        assertEquals("0x1322201881f9c18", result.getWideCumulativeDifficulty());
        assertEquals("0x34980ab2c5", result.getWideDifficulty());
    }
}
