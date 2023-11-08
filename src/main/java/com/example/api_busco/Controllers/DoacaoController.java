package com.example.api_busco.Controllers;

import com.example.api_busco.Models.ApiResponse;
import com.example.api_busco.Models.Doacao;
import com.example.api_busco.Models.Fornecedor;
import com.example.api_busco.Services.DoacaoService;
import com.example.api_busco.Services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doacao")
public class DoacaoController {
    private final DoacaoService doacaoService;

    @Autowired
    public DoacaoController(DoacaoService doacaoService){
        this.doacaoService = doacaoService;
    }

    @PostMapping("/fazerDoacao")
    public ResponseEntity<ApiResponse> fazerDoacao(@RequestBody Doacao doacao){
        ApiResponse response = doacaoService.fazerDoacao(doacao);
        if (response.isResponseSucessfull()){
            return ResponseEntity.ok(response);
        }else{
            return ResponseEntity.badRequest().body(response);
        }
    }
    @GetMapping("/buscarUserId/{id}")
    public ResponseEntity<ApiResponse> findByUserId(@PathVariable int id){
        ApiResponse response = doacaoService.findByUserId(id);
        if (response.isResponseSucessfull()){
            return ResponseEntity.ok(response);
        }else{
            return ResponseEntity.badRequest().body(response);
        }
    }
}