package com.viniciosbarbosa.apiajudars.doacao;

import com.viniciosbarbosa.apiajudars.doador.Doador;
import com.viniciosbarbosa.apiajudars.item.Item;

import java.util.List;

public record DoacaoResponseDto(String id, String doador_id, List<Item> itens) {
    public DoacaoResponseDto(Doacao doacao) {
        this (doacao.getId(), doacao.getDoador().getId(), doacao.getItens());
    }
}
