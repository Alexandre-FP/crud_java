package br.fepi.socialbooks.resources;

//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// import br.fepi.socialbooks.domain.Departamento;
import br.fepi.socialbooks.domain.Secretaria;
// import br.fepi.socialbooks.repository.DepartamentosRepository;
import br.fepi.socialbooks.repository.SecretariasRepository;  

@RestController
@RequestMapping(value = "/secretarias")
public class SecretariasResources { 
	
	@Autowired
	private SecretariasRepository secretariasRepository;

	// @Autowired
	// private DepartamentosRepository departamentosRepository; 


	@RequestMapping(method = RequestMethod.GET)
	public List<Secretaria> listar() {
		return secretariasRepository.findAll();
	} 

}
