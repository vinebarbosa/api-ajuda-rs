package com.viniciosbarbosa.apiajudars.item;

import com.viniciosbarbosa.apiajudars.doador.DoadorResponseDto;

public record
ItemRequestDto(Long id, String nome, Integer quantidade, Categoria categoria, DoadorResponseDto doador) {
    public ItemRequestDto(Item item) {
        this(item.getId(), item.getNome(), item.getQuantidade(), item.getCategoria(), new DoadorResponseDto(item.getDoacao().getDoador()));
    }
}
