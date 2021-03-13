package com.algaworks.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;

@RestController//Controller é a Classe que receberá as requisições e deverá respondê-las
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Samuel Macedo dos Santos");
		cliente1.setEmail("samuelmacedo2002@yahoo.com.br");
		cliente1.setTelefone("(11) 98194-4150");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Leticia Nascimento Soares");
		cliente2.setEmail("nascimento_leticia@hotmail.com");
		cliente2.setTelefone("(11) 98806-0629");
		
		
		return Arrays.asList(cliente1,cliente2);
	}

}
