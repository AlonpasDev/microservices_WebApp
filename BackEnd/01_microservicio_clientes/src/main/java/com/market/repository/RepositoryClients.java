package com.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.model.Client;

public interface RepositoryClients extends JpaRepository<Client, String> {
	Client findByUsuarioAndPassword(String usuario, String password);
}
