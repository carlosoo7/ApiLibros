package com.CFCM.ConsultaLiteral.Modelo;

public enum Idioma {
    ESPAÑOL("es", "ESPAÑOL"),
    INGLES("en", "INGLES"),
    PORTUGUES("pt", "PORTUGUES"),
    FRANCES("fr", "FRANCES");

    private String categoriaApi;
    private String categoriaEspanol;

    Idioma(String categoriaApi, String categoriaEspanol) {
        this.categoriaApi = categoriaApi;
        this.categoriaEspanol = categoriaEspanol;
    }

    public static Idioma fromString(String text) {
        for (Idioma cat : Idioma.values()) {
            if (cat.categoriaApi.equalsIgnoreCase(text)) {
                return cat;
            }
        }
        throw new IllegalArgumentException("Ninguna categoría encontrada: " + text);
    }

    public static Idioma fromEspanol(String text) {
        for (Idioma cat : Idioma.values()) {
            if (cat.categoriaEspanol.equalsIgnoreCase(text)) {
                return cat;
            }
        }
        throw new IllegalArgumentException("Ninguna categoría encontrada: " + text);
    }

    // Getters
    public String getCategoriaApi() {
        return categoriaApi;
    }

    public String getCategoriaEspanol() {
        return categoriaEspanol;
    }
}

