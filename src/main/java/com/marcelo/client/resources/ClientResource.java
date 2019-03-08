package com.marcelo.client.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcelo.client.model.Client;
import com.marcelo.client.repository.ClientRepository;
import com.marcelo.client.service.ClientServiceControl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/Clientes")
@Api(value = "CADASTRO-CLIENTES")
@CrossOrigin(origins = "*")
public class ClientResource {

	@Autowired
	private ClientServiceControl clientServiceControl;

	@Autowired
	private ClientRepository clienteRepository;

	@PostMapping
	@ApiOperation(value = "Cadastra Clientes")
	public ResponseEntity<Void> cadastraClientes(@Valid @RequestBody Client client) {
		Client objResponse = clientServiceControl.cadastraCliente(client);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objResponse.getCpf())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	@ApiOperation(value = "Altera Clientes")
	public ResponseEntity<Client> updateClient(@RequestBody Client clientUpdate, @RequestParam String cpf) {
		List<Client> clientAll = clienteRepository.findAll();
		for (Client client : clientAll) {
			if (client.getCpf().equals(cpf)) {
				client.setNome(clientUpdate.getNome());
				client.setCpf(clientUpdate.getCpf());
				client.setEmail(clientUpdate.getEmail());
				client.setNascimento(client.getNascimento());
				client.setTelefone(clientUpdate.getTelefone());
				clienteRepository.save(client);
				return ResponseEntity.ok().body(client);
			} else
				return ResponseEntity.notFound().build();

		}
		return null;

	}

	@DeleteMapping
	@ApiOperation(value = "Exclui Clientes")
	public void deleteClient(@RequestParam String cpf) {
		List<Client> clientAll = clienteRepository.findAll();
		Integer id = null;
		for (Client client : clientAll) {
			if (client.getCpf().equals(cpf)) {
				id = client.getId();
			}
		}
		clienteRepository.deleteById(id);
	}

	@GetMapping
	@ApiOperation(value = "Lista Clientes")
	public ResponseEntity<List<Client>> listaClient() {
		List<Client> listAll = clientServiceControl.listaClientes();

		return ResponseEntity.ok().body(listAll);
	}

}
