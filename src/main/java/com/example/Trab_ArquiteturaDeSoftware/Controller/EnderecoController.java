package com.example.Trab_ArquiteturaDeSoftware.Controller;

import com.example.Trab_ArquiteturaDeSoftware.DTO.EnderecoDTO;
import com.example.Trab_ArquiteturaDeSoftware.Model.EnderecoModel;
import com.example.Trab_ArquiteturaDeSoftware.Service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/enderecos")
@CrossOrigin(origins = "*")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<EnderecoDTO> listarEnderecos() {
        return enderecoService.findAll().stream()
                .map(EnderecoDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<?> criarEndereco(@RequestBody EnderecoModel enderecoModel){
        if (enderecoModel.getId() != null){
            return ResponseEntity.badRequest().body("ID deve ser nulo ao criar um novo endereco.");
        }

        EnderecoModel novoEndereco = enderecoService.criarEndereco(enderecoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novoEndereco.getId())
                .toUri();
        return ResponseEntity.created(uri).body(novoEndereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEndereco(@PathVariable Long id){
        if (!enderecoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco nao encontrado");
        }
        enderecoService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EnderecoModel enderecoModel){
        if (!enderecoService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa nao encontrado");
        }
        try{
            EnderecoModel responde = enderecoService.atualizarEndereco(id, enderecoModel);
            return ResponseEntity.ok().body(responde);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar pessoa");
        }
    }
}
