package my.programmer.monero4j.rpc_client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SetDaemonCmdTest {
    @Test
    public void testFactoryReturnsInstance() {
        SetDaemonCmd.Factory factory = new SetDaemonCmd.Factory();
        SetDaemonCmd setDaemonCmd = factory.makeDefault();
        Assertions.assertNotNull(setDaemonCmd);
    }
}
