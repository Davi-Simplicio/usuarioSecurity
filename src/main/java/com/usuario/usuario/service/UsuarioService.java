package com.usuario.usuario.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usuario.usuario.model.dto.UsuarioCadastroDTO;
import com.usuario.usuario.model.dto.UsuarioEdicaoDTO;
import com.usuario.usuario.model.entity.Arquivo;
import com.usuario.usuario.model.entity.Usuario;
import com.usuario.usuario.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;

    public Usuario buscarUm(Integer id){
        return usuarioRepository.findById(id).get();
    }
    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }
    public void cadastrar(UsuarioCadastroDTO usuarioCadastroDTO){
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDTO,usuario);
        usuarioRepository.save(usuario);
    }
    public void editar(UsuarioEdicaoDTO usuarioEdicaoDTO){
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioEdicaoDTO,usuario);
        usuarioRepository.save(usuario);
    }
    public void deletar(Integer id){
        usuarioRepository.deleteById(id);
    }
    public void editarSenha(UsuarioEdicaoDTO usuarioEdicaoDTO,String senha) throws Exception {
        Usuario usuario = new Usuario();
        try{
            usuario = usuarioRepository.findById(usuarioEdicaoDTO.getId()).get();
            modelMapper.map(usuarioEdicaoDTO,usuario);
            usuario.setSenha(senha);
            usuarioRepository.save(usuario);
        } catch (Exception e){
            throw new Exception("Não foi possivel atualizar sua senha");
        }
    }
    public void editarStatus(UsuarioEdicaoDTO usuarioEdicaoDTO,Boolean status) throws Exception {
        Usuario usuario = new Usuario();
        try{
            usuario = usuarioRepository.findById(usuarioEdicaoDTO.getId()).get();
            modelMapper.map(usuarioEdicaoDTO,usuario);
            usuario.setStatus(status);
            usuarioRepository.save(usuario);
        } catch (Exception e){
            throw new Exception("Não foi possivel atualizar seu status");
        }
    }
    public void editarFoto(UsuarioEdicaoDTO usuarioEdicaoDTO, Arquivo imagem) throws Exception {
        Usuario usuario = new Usuario();
        try{
            usuario = usuarioRepository.findById(usuarioEdicaoDTO.getId()).get();
            modelMapper.map(usuarioEdicaoDTO,usuario);
            usuario.setFoto(imagem);
            usuarioRepository.save(usuario);
        } catch (Exception e){
            throw new Exception("Não foi possivel atualizar sua foto");
        }
    }
}
