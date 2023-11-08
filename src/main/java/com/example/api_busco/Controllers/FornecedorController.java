package com.example.api_busco.Controllers;

import com.example.api_busco.Models.ApiResponse;
import com.example.api_busco.Models.Fornecedor;
import com.example.api_busco.Services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/api/fornecedor")
    public class FornecedorController {
        private final FornecedorService fornecedorService;

        @Autowired
        public FornecedorController(FornecedorService fornecedorService){
            this.fornecedorService = fornecedorService;
        }

        @PostMapping("/inserirFornecedor")
        public ResponseEntity<ApiResponse> cadastrarFornecedor(@RequestBody Fornecedor fornecedor){
            ApiResponse response = fornecedorService.cadastrarFornecedor(fornecedor);
            if (response.isResponseSucessfull()){
                return ResponseEntity.ok(response);
            }else{
                return ResponseEntity.badRequest().body(response);
            }
        }
    @GetMapping("/buscarUserId/{id}")
    public ResponseEntity<ApiResponse> findByUserId(@PathVariable int id){
        ApiResponse response = fornecedorService.findByUserId(id);
        if (response.isResponseSucessfull()){
            return ResponseEntity.ok(response);
        }else{
            return ResponseEntity.badRequest().body(response);
        }
    }
}
