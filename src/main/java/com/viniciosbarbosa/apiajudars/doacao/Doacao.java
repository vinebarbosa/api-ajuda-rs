package com.viniciosbarbosa.apiajudars.doacao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.viniciosbarbosa.apiajudars.doador.Doador;
import com.viniciosbarbosa.apiajudars.item.Item;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "doacoes")
@Entity(name = "doacao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doacao {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "doador_id", nullable = false)
    @JsonBackReference
    private Doador doador;

    @OneToMany(mappedBy = "doacao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Item> itens;

    public Doacao(Doador doador) {
        this.doador = doador;
    }
}
