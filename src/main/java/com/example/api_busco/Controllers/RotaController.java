package com.example.api_busco.Controllers;

import com.example.api_busco.Models.ApiResponse;
import com.example.api_busco.Services.RotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/api/rota")
    public class RotaController {
        private final RotaService rotaService;

        @Autowired
        public RotaController(RotaService rotaService){
            this.rotaService = rotaService;
        }

        @GetMapping("/buscarRota/{rota}")
        public ResponseEntity<ApiResponse> buscarRota(@PathVariable int rota){
            ApiResponse response = rotaService.buscarRota(rota);
            if (response.isResponseSucessfull()){
                return ResponseEntity.ok(response);
            }else{
                return ResponseEntity.badRequest().body(response);
            }
        }
    }
