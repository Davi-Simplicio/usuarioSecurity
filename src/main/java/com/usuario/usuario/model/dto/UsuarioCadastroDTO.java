package com.usuario.usuario.model.dto;

import com.usuario.usuario.model.entity.Arquivo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCadastroDTO {

    String nome;
    String email;
    String senha;
    Arquivo foto;
    Boolean status;
    Integer idade;

    public void setFoto(MultipartFile foto) throws IOException {
            Arquivo a = new Arquivo();
            a.setDados((foto.getBytes()));
            a.setNome(foto.getOriginalFilename());
            a.setTipo((foto.getContentType()));
            this.foto = a;
    }
}
