package com.helpdesk.backend.repositories;


import com.helpdesk.backend.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
