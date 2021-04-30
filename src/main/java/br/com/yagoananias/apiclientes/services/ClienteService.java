package br.com.yagoananias.apiclientes.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yagoananias.apiclientes.domain.Cliente;
import br.com.yagoananias.apiclientes.repositories.ClienteRepository;
import br.com.yagoananias.apiclientes.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository; 
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
