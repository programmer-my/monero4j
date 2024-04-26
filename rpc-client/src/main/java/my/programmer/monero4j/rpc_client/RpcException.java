package my.programmer.monero4j.rpc_client;

@SuppressWarnings("unused")
public class RpcException extends RuntimeException {
    public RpcException() {

    }

    public RpcException(String message) {
        super(message);
    }

    public RpcException(String message, Throwable cause) {
        super(message, cause);
    }
}
