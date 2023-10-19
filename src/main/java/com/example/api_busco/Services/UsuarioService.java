package com.example.api_busco.Services;

import com.example.api_busco.Models.ApiResponse;
import com.example.api_busco.Models.Usuarios;
import com.example.api_busco.Repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.*;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public ApiResponse listarUsuarios(){
        try {
            List<Usuarios> usuarios = usuarioRepository.findAll();
            return new ApiResponse(true, "Usuários retornados com sucesso", usuarios, null);
        }catch (Exception exception){
            return new ApiResponse(false, "Falha ao retornar usuários", null, null);
        }
    }

    public ApiResponse cadastrarUsuario(Usuarios usuario){
        try {
            Usuarios usuarioResponse = usuarioRepository.save(usuario);
            List<Usuarios> usuariosList = Collections.singletonList(usuarioResponse);
            return new ApiResponse(true, "Usuário inserido com sucesso", usuariosList, null);
        }catch (Exception exception){
            return new ApiResponse(false, "Usuário já existe no banco", null, null);
        }
    }

    public ApiResponse login(String email, String senha){
        try{
            Usuarios usuario = usuarioRepository.findByEmail(email);
            List<Usuarios> usuariosList = Collections.singletonList(usuario);
            if (usuario != null && usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)){
                return new ApiResponse(true, "Usuário logado com sucesso", usuariosList, null);
            }else{
                return new ApiResponse(false, "Email ou senha incorretos", null, null);
            }
        }catch (Exception exception){
            return new ApiResponse(false, "Falha ao realizar login", null, null);
        }
    }

    public ApiResponse deleteById(Integer id){
        try {
            Optional<Usuarios> usuarioFound = usuarioRepository.findById(id);
            if (usuarioFound.isPresent()){
                usuarioRepository.deleteById(id);
                usuarioRepository.findById(id);
                List<Usuarios> usuario = Collections.singletonList(usuarioFound.get());
                return new ApiResponse(true, "Usuário deletado com sucesso", usuario, null);
            }else{
                return new ApiResponse(false, "Usuário não encontrado no banco", null, null);
            }
        }catch (Exception exception){
            return new ApiResponse(false, "Falha ao deletar usuário", null, null);
        }
    }
}
