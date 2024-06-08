package com.viniciosbarbosa.apiajudars.doacao;

import com.viniciosbarbosa.apiajudars.doador.CreateDoadorDto;
import com.viniciosbarbosa.apiajudars.doador.Doador;
import com.viniciosbarbosa.apiajudars.doador.DoadorRepository;
import com.viniciosbarbosa.apiajudars.item.Item;
import com.viniciosbarbosa.apiajudars.item.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("doacoes")
public class DoacaoController {
    @Autowired
    DoacaoRepository doacaoRepository;

    @Autowired
    DoadorRepository doadorRepository;

    @Autowired
    ItemRepository itemRepository;

    @GetMapping
    public List<DoacaoResponseDto> listar() {
        List<DoacaoResponseDto> doacoes = doacaoRepository.findAll().stream().map(DoacaoResponseDto::new).collect(Collectors.toList());
        return doacoes;
    }

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void criar(@RequestBody CreateDoacaoDto data) {

        Optional<Doador> optionalDoador = doadorRepository.findById(data.doador().instagram());

        Doador doador = optionalDoador.orElseGet(() -> doadorRepository.save(new Doador(data.doador())));

        Doacao doacaoCriada = doacaoRepository.save(new Doacao(doador));

        Item item = new Item(data.nome(), data.quantidade(), data.categoria(), doacaoCriada);

        itemRepository.save(item);
    }

    @PutMapping
    public void atualizar() {

    }
}
