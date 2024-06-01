package com.viniciosbarbosa.apiajudars.doador;

import com.viniciosbarbosa.apiajudars.doacao.Doacao;

import java.util.List;

public record DoadorResponseDto(String id, String nome, String instagram, List<Doacao> doacoes) {
    public  DoadorResponseDto(Doador doador) {
        this(doador.getId(), doador.getNome(), doador.getInstagram(), doador.getDoacoes());
    }
}
