package ar.com.tecnosoftware.somos.service;

import ar.com.tecnosoftware.somos.usuario.entity.Usuario;

public interface UsuarioService extends Service<Usuario> {

    Usuario buscarUsuarioConEmpleado(int idEmpleado);

    void darBajaEmpleadoDeUsuario(Usuario usuario);

}