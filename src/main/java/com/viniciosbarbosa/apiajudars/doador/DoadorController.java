package com.viniciosbarbosa.apiajudars.doador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("doadores")
public class DoadorController {
    private final DoadorRepository doadorRepository;

    @Autowired
    public DoadorController(DoadorRepository doadorRepository) {
        this.doadorRepository = doadorRepository;
    }

    @PostMapping
    public void criar(@RequestBody DoadorRequestDto data) {
        Doador doadorData = new Doador(data);
        doadorRepository.save(doadorData);
    }

    @GetMapping
    public List<DoadorResponseDto> listar() {
        List<DoadorResponseDto> doadores = doadorRepository.findAll().stream().map(DoadorResponseDto::new).collect(Collectors.toList());
        return doadores;
    }
}
