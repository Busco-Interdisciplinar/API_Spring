package com.example.api_busco.Services;

import com.example.api_busco.Models.ApiResponse;
import com.example.api_busco.Models.Doacao;
import com.example.api_busco.Models.Usuarios;
import com.example.api_busco.Repositorys.DoacaoRepository;
import com.example.api_busco.Repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoacaoService {
    private final DoacaoRepository doacaoRepository;
    private final UsuarioRepository usuarioRepository;


    @Autowired
    public DoacaoService(DoacaoRepository doacaoRepository, UsuarioRepository usuarioRepository) {
        this.doacaoRepository = doacaoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public ApiResponse fazerDoacao(Doacao doacao) {
        try {
            Doacao doacaoFeita = doacaoRepository.save(doacao);
            List<Object> doacaoList = new ArrayList<>();
            doacaoList.add(doacaoFeita);
            int usuarioDoadorId = doacaoFeita.getUsuario_doador();
            Optional<Usuarios> usuarioDoacao = usuarioRepository.findById(usuarioDoadorId);
            if(usuarioDoacao.isPresent()){
                Usuarios usuario = usuarioDoacao.get();
                int doacoesUsuario = usuario.getQnt_doacao();
                usuario.setQnt_doacao(doacoesUsuario + 1);
                usuarioRepository.save(usuario);
            }
            return new ApiResponse(true, "Doação feita com sucesso", doacaoList, null);
        } catch (Exception exception) {
            return new ApiResponse(false, "Falha ao fazer doação", null, null);
        }
    }

    public ApiResponse findByUserId(int id) {
        try {
            Doacao doacao = doacaoRepository.findDoacaoByUsuario_doador(id);
            if (doacao != null){
                List<Object> doacaoList = new ArrayList<>();
                doacaoList.add(doacao);
                return new ApiResponse(true, "Doação encontrada com sucesso", doacaoList, null);
            }else{
                return new ApiResponse(false, "Doação não encontrada no banco", null, null);
            }
        }catch (Exception exception){
            return new ApiResponse(false, "Falha ao buscar doação", null, null);
        }
    }
}