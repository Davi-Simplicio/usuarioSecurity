package com.usuario.usuario.model.dto;

import com.usuario.usuario.model.entity.Arquivo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEdicaoDTO {

    Integer id;
    String nome;
    String email;
    String senha;
    Arquivo foto;
    Boolean status;
    Integer idade;
}
