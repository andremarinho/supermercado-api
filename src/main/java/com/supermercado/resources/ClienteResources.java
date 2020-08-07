package com.supermercado.resources;

import java.util.List;

import javax.naming.NoPermissionException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.supermercado.domain.Cliente;
import com.supermercado.filter.ClienteFilter;
import com.supermercado.service.impl.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResources {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> clientes;
		
			clientes = this.clienteService.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(clientes);
		
		
	}
	
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<Cliente> findByCodigo(@PathVariable Long codigo, HttpServletResponse response){
		
		
		try {
			Cliente clienteSalvo = this.clienteService.findByCodigo(codigo);
			return ResponseEntity.status(HttpStatus.OK).body(clienteSalvo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		
	}
	
	
	@GetMapping("/{cpf}")
	public ResponseEntity<Cliente> findByCpf(@PathVariable String cpf, HttpServletResponse response){
		Cliente cliente = this.clienteService.findByCpf(cpf);
		
		if(cliente != null) {
			return ResponseEntity.ok().body(cliente);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}

	
	@PostMapping
	public ResponseEntity<Cliente> insert(@Valid @RequestBody  Cliente cliente, HttpServletResponse response) {
		
		Cliente clienteSalvo;
		
		try {
			clienteSalvo = this.clienteService.insert(cliente);
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
			
		}
			
		
	}
	
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Object> delete(@PathVariable Long codigo) {
		
		try {
			this.clienteService.delete(codigo);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
	
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Cliente> update(@PathVariable Long codigo, @RequestBody Cliente cliente){
		
						
		try {
			Cliente clienteAtualizado = this.clienteService.update(codigo, cliente);
			return ResponseEntity.ok().body(clienteAtualizado);
		} catch (Exception e1) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		
		
	}
	
	@PostMapping("/filtro")
	public ResponseEntity<List<Cliente>> clienteFiltro( @RequestBody ClienteFilter clienteFilter, HttpServletResponse response ){
		
		List<Cliente> clientes = this.clienteService.findClienteByFilter(clienteFilter);
		
		return ResponseEntity.ok().body(clientes);
	}

}
