package com.classagendag2.shared.config;

public final class ServerConfig {

    private static final int DEFAULT_PORT = 8080;

    private ServerConfig() {}

    public static int port() {
        String rawPortFromProperty = System.getProperty("CLASSAGENDA_PORT");
        if (rawPortFromProperty != null && !rawPortFromProperty.isBlank()) {
            return parsePortOrDefault(rawPortFromProperty);
        }

        String rawPortFromEnv = System.getenv("CLASSAGENDA_PORT");
        return parsePortOrDefault(rawPortFromEnv);
    }

    static int parsePortOrDefault(String rawPortValue) {
        if (rawPortValue == null || rawPortValue.isBlank()) {
            return DEFAULT_PORT;
        }

        try {
            int portNumber = Integer.parseInt(rawPortValue);
            boolean isPortInValidRange = portNumber >= 1 && portNumber <= 65535;

            if (!isPortInValidRange) {
                return DEFAULT_PORT;
            }

            return portNumber;

        } catch (NumberFormatException exception) {
            return DEFAULT_PORT;
        }
    }
}
