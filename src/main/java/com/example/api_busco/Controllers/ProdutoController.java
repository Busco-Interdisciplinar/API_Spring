package com.example.api_busco.Controllers;

import com.example.api_busco.Models.ApiResponse;
import com.example.api_busco.Repositorys.ProdutoRepository;
import com.example.api_busco.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/api/produto")
    public class ProdutoController {
        private final ProdutoService produtoService;

        @Autowired
        public ProdutoController(ProdutoService produtoService){
            this.produtoService = produtoService;
        }

        @GetMapping("/listarProdutos")
    public ResponseEntity<ApiResponse> listarProdutos(){
            ApiResponse response = produtoService.listarProdutos();
            if (response.isResponseSucessfull()){
                return ResponseEntity.ok(response);
            }else{
                return ResponseEntity.badRequest().body(response);
            }
        }
    }
