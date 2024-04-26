package my.programmer.monero4j.rpc_client;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

enum SSLSupportOption {
    AUTODETECT("autodetect"),
    DISABLED("disabled"),
    ENABLED("enabled");

    private final String value;

    SSLSupportOption(String val) {
        value = val;
    }

    @Override
    public String toString() {
        return value;
    }
}

public record SetDaemonCmd(
    String address,
    boolean trusted,
    SSLSupportOption ssl,
    File sslPrivateKey,
    File sslCert,
    File sslCa,
    String[] sslAllowedFingerPrints,
    boolean sslAllowAnyCert,
    String username,
    String password
) {
    static class Factory {
        public SetDaemonCmd makeDefault() {
            return new SetDaemonCmd(
                    "",
                    false,
                    SSLSupportOption.AUTODETECT,
                    null,
                    null,
                    null,
                    new String[]{},
                    false,
                    null,
                    null);
        }
    }

    public Map<String, Object> toParams() {
        Map<String, Object> params = new HashMap<>();
        params.put("address", address);
        params.put("trusted", trusted);
        params.put("ssl_support", ssl.toString());
        params.put("ssl_private_key_path", null); // TODO
        params.put("ssl_certificate_path", null); // TODO
        params.put("ssl_ca_file", null); // TODO
        params.put("ssl_allowed_fingerprints", sslAllowedFingerPrints);
        params.put("ssl_allow_any_cert", sslAllowAnyCert);
        params.put("username", username);
        params.put("password", password);
        return params;
    }
}

