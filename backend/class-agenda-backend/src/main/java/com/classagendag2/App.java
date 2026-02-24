package com.classagendag2;

import com.classagendag2.shared.http.HttpServerBootstrap;

public class App {
    public static void main(String[] args) throws Exception {
        // Instancia y arranca el servidor HTTP
        new HttpServerBootstrap().start();
    }
}