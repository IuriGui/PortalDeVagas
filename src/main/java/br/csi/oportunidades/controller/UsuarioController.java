package br.csi.oportunidades.controller;


import br.csi.oportunidades.model.usuario.Usuario;
import br.csi.oportunidades.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
    @Transactional
    public ResponseEntity<Usuario> saveUsuario(@RequestBody @Valid Usuario usuario,
                                               UriComponentsBuilder uriBuilder) {
        usuarioService.save(usuario);

        URI location = uriBuilder.path("/usuario/{uuid}").buildAndExpand(usuario.getUuid()).toUri();

        return ResponseEntity.created(location).body(usuario);
    }

    @DeleteMapping("{id}")
    public void deleteUsuario(@PathVariable UUID id) {
        usuarioService.delete(id);
    }

    @PutMapping("{id}")
    public void updateUsuario(@RequestBody Usuario usuario, @PathVariable UUID id) {
        usuarioService.update(usuario, id);
    }




}
