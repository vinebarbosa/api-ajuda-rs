package com.viniciosbarbosa.apiajudars.doador;

public record DoadorResponseDto(String nome, String instagram) {
    public  DoadorResponseDto(Doador doador) {
        this(doador.getNome(), doador.getInstagram());
    }
}
