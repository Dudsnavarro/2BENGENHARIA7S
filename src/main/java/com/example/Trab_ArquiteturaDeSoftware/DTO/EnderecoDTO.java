package com.example.Trab_ArquiteturaDeSoftware.DTO;

import com.example.Trab_ArquiteturaDeSoftware.Model.EnderecoModel;

public class EnderecoDTO {

    private Long id;
    private String nome;
    private String numero;
    private String bairro;

    public EnderecoDTO (Long id, String nome, String numero, String bairro){
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.bairro = bairro;
    }

    public static EnderecoDTO fromEntity (EnderecoModel endereco){
        return new EnderecoDTO(endereco.getId(), endereco.getNome(), endereco.getNumero(), endereco.getBairro());
    }

    public static EnderecoModel toEntity (EnderecoModel dto){
        EnderecoModel endereco = new EnderecoModel();
        endereco.setId(dto.getId());
        endereco.setNome(dto.getNome());
        endereco.setNumero(dto.getNumero());
        endereco.setBairro(dto.getBairro());
        return endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
