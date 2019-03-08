package com.marcelo.clientes.model;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.marcelo.client.model.Client;

@RunWith(SpringRunner.class)
public class ClientTest {

	@Test
	public void testConstructor() {
		//preparação
		Calendar cal = Calendar.getInstance();
		
		//execução
		Client client = new Client("Marcelo Henrique Machado","70999323067",cal,"marcelo@teste.com","991000000");
		client.getId();
		client.setId(2);
	}
}
