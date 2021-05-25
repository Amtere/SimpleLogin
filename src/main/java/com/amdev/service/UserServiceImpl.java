package com.amdev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amdev.dao.UsuarioDAO;
import com.amdev.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	@Transactional
	public List<User> getUsers() {
		return usuarioDAO.getUsuarios();
	}
	
	@Override
	@Transactional
	public void saveUser(User user) {
		usuarioDAO.saveUsuario(user);
	}

}
