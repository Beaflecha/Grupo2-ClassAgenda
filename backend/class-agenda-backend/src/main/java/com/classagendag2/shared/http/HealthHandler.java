package com.classagendag2.shared.http.handlers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class HealthHandler implements HttpHandler {
  @Override
  public void handle(HttpExchange httpExchange) throws IOException {
    // 1. Preparamos el mensaje y lo pasamos a formato eléctrico (bytes)
    String responseBody = "OK";
    byte[] responseBytes = responseBody.getBytes(StandardCharsets.UTF_8);
    
    // 2. Avisamos al cliente de qué tipo de contenido le vamos a enviar
    httpExchange.getResponseHeaders().add("Content-Type", "text/plain; charset=utf-8");
    
    // 3. Enviamos el código de estado HTTP (200 = Todo ha ido bien) y el tamaño del mensaje
    httpExchange.sendResponseHeaders(200, responseBytes.length);

    // 4. Escribimos el mensaje real y "colgamos el teléfono"
    httpExchange.getResponseBody().write(responseBytes);
    httpExchange.close();
  }
}
