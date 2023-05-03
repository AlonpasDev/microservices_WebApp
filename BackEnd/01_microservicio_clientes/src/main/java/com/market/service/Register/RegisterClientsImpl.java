package com.market.service.Register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.model.Client;
import com.market.repository.RepositoryClients;
@Service
public class RegisterClientsImpl implements RegisterClients {
	
	@Autowired
	RepositoryClients clientesRepository;

	@Override
	public boolean registrarCliente(Client cliente) {
		if(clientesRepository.findById(cliente.getUsuario()).isPresent()) {
			return false;
		}
		clientesRepository.save(cliente);
		return true;
	}

}
 