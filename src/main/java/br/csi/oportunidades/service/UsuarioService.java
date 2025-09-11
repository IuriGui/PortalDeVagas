package br.csi.oportunidades.service;


import br.csi.oportunidades.model.Usuario;
import br.csi.oportunidades.model.UsuarioRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.repository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Optional<Usuario> findById(UUID id) {
        return repository.findById(id);
    }
    public void save(Usuario usuario) {
        repository.save(usuario);
    }
    public void delete(UUID id) {
        repository.deleteById(id);
    }



}
