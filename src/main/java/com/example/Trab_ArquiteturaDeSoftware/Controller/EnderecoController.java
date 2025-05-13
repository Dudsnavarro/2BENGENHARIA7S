package com.example.Trab_ArquiteturaDeSoftware.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/controles")
public class EnderecoController {

    @Autowired
    private EnderecoService trabalhoservice;


}
