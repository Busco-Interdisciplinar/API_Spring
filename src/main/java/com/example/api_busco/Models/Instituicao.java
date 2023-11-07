
package com.example.api_busco.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "instituicao")
public class Instituicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cnpj;
    private String cep_sede;
    private String nome;
    private String telefone;
    private int usuario_padrao;

    public Instituicao(String cnpj, String cep_sede, String nome, String telefone, int usuario_padrao) {
        this.cnpj = cnpj;
        this.cep_sede = cep_sede;
        this.nome = nome;
        this.telefone = telefone;
        this.usuario_padrao = usuario_padrao;
    }
}
