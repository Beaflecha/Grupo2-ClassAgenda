package com.classagendag2.shared.http.helpers;

public class JsonEscaper {
    private JsonEscaper() {}

    public static String escape(String rawText) {
        if (rawText == null) return "";
        return rawText.replace("\\", "\\\\").replace("\"", "\\\"");

    }
}
