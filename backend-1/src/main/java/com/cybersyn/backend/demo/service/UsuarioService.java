package com.cybersyn.backend.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybersyn.backend.demo.models.entities.Usuario;
import com.cybersyn.backend.demo.repository.IUsuarioRepository;

@Service
public class UsuarioService {

  @Autowired
  private IUsuarioRepository usuarioRepository;

  public Usuario registrar(Usuario usuario){
    return usuarioRepository.save(usuario);
  }

  public Usuario login(String email, String password){
    return usuarioRepository.findByEmail(email)
    .filter(u -> u.getPassword().equals(password))
    .orElse(null);
  }



}
