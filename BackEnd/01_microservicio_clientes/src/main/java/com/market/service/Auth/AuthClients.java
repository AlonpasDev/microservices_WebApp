package com.market.service.Auth;

import com.market.model.Client;

public interface AuthClients {
	Client autenticarCliente(String usuario, String password);
}
