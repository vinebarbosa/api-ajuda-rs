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
@EqualsAndHashCode(of = "id")
public class Doador {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String instagram;

    @OneToMany(mappedBy = "doador", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Doacao> doacoes;

    public Doador(DoadorRequestDto data) {
        this.nome = data.nome();
        this.instagram = data.instagram();
    }
}
