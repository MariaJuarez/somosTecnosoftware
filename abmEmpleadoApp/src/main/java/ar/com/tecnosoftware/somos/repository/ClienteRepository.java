package ar.com.tecnosoftware.somos.repository;

import ar.com.tecnosoftware.somos.entity.Cliente;

import java.util.List;

public interface ClienteRepository {

    public void guardar(Cliente cliente);

    public Cliente buscar(int id);

    public List<Cliente> buscarTodos();

    public void darBaja(Cliente cliente);

}
