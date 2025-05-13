package com.example.Trab_ArquiteturaDeSoftware.Service;

import com.example.Trab_ArquiteturaDeSoftware.Model.EnderecoModel;
import com.example.Trab_ArquiteturaDeSoftware.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<EnderecoModel> findAll() {return  enderecoRepository.findAll();}

    public EnderecoModel criarEndereco (EnderecoModel enderecoModel) {return enderecoRepository.save(enderecoModel);}

    public void deletarEndereco(Long id){
        enderecoRepository.deleteById(id);
    }

    public  EnderecoModel atualizarEndereco(Long id, EnderecoModel enderecoModel){
        EnderecoModel novoEndereco =  enderecoRepository.findById(id).get();
        novoEndereco.setNome(enderecoModel.getNome());
        novoEndereco.setBairro(enderecoModel.getBairro());
        novoEndereco.setNumero(enderecoModel.getNumero());
        return enderecoRepository.save(novoEndereco);
    }

    public boolean existsById(Long id) {
        return enderecoRepository.existsById(id);
    }
}
