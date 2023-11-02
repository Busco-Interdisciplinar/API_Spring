package com.example.api_busco.Models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "usuario_padrao")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String senha;
    private String cep;
    private String nome;
    private String cpf;
    private Date data_cadastro;
    private int qnt_doacao;
    private String telefone;
    private String foto;

    public Usuarios(String email, String senha, String cep, String nome, String cpf, Date data_cadastro, int qnt_doacao, String telefone, String foto) {
        this.email = email;
        this.senha = senha;
        this.cep = cep;
        this.nome = nome;
        this.cpf = cpf;
        this.data_cadastro = data_cadastro;
        this.qnt_doacao = qnt_doacao;
        this.telefone = telefone;
        this.foto = foto;
    }
}
