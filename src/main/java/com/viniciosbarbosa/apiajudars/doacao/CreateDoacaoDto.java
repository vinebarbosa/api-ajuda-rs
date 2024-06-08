package com.viniciosbarbosa.apiajudars.doacao;

import com.viniciosbarbosa.apiajudars.doador.CreateDoadorDto;
import com.viniciosbarbosa.apiajudars.doador.Doador;
import com.viniciosbarbosa.apiajudars.item.Categoria;

public record CreateDoacaoDto(String nome, Integer quantidade, Categoria categoria, CreateDoadorDto doador) {}
