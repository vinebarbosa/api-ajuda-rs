package com.viniciosbarbosa.apiajudars.doacao;

import com.viniciosbarbosa.apiajudars.item.Item;

import java.util.List;

public record DoacaoRequestDto(String doador_id, List<Item> itens) {}
