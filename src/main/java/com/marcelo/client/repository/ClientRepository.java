package com.marcelo.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.client.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
