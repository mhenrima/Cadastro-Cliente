package com.marcelo.clientes.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.marcelo.client.model.Client;
import com.marcelo.client.repository.ClientRepository;
import com.marcelo.client.service.ClientServiceControl;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceControlTest {
	
	@InjectMocks
	ClientServiceControl subject;
	
	@Mock
	ClientRepository clienteRepository;
	
	@Spy
	private List<Client> listClient = new ArrayList<>();
	
	@Test
	public void test4ListaClientes() {
		//preparação
		when(clienteRepository.findAll()).thenReturn(listClient);
		
		//execução
		subject.listaClientes();
		
		//verificação
		verify(clienteRepository).findAll();
	}
	
	@Test
	public void test4CadastraCliente() {
		//preparação
		Client clientAux = new Client();
		clientAux.setNome("Marcelo Henrique");
		clientAux.setCpf("70999323067");
		clientAux.setNascimento("14/06/1996");
		clientAux.setEmail("marcelo@teste.com");
		clientAux.setTelefone("999990000");
		
		//execução
		subject.cadastraCliente(clientAux);
	}
	
	@Test(expected = NullPointerException.class) 
	public void test4CadastraClienteFailNameNull() {
		//preparação
		Client clientAux = new Client();
		clientAux.setCpf("70999323067");
		clientAux.setNascimento("14/06/1996");
		clientAux.setEmail("marcelo@teste.com");
		clientAux.setTelefone("999990000");
		
		//execução
		subject.cadastraCliente(clientAux);
	}
	
	@Test(expected = InvalidParameterException.class) 
	public void test4CadastraClienteFailCpfInvalido() {
		//preparação
		Client clientAux = new Client();
		clientAux.setNome("Marcelo Henrique");
		clientAux.setCpf("70999322267");
		clientAux.setNascimento("14/06/1996");
		clientAux.setEmail("marcelo@teste.com");
		clientAux.setTelefone("999990000");
		
		//execução
		subject.cadastraCliente(clientAux);
	}
	@Test(expected = NullPointerException.class) 
	public void test4CadastraClienteFailCpfNull() {
		//preparação
		Calendar cal = Calendar.getInstance();
		Client clientAux = new Client();
		clientAux.setNome("Marcelo Henrique");
		clientAux.setNascimento("14/06/1996");
		clientAux.setEmail("marcelo@teste.com");
		clientAux.setTelefone("999990000");
		
		//execução
		subject.cadastraCliente(clientAux);
	}
	
	@Test(expected = NullPointerException.class) 
	public void test4CadastraClienteFailNascimentoNull() {
		//preparação
		Client clientAux = new Client();
		clientAux.setNome("Marcelo Henrique");
		clientAux.setCpf("70999323067");
		clientAux.setEmail("marcelo@teste.com");
		clientAux.setTelefone("999990000");
		
		//execução
		subject.cadastraCliente(clientAux);
	}
	
	@Test(expected = NullPointerException.class) 
	public void test4CadastraClienteFailEmailNull() {
		//preparação
		Client clientAux = new Client();
		clientAux.setNome("Marcelo Henrique");
		clientAux.setCpf("70999323067");
		clientAux.setNascimento("14/06/1996");
		clientAux.setTelefone("999990000");
		
		//execução
		subject.cadastraCliente(clientAux);
	}
	
	@Test(expected = NullPointerException.class) 
	public void test4CadastraClienteFailTelefoneNull() {
		//preparação
		Client clientAux = new Client();
		clientAux.setNome("Marcelo Henrique");
		clientAux.setCpf("70999323067");
		clientAux.setNascimento("14/06/1996");
		clientAux.setEmail("marcelo@teste.com");
		
		//execução
		subject.cadastraCliente(clientAux);
	}
	
	@Test
	public void test4ValidaCpf() {
		//execução
		subject.validaCpf("70999323067");
	}
	
	@Test
	public void test4ValidaCpfFail() {
		//execução
		subject.validaCpf("33333333333");
	}
	
	
	
}
