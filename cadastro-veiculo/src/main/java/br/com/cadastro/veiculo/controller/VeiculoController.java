package br.com.cadastro.veiculo.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.cadastro.veiculo.domain.Veiculo;
import br.com.cadastro.veiculo.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository repository;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo adicionarVeiculo(@RequestBody @Valid Veiculo veiculo) {
		return repository.save(veiculo);
	}
	
	@GetMapping("{id}")
	public Veiculo detalhesVeiculo(@PathVariable Long id) {
		return repository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping
	public List<Veiculo> findTodosVeiculos() {
		return repository.findAll();
	}
	
	 @DeleteMapping("{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void deletar( @PathVariable Long id ){
	        repository
	            .findById(id)
	            .map( veiculo -> {
	                repository.delete(veiculo);
	                return Void.TYPE;
	            })
	            .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo não encontrado") );
	    }
	 
	 @PutMapping("{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void atualizar( @PathVariable Long id,
	                           @RequestBody  Veiculo veiculoAtualizado ) {
	        repository
	                .findById(id)
	                .map( veiculo -> {
	                	veiculo.setVeiculo(veiculoAtualizado.getVeiculo());
	                	veiculo.setMarca(veiculoAtualizado.getMarca());
	                	veiculo.setAno(veiculoAtualizado.getAno());
	                	veiculo.setDescricao(veiculoAtualizado.getDescricao());
	                	veiculo.setUpdate(LocalDateTime.now());
	                    return repository.save(veiculo);
	                })
	                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo não encontrado") );
	    }
	 
	 @PatchMapping("{id}")
	    public void veiculoVendido( @PathVariable Long id ){
	        Optional<Veiculo> veiculo = repository.findById(id);
	        veiculo.ifPresent( v -> {
	            boolean veiculoVendido = v.getVendido() == Boolean.TRUE;
	            v.setVendido(!veiculoVendido);
	            repository.save(v);
	        });
	    }

	
	
	
	
}
