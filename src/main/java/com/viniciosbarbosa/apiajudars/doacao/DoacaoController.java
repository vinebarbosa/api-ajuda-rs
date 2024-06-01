package com.viniciosbarbosa.apiajudars.doacao;

import com.viniciosbarbosa.apiajudars.doador.Doador;
import com.viniciosbarbosa.apiajudars.doador.DoadorRepository;
import com.viniciosbarbosa.apiajudars.item.Item;
import com.viniciosbarbosa.apiajudars.item.ItemRepository;
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
    public void criar(@RequestBody DoacaoRequestDto data) {
        Optional<Doador> doador = doadorRepository.findById(data.doador_id());
        Doacao doacaoData = new Doacao(doador.orElse(null));
        Doacao doacao = doacaoRepository.save(doacaoData);
        List<Item> itensData = data.itens().stream().map((Item item) -> new Item(item.getNome(),  item.getQuantidade(), item.getCategoria(), doacao)).collect(Collectors.toList());
        itemRepository.saveAll(itensData);
    }
}
