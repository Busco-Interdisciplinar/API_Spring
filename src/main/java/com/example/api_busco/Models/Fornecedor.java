package com.example.api_busco.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cnpj;
    private String telefone;
    private String nome;
    private String email;
    private int usuario_padrao;

    public Fornecedor(String cnpj, String telefone, String nome, String email, int usuario_padrao) {
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.nome = nome;
        this.email = email;
        this.usuario_padrao = usuario_padrao;
    }
}
