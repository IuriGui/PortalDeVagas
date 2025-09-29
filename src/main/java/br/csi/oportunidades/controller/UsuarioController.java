package br.csi.oportunidades.controller;


import br.csi.oportunidades.model.usuario.Usuario;
import br.csi.oportunidades.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuario")
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



    @GetMapping("{id}")
    public Optional<Usuario> getUsuario(@PathVariable UUID id) {
        return usuarioService.findById(id);
    }


    @PostMapping
    @Transactional
    @Operation(summary = "Criar novo usuário", description = "cria novo usuário")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201", description = "Usuário criado com sucesso",
                    content = @Content(mediaType = "aplication/json", schema = @Schema(implementation = Usuario.class))
            ),
            @ApiResponse(
                    responseCode = "400", description = "invalid parameters"
            )
    })
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
