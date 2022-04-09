package com.helpdesk.backend.services;

import com.helpdesk.backend.domain.Chamado;
import com.helpdesk.backend.domain.Cliente;
import com.helpdesk.backend.domain.Tecnico;
import com.helpdesk.backend.domain.dtos.ChamadoDTO;
import com.helpdesk.backend.domain.enums.Prioridade;
import com.helpdesk.backend.domain.enums.Status;
import com.helpdesk.backend.repositories.ChamadoRepository;
import com.helpdesk.backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {
    @Autowired
    private ChamadoRepository repository; // COMUNICAÇÃO COM O BANCO
    @Autowired
    private TecnicoService tecnicoService;
    @Autowired
    private ClienteService clienteService;

    // MÉTODO IRÁ BUSCAR NO DATABASE O ID E RETORNAR O OBJETO
    public Chamado findById(Integer id) {
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
    }

    // MÉTODO LISTARÁ TODOS OS CHAMADOS
    public List<Chamado> findAll() {
        return repository.findAll();
    }

    // MÉTODO PARA CRIAR UM NOVO REGISTRO DE CHAMADO
    public Chamado create(ChamadoDTO obj) {
        return repository.save(newChamado(obj));
    }

    // VERIFICA SE O ID DO TÉCNICO E CLIENTE EXISTEM QUANDO O CHAMADO É CRIADO
    private Chamado newChamado(ChamadoDTO obj) {
        Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
        Cliente cliente = clienteService.findById(obj.getCliente());

        Chamado chamado = new Chamado();
        // PARA ATUALIZAR O CHAMADO, POIS != NULL
        if(obj.getId() != null) {
            chamado.setId(obj.getId());
        }

        // PARA APRESENTAR A DATA ATUAL QUANDO ENCERRADO O CHAMADO
        if(obj.getStatus().equals(2)) {
            chamado.setDataFechamento(LocalDate.now());
        }

        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
        chamado.setStatus(Status.toEnum(obj.getStatus()));
        chamado.setTitulo(obj.getTitulo());
        chamado.setObservacoes(obj.getObservacoes());
        return chamado;
    }

    // ENDPOINT PARA ATUALIZAR AS INFORMAÇÕES
    public Chamado update(Integer id, @Valid ChamadoDTO objDTO) {
        objDTO.setId(id);
        Chamado oldObj = findById(id);
        oldObj = newChamado(objDTO);
        return repository.save(oldObj);
    }
}
