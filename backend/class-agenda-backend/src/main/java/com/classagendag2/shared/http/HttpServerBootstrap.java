package com.classagendag2.shared.http;

import com.classagendag2.shared.config.ServerConfig;
import com.classagendag2.shared.http.handlers.HealthHandler;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public final class HttpServerBootstrap {
    public void start() throws Exception {
        // 1.Preguntamos porqué puerto debemos abrir el servidor
        int serverPort = ServerConfig.port();

        // 2.Creamos la dirección física (IP de la máquina + Puerto
        InetSocketAddress serverAddress = new InetSocketAddress(serverPort);
        HttpServer httpServer = HttpServer.create(serverAddress, 0);

        // 3.REGISTRAMOS LA RUTA "Si alguien pide /health, pásale la llamada al HealthHandler"
        httpServer.createContext("/health", new HealthHandler());

        // 4.Encendemos el servidor para que empiece a escuchar infinitamente
        httpServer.start();

        System.out.println("ClassAgenda API running on http://localhost:" + serverPort);

    }
}