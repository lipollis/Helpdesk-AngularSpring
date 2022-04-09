package com.helpdesk.backend.resources;

import com.helpdesk.backend.domain.Chamado;
import com.helpdesk.backend.domain.dtos.ChamadoDTO;
import com.helpdesk.backend.services.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/chamados") //localhost:8080/chamados
public class ChamadoResource {

    @Autowired
    private ChamadoService service;

    // MÉTODO - SERVE PARA REPRESENTAR TODA A RESPOSTA HTTP
    @GetMapping(value = "/{id}")
    public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id) {
        Chamado obj = service.findById(id);
        return ResponseEntity.ok().body(new ChamadoDTO(obj));
    }

    // MÉTODO LISTARÁ TODOS OS CHAMADOS DTO - QUANDO NÃO HÁ PARÂMETROS DEFINIDOS
    @GetMapping
    public ResponseEntity<List<ChamadoDTO>> findAll() {
        List<Chamado> list = service.findAll();
        List<ChamadoDTO> listDTO = list.stream().map(obj -> new ChamadoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    // MÉTODO PARA CRIAR UM NOVO REGISTRO DE CHAMADOS
    @PostMapping
    public ResponseEntity<ChamadoDTO> create(@Valid @RequestBody ChamadoDTO obj) {
        Chamado newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    // MÉTODO PARA ATUALIZAR UM NOVO REGISTRO DE CHAMADOS
    @PutMapping(value = "/{id}")
    public ResponseEntity<ChamadoDTO> update(@PathVariable Integer id, @Valid @RequestBody ChamadoDTO objDTO) {
        Chamado newObj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new ChamadoDTO(newObj));
    }
}
