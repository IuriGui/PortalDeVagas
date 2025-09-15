package br.csi.oportunidades.model.usuario;


import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Usuario {

    @Id
    @GeneratedValue
    private UUID uuid;


    private String nome;

    @Column(unique = true)
    private String email;
    private String senha;
    private String telefone;
    @Column(unique = true)
    private String doc;

    private String matricula;

    private String role;


    private String cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;

    private BigDecimal latitude;
    private BigDecimal longitude;


}
