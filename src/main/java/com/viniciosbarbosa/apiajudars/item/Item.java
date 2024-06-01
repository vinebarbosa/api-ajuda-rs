package com.viniciosbarbosa.apiajudars.item;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.viniciosbarbosa.apiajudars.doacao.Doacao;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "itens")
@Entity(name = "item")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome;

    private Integer quantidade;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "doacao_id", nullable = false)
    @JsonBackReference
    private Doacao doacao;

    public Item(String nome, Integer quantidade, Categoria categoria, Doacao doacao) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.doacao = doacao;
    }
}
