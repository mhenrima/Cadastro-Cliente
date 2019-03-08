package com.marcelo.client.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@NotEmpty(message = "Preenchimento Obrigatorio")
	String cpf;

	@NotEmpty(message = "Preenchimento Obrigatorio")
	String nome;

	@NotNull
	Calendar nascimento;

	@NotEmpty(message = "Preenchimento Obrigatorio")
	String email;

	@NotEmpty(message = "Preenchimento Obrigatorio")
	String telefone;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(@NotEmpty(message = "Preenchimento Obrigatorio") String name,
			@NotEmpty(message = "Preenchimento Obrigatorio") String cpf,
			@NotEmpty(message = "Preenchimento Obrigatorio") Calendar nascimento,
			@NotEmpty(message = "Preenchimento Obrigatorio") String email,
			@NotEmpty(message = "Preenchimento Obrigatorio") String telefone) {
		super();
		this.nome = name;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.email = email;
		this.telefone = telefone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
