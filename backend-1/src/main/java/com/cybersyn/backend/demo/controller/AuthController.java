package com.cybersyn.backend.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybersyn.backend.demo.models.dtos.LoginRequest;
import com.cybersyn.backend.demo.models.dtos.LoginResponse;
import com.cybersyn.backend.demo.models.entities.Usuario;
import com.cybersyn.backend.demo.service.UsuarioService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

  @Autowired
  private UsuarioService usuarioService;


  @PostMapping("/registrar")
  public Usuario registrar(@RequestBody Usuario usuario){
    return usuarioService.registrar(usuario);
  }

  // @PostMapping("/login")
  // public Usuario login(@RequestBody LoginRequest request){
  //   return usuarioService.login(request.getEmail(), request.getPassword());
  // }

  @PostMapping("/login")
public LoginResponse login(@RequestBody LoginRequest request) {
    Usuario u = usuarioService.login(request.getEmail(), request.getPassword());

    if (u == null) return null;

    LoginResponse res = new LoginResponse();
    res.setId(u.getId());
    res.setName(u.getName());
    res.setEmail(u.getEmail());
    res.setRole(u.getRole());

    return res;
}

}
