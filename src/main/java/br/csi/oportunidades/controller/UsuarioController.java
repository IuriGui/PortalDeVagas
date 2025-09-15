package br.csi.oportunidades.controller;


import br.csi.oportunidades.model.usuario.Usuario;
import br.csi.oportunidades.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Get all Users
    @GetMapping("/listar")
    public List<Usuario> listUsuarios() {
        return usuarioService.findAll();
    }

    //Get One User
    @GetMapping("{id}")
    public Optional<Usuario> getUsuario(@PathVariable UUID id) {
        return usuarioService.findById(id);
    }


    @PostMapping
    public void saveUsuario(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
    }

    @DeleteMapping("{id}")
    public void deleteUsuario(@PathVariable UUID id) {
        usuarioService.delete(id);
    }

    @PutMapping("{id}")
    public void updateUsuario(@RequestBody Usuario usuario) {
        usuarioService.update(usuario);
    }




}
