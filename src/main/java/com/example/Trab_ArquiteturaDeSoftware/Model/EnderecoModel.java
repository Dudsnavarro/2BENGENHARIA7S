package com.example.Trab_ArquiteturaDeSoftware.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_ENDERECO")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String numero;
    private String bairro;

    public EnderecoModel(){}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getNumero() {return numero;}

    public void setNumero(String numero) {this.numero = numero;}

    public String getBairro() {return bairro;}

    public void setBairro(String bairro) {this.bairro = bairro;}
}
