package com.example.api_busco.Controllers;

import com.example.api_busco.Models.ApiResponse;
import com.example.api_busco.Models.Instituicao;
import com.example.api_busco.Services.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/instituicao")
public class InstituicaoController {
    private final InstituicaoService instituicaoService;

    @Autowired
    public InstituicaoController(InstituicaoService instituicaoService){
        this.instituicaoService = instituicaoService;
    }

    @PostMapping("/inserirIntistuicao")
    public ResponseEntity<ApiResponse> cadastrarInstituicao(@RequestBody Instituicao instituicao){
        ApiResponse response = instituicaoService.cadastrarInstituicao(instituicao);
        if (response.isResponseSucessfull()){
            return ResponseEntity.ok(response);
        }else{
            return ResponseEntity.badRequest().body(response);
        }
    }
}