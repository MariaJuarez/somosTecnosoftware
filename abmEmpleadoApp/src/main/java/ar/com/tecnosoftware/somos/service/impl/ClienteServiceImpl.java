package ar.com.tecnosoftware.somos.service.impl;

import ar.com.tecnosoftware.somos.entity.Cliente;
import ar.com.tecnosoftware.somos.repository.ClienteRepository;
import ar.com.tecnosoftware.somos.repository.RubroRepository;
import ar.com.tecnosoftware.somos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RubroRepository rubroRepository;

    @Override
    public void add(Cliente cliente) {
        cliente.setRubro(rubroRepository.buscar(cliente.getRubro().getIdRubro()));
        clienteRepository.guardar(cliente);
    }

    @Override
    public Cliente buscar(int id) {
        return clienteRepository.buscar(id);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepository.buscarTodos();
    }

    @Override
    public void darBaja(int id) {
        clienteRepository.darBaja(clienteRepository.buscar(id));
    }
}
