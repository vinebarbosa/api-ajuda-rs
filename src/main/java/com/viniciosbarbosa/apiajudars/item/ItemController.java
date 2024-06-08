package com.viniciosbarbosa.apiajudars.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("itens")
public class ItemController {
    @Autowired
    private ItemRepository itensRepository;

    @GetMapping("")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<ItemRequestDto> getItens() {
        List<ItemRequestDto> itensRecentes = itensRepository.findAll().stream().map(ItemRequestDto::new).collect(Collectors.toList());
        return itensRecentes;
    }

    @GetMapping("recentes")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<ItemRequestDto> getItensRecentes() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "id"));
        List<ItemRequestDto> itensRecentes = itensRepository.findAll(pageable).getContent().stream().map(ItemRequestDto::new).collect(Collectors.toList());
        return itensRecentes;
    }
}
