package br.fepi.apicrud.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.fepi.apicrud.domain.Departamento;


public interface DepartamentosRepository extends JpaRepository<Departamento, Long> {

    
}

