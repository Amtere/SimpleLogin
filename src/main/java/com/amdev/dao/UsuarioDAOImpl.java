package com.amdev.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amdev.entity.User;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getUsuarios() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("from User", User.class);
		List<User> users = theQuery.getResultList();
		return users;
	}
	
	@Override
	public void saveUsuario(User usuario) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(usuario);
	}

}
