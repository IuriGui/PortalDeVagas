package br.csi.oportunidades.model.usuario.types;

import br.csi.oportunidades.model.oportunidade.Oportunidade;
import br.csi.oportunidades.model.usuario.Usuario;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;


@Entity
@DiscriminatorValue("EMPRESA")
public class Business extends Usuario {


    @OneToMany(mappedBy = "instituicao")
    private List<Oportunidade> oportunidades;




}
