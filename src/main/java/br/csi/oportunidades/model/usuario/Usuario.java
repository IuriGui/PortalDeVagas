package br.csi.oportunidades.model.usuario;


import br.csi.oportunidades.model.usuario.types.Business;
import br.csi.oportunidades.model.usuario.types.Candidate;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "role"
)



@JsonSubTypes({
            @JsonSubTypes.Type(value = Candidate.class, name = "ESTUDANTE"),
        @JsonSubTypes.Type(value = Business.class, name = "EMPRESA")
})

public abstract class Usuario {

    @Id
    @GeneratedValue
    private UUID uuid;


    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 50, message = "O nome deve ter no máximo 50 caracteres")
    private String nome;

    @Column(unique = true)
    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;


    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 8, max = 12, message = "A senha deve conter entre 8 e 12 dígitos")
    private String senha;

    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter 10 ou 11 dígitos numéricos")
    private String telefone;

    @Column(unique = true)
    @NotBlank(message = "O documento é obrigatório")
    @Size(min = 11, max = 14, message = "O documento deve ter entre 11 e 14 caracteres")
    private String doc;

    @Size(max = 8, message = "A matrícula deve ter no máximo 20 caracteres")
    private String matricula;

    @Column(insertable = false, updatable = false)
    private String role;


    @Pattern(regexp = "\\d{8}", message = "O CEP deve conter 8 dígitos numéricos")
    private String cep;

    @Size(max = 2, message = "UF deve conter 2 caracteres")
    private String uf;

    @Size(max = 50, message = "A cidade deve ter no máximo 50 caracteres")
    private String cidade;

    @Size(max = 50, message = "O bairro deve ter no máximo 50 caracteres")
    private String bairro;

    @Size(max = 100, message = "A rua deve ter no máximo 100 caracteres")
    private String rua;

    @Size(max = 10, message = "O número deve ter no máximo 10 caracteres")
    private String numero;

    @Size(max = 100, message = "O complemento deve ter no máximo 100 caracteres")
    private String complemento;



    private BigDecimal latitude;
    private BigDecimal longitude;

}
