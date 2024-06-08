package com.viniciosbarbosa.apiajudars.doador;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.viniciosbarbosa.apiajudars.doacao.Doacao;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name ="doadores")
@Entity(name = "doador")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "instagram")
public class Doador {
    private String nome;

    @Id
    private String instagram;

    @OneToMany(mappedBy = "doador", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Doacao> doacoes;

    public Doador(CreateDoadorDto data) {
        this.nome = data.nome();
        this.instagram = data.instagram();
    }

    public Doador( String nome, String instagram) {
        this.nome = nome;
        this.instagram = instagram;
    }
}
