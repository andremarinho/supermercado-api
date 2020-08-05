package com.supermercado.resources;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.supermercado.domain.Cliente;
import com.supermercado.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResources {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> clientes = this.clienteService.findAll();
		return ResponseEntity.status(HttpStatus.CREATED).body(clientes);
	}

	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente, HttpServletResponse response) {
		Cliente clienteSalvo = this.clienteService.insert(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
	}

}
