package br.csi.oportunidades.model.usuario.types;

import br.csi.oportunidades.model.inscricao.Inscricao;
import br.csi.oportunidades.model.usuario.Usuario;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;


@Entity
@DiscriminatorValue("ESTUDANTE")
public class Candidate extends Usuario {

    @OneToMany(mappedBy = "candidato")
    private List<Inscricao> inscricoes;

}
