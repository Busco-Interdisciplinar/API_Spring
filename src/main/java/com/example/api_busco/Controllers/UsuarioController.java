package com.example.api_busco.Controllers;

import com.example.api_busco.Models.ApiResponse;
import com.example.api_busco.Models.Usuarios;
import com.example.api_busco.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/api/usuarios")
    public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listarUsuarios")
     public ResponseEntity<ApiResponse> listarUsuarios() {
         ApiResponse response = usuarioService.listarUsuarios();
        if (response.isResponseSucessfull()){
            return ResponseEntity.ok(response);
        }else{
            return ResponseEntity.badRequest().body(response);
        }
     }

    @GetMapping("/login/{email}/{senha}")
    public ResponseEntity<ApiResponse> logar(@PathVariable String email, @PathVariable String senha){
       ApiResponse response = usuarioService.login(email, senha);
       if (response.isResponseSucessfull()){
           return ResponseEntity.ok(response);
       }else{
           return ResponseEntity.badRequest().body(response);
       }
    }

     @PostMapping("/inserirUsuario")
     public ResponseEntity<ApiResponse> inserirUsuario(@RequestBody Usuarios usuario){
         ApiResponse response = usuarioService.cadastrarUsuario(usuario);
         if (response.isResponseSucessfull()){
             return ResponseEntity.ok(response);
         }else{
             return ResponseEntity.badRequest().body(response);
         }
     }

     @DeleteMapping("/excluir/{id}")
     public ResponseEntity<ApiResponse> excluirUsuario(@PathVariable Integer id){
         ApiResponse response = usuarioService.deleteById(id);
         if (response.isResponseSucessfull()){
             return ResponseEntity.ok(response);
         }else{
             return ResponseEntity.badRequest().body(response);
         }
     }

     @GetMapping("/buscarEmail/{email}")
    public ResponseEntity<ApiResponse> findByemail(@PathVariable String email){
         ApiResponse response = usuarioService.findByEmail(email);
         if (response.isResponseSucessfull()){
             return ResponseEntity.ok(response);
         }else{
             return ResponseEntity.badRequest().body(response);
         }
     }
    @GetMapping("/buscarCpfEmailTelefone")
    public ResponseEntity<ApiResponse> findByCpfOrEmailOrTelefone(@Param("cpf") String cpf, @Param("email") String email, @Param("telefone") String telefone){
        ApiResponse response = usuarioService.findByCpfOrEmailOrTelefone(cpf, email, telefone);
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
