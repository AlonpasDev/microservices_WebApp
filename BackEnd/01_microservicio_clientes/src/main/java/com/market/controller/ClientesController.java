package com.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.model.Client;
import com.market.service.Auth.AuthClients;
import com.market.service.Register.RegisterClients;

@CrossOrigin("*")
@RestController
public class ClientesController {
	@Autowired
	AuthClients authClient;
	RegisterClients registerClient;
	@GetMapping(value="autenticar",produces = MediaType.APPLICATION_JSON_VALUE)
	public Client autenticar(@RequestParam("usuario") String usuario, @RequestParam("password") String password) {
		return authClient.autenticarCliente(usuario, password);
	}
	@PostMapping(value="registrar",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> registrar(@RequestBody Client cliente) {
		if(registerClient.registrarCliente(cliente)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
}
