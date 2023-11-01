package com.example.api_busco.Services;

import com.example.api_busco.Models.ApiResponse;
import com.example.api_busco.Models.Produto;
import com.example.api_busco.Models.Usuarios;
import com.example.api_busco.Repositorys.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public ApiResponse listarProdutos(){
        try {
            List<Produto> produtos = produtoRepository.findAll();
            return new ApiResponse(true, "Produtos retornados com sucesso", Collections.singletonList(produtos), null);
        }catch (Exception exception){
            return new ApiResponse(false, "Falha ao retornar produtos", null, null);
        }
    }
}
