package com.example.api_busco.Controllers;

import com.example.api_busco.Models.ApiResponse;
import com.example.api_busco.Models.Usuarios;
import com.example.api_busco.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/usuarios")
    public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listarUsuarios")
     public ResponseEntity<ApiResponse> listarProdutos() {
         ApiResponse response  = usuarioService.listarUsuarios();
        if (response.isResponseSucessfull()){
            return ResponseEntity.ok(response);
        }else{
            return ResponseEntity.badRequest().body(response);
        }
     }

    @GetMapping("/login/{email}/{senha}")
    public ResponseEntity<ApiResponse> getProdutoPorId(@PathVariable String email, @PathVariable String senha){
       ApiResponse response = usuarioService.login(email, senha);
       if (response.isResponseSucessfull()){
           return ResponseEntity.ok(response);
       }else{
           return ResponseEntity.badRequest().body(response);
       }
    }

     @PostMapping("/inserirUsuario")
     public ResponseEntity<ApiResponse> inserirPorduto(@RequestBody Usuarios usuario){
         ApiResponse response = usuarioService.cadastrarUsuario(usuario);
         if (response.isResponseSucessfull()){
             return ResponseEntity.ok(response);
         }else{
             return ResponseEntity.badRequest().body(response);
         }
     }

     @DeleteMapping("/excluir/{id}")
     public ResponseEntity<ApiResponse> excluirProduto(@PathVariable Integer id){
         ApiResponse response = usuarioService.deleteById(id);
         if (response.isResponseSucessfull()){
             return ResponseEntity.ok(response);
         }else{
             return ResponseEntity.badRequest().body(response);
         }
     }

//     @PutMapping("/atualizar/{id}")
//     public ResponseEntity<String> atualizarProduto(@PathVariable Long id,
//                                                    @RequestBody Usuarios produtoAtualizado
//     ){
//         Optional<Usuarios> produtoExistente = usuarioRepository.findById(id);
//         if (produtoExistente.isPresent()){
//             Usuarios produto = produtoExistente.get();
//             produto.setNome(produtoAtualizado.getNome());
//             produto.setDescricao(produtoAtualizado.usuarioRepository());
//             produto.setPreco(produtoAtualizado.getPreco());
//             produto.setQuantidadeestoque(produtoAtualizado.getQuantidadeestoque());
//             produtoRepository.save(produto);
//             return ResponseEntity.ok("Produto alterado!");
//         }
//         else{
//             return ResponseEntity.notFound().build();
//         }
//     }
 }
