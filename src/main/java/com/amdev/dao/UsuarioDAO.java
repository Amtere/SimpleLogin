package com.amdev.dao;

import java.util.List;

import com.amdev.entity.User;

public interface UsuarioDAO {
	public List<User> getUsuarios();
	
	public void saveUsuario(User usuario);
}
