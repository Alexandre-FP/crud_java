package br.fepi.socialbooks.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.fepi.socialbooks.domain.Departamento;


public interface DepartamentosRepository extends JpaRepository<Departamento, Long> {

    
}

