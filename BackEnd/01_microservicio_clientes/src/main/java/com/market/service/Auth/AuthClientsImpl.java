package com.market.service.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.model.Client;
import com.market.repository.RepositoryClients;
@Service
public class AuthClientsImpl implements AuthClients {
	
	@Autowired
	RepositoryClients clientesRepository;

	@Override
	public Client autenticarCliente(String usuario, String password) {
		return clientesRepository.findByUsuarioAndPassword(usuario, password);
	}

}
 