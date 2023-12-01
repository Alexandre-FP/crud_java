package br.fepi.apicrud.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.fepi.apicrud.domain.Departamento;
import br.fepi.apicrud.domain.Secretaria;
import br.fepi.apicrud.repository.DepartamentosRepository;
import br.fepi.apicrud.repository.SecretariasRepository;  

@RestController
@RequestMapping(value = "/secretarias") 
public class SecretariasResources { 
	
	@Autowired
	private SecretariasRepository secretariasRepository;

	@Autowired
	private DepartamentosRepository departamentosRepository; 

 
	@RequestMapping(method = RequestMethod.GET)
	public List<Secretaria> listar() {
		return secretariasRepository.findAll();  
	} 

	@PostMapping()
		public Secretaria salvar(@RequestBody Secretaria secretaria){
		return secretariasRepository.save(secretaria);
	}

	@CrossOrigin
	@GetMapping(value = "/{id}")
	public Secretaria findById(@PathVariable (value = "id")Long id){
		return secretariasRepository.findById(id).orElse(null); 
	}

	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable(value = "id")Long id){ 
		secretariasRepository.deleteById(id); 
	}

	@PutMapping(value = "{id}")
	public void atualizar(@RequestBody Secretaria secretaria, @PathVariable("id") Long id){
		secretaria.setId(id);
		secretariasRepository.save(secretaria); 
	}

	@RequestMapping(value = "/{id}/departamento", method = RequestMethod.POST)
	public void adicionarDepartamento(@PathVariable("id") Long secretariaId, @RequestBody Departamento departamento){
		Secretaria secretaria = new Secretaria();
		secretaria.setId(secretariaId);

		departamento.setSecretaria(secretaria); 
		departamentosRepository.save(departamento);    
	}
}
