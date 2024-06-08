package com.viniciosbarbosa.apiajudars.item;

public enum Categoria {
    ALIMENTO("Alimento"),
    HIGIENE_PESSOAL("Higiene Pessoal"),
    ROUPA("Roupas"),
    LIMPEZA("Limpeza");

    private final String descricao;

    private Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
