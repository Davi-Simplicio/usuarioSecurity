package com.usuario.usuario.controller;

import com.usuario.usuario.model.dto.UsuarioCadastroDTO;
import com.usuario.usuario.model.dto.UsuarioEdicaoDTO;
import com.usuario.usuario.model.entity.Arquivo;
import com.usuario.usuario.model.entity.Usuario;
import com.usuario.usuario.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUm(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(
                    usuarioService.buscarUm(id), HttpStatus.OK
            );
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping()
    public ResponseEntity<Collection<Usuario>> buscarUm(){
            return new ResponseEntity<>(
                    usuarioService.buscarTodos(), HttpStatus.OK
            );
    }
    @DeleteMapping
    public void deletar(@PathVariable Integer id){
        usuarioService.deletar(id);
    }
    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody UsuarioCadastroDTO usuarioCadastroDTO){
        try {
            usuarioService.cadastrar(usuarioCadastroDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    @PutMapping
    public ResponseEntity<Usuario> editar(@RequestBody UsuarioEdicaoDTO usuarioEdicaoDTO){
        try {
            usuarioService.editar(usuarioEdicaoDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }  catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PatchMapping
    public ResponseEntity<Usuario> atualizarSenha(@RequestBody UsuarioEdicaoDTO usuarioEdicaoDTO, @RequestParam String senha){
        try {
            usuarioService.editarSenha(usuarioEdicaoDTO,senha);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PatchMapping
    public ResponseEntity<Usuario> atualizarStatus(@RequestBody UsuarioEdicaoDTO usuarioEdicaoDTO, @RequestParam Boolean status){
        try {
            usuarioService.editarStatus(usuarioEdicaoDTO,status);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PatchMapping
    public ResponseEntity<Usuario> atualizarFoto(@RequestBody UsuarioEdicaoDTO usuarioEdicaoDTO, @RequestParam Arquivo foto){
        try {
            usuarioService.editarFoto(usuarioEdicaoDTO,foto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
