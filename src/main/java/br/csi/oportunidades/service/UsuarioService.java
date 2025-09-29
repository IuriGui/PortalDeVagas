package br.csi.oportunidades.service;


import br.csi.oportunidades.model.usuario.Usuario;
import br.csi.oportunidades.repositories.UsuarioRepository;
import br.csi.oportunidades.util.PartialUpdateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final BCryptPasswordEncoder encoder;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.repository = usuarioRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Optional<Usuario> findById(UUID id) {
        return repository.findById(id);
    }

    public void save(Usuario usuario) {
        if ("ADMIN".equalsIgnoreCase(usuario.getRole())) {
            throw new SecurityException("Você não tem permissão para criar um ADMIN");
        }
        usuario.setSenha(encoder.encode(usuario.getSenha()));

        repository.save(usuario);
    }
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public void update(Usuario usuario, UUID id) {


        Optional<Usuario> optionalUsuario = repository.findById(id);


        if (optionalUsuario.isPresent()) {
            Usuario existingUsuario = optionalUsuario.get();
            PartialUpdateUtils.copyNonNullProperties(usuario, existingUsuario);
            repository.save(existingUsuario);
        } else {
            throw new RuntimeException("Usuario com UUID " + id + " não encontrado.");
        }
    }

}
