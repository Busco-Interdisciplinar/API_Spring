package com.example.api_busco.Services;

import com.example.api_busco.Models.ApiResponse;
import com.example.api_busco.Models.Usuarios;
import com.example.api_busco.Repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
            List<Object> listaObjetos = usuarios.stream()
                    .map(usuario -> (Object) usuario)
                    .toList();
            return new ApiResponse(true, "Usuários retornados com sucesso", listaObjetos, null);
        }catch (Exception exception){
            return new ApiResponse(false, "Falha ao retornar usuários", null, null);
        }
    }

    public ApiResponse cadastrarUsuario(Usuarios usuario){
        try {
            Usuarios usuarioResponse = usuarioRepository.save(usuario);
            List<Object> usuariosList = new ArrayList<>();
            usuariosList.add(usuarioResponse);
            return new ApiResponse(true, "Usuário inserido com sucesso", usuariosList, null);
        }catch (Exception exception){
            return new ApiResponse(false, "Usuário já existe no banco", null, null);
        }
    }

    public ApiResponse login(String email, String senha){
        try{
            Usuarios usuario = usuarioRepository.findByEmail(email);
            List<Object> usuarioList = new ArrayList<>();
            usuarioList.add(usuario);
            if (usuario != null && usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)){
                return new ApiResponse(true, "Usuário logado com sucesso", usuarioList, null);
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
                Usuarios usuario = usuarioFound.get();
                List<Object> usuarioList = new ArrayList<>();
                usuarioList.add(usuario);
                return new ApiResponse(true, "Usuário deletado com sucesso", usuarioList, null);
            }else{
                return new ApiResponse(false, "Usuário não encontrado no banco", null, null);
            }
        }catch (Exception exception){
            return new ApiResponse(false, "Falha ao deletar usuário", null, null);
        }
    }

    public ApiResponse findByEmail(String email) {
        try {
            Usuarios usuarioFound = usuarioRepository.findByEmail(email);
            if (usuarioFound != null){
                List<Object> usuarioList = new ArrayList<>();
                usuarioList.add(usuarioFound);
                return new ApiResponse(true, "Usuário encontrado com sucesso", usuarioList, null);
            }else{
                return new ApiResponse(false, "Usuário não encontrado no banco", null, null);
            }
        }catch (Exception exception){
            return new ApiResponse(false, "Falha ao buscar usuário", null, null);
        }
    }

    public ApiResponse findByCpfOrEmailOrTelefone(String cpf, String email, String telefone) {
        try {
            List<Usuarios> usuariosFound = usuarioRepository.findByCpfOrEmailOrTelefone(cpf, email, telefone);
            List<Object> listaObjetos = usuariosFound.stream()
                    .map(usuario -> (Object) usuario)
                    .toList();
            if (usuariosFound.size() != 0){
                boolean cpfExiste = false;
                boolean emailExiste = false;
                boolean telefoneExiste = false;
                for (Usuarios usuario: usuariosFound
                     ) {
                    if (usuario.getCpf().equals(cpf)){
                        cpfExiste = true;
                    }
                    if (usuario.getEmail().equals(email)){
                        emailExiste = true;
                    }
                    if (usuario.getTelefone().equals(telefone)){
                        telefoneExiste = true;
                    }
                }
                String camposExistentes = "{" +
                        "cpf:" + cpfExiste + "," +
                        "email:'" + emailExiste + "," +
                        "telefone:"+ telefoneExiste +
                        "}";
                return new ApiResponse(true, "Alguma informação recebida foi encontrada no banco", listaObjetos, camposExistentes);
            }else{
                return new ApiResponse(false, "Usuário não existe no banco", null, null);
            }
        }catch (Exception exception){
            return new ApiResponse(false, "Falha ao buscar informações", null, null);
        }
    }

    public ApiResponse resetSenha(String email, String novaSenha){
        try {
            Usuarios usuarioFound = usuarioRepository.findByEmail(email);
            if (usuarioFound != null){
                usuarioFound.setSenha(novaSenha);
                Usuarios usuarioAlterado = usuarioRepository.save(usuarioFound);
                List<Object> usuarioList = new ArrayList<>();
                usuarioList.add(usuarioAlterado);
                return new ApiResponse(true, "Senha alterada com sucesso", usuarioList, null);
            }else{
                return new ApiResponse(false, "Usuário não encontrado no banco", null, null);
            }
        }catch (Exception exception){
            return new ApiResponse(false, "Falha ao buscar usuário", null, null);
        }
    }
}

