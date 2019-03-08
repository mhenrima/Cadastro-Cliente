package com.marcelo.clientes.resources;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.marcelo.client.model.Client;
import com.marcelo.client.repository.ClientRepository;
import com.marcelo.client.resources.ClientResource;
import com.marcelo.client.service.ClientServiceControl;

@RunWith(MockitoJUnitRunner.class)
public class ClientResourceTest {

	@InjectMocks
	ClientResource subject;

	@Mock
	ClientServiceControl clientServiceControl;

	@Mock
	ClientRepository clientRepository;

	@Spy
	private List<Client> listClient = new ArrayList<>();

	@Test
	public void test4CadastraClientes() {
		// preparacao
		Client client = mock(Client.class);
		when(clientServiceControl.cadastraCliente(client)).thenReturn(client);
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		// execucao
		subject.cadastraClientes(client);

		// validacao
		verify(clientServiceControl).cadastraCliente(client);
	}

	@Test
	public void test4UpdateClient() {
		// preparação
		Client client = mock(Client.class);

		when(clientRepository.findAll()).thenReturn(listClient());
		// execucação
		subject.updateClient(client, "70999323067");

		// verificação
		verify(clientRepository).findAll();

	}

	@Test
	public void test4UpdateClientFailCpfDiferente() {
		// preparação
		Client client = mock(Client.class);

		when(clientRepository.findAll()).thenReturn(listClient());
		// execucação
		subject.updateClient(client, "70999323167");

		// verificação
		verify(clientRepository).findAll();

	}

	@Test
	public void test4UpdateClientFailListNull() {
		// preparação
		Client client = mock(Client.class);

		when(clientRepository.findAll()).thenReturn(listClient);
		// execucação
		subject.updateClient(client, "70999323167");

		// verificação
		verify(clientRepository).findAll();

	}

	@Test
	public void test4Delete() {
		// Preparação
		when(clientRepository.findAll()).thenReturn(listClient());
		// Execução
		subject.deleteClient("70999323067");
		// Validação
		verify(clientRepository).findAll();
	}

	@Test
	public void test4DeleteFailCpfDiferente() {
		// Preparação
		when(clientRepository.findAll()).thenReturn(listClient());
		// Execução
		subject.deleteClient("70999323117");
		// Validação
		verify(clientRepository).findAll();
	}

	@Test
	public void test4DeleteFailListNull() {
		// Preparação
		when(clientRepository.findAll()).thenReturn(listClient);
		// Execução
		subject.deleteClient("70999323117");
		// Validação
		verify(clientRepository).findAll();
	}
	
	@Test
	public void test4ListaClient() {
		//preparação
		when(clientServiceControl.listaClientes()).thenReturn(listClient);
		//execução
		subject.listaClient();
		//verificação
		verify(clientServiceControl).listaClientes();
	}

	
	private List<Client> listClient() {
		Calendar cal = Calendar.getInstance();
		List<Client> listClientAux = new ArrayList<>();
		Client clientAux = new Client();
		clientAux.setNome("Marcelo Henrique");
		clientAux.setCpf("70999323067");
		clientAux.setNascimento(cal);
		clientAux.setEmail("marcelo@teste.com");
		clientAux.setTelefone("999990000");
		listClientAux.add(clientAux);

		return listClientAux;
	}

}
