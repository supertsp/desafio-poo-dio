package br.tiagopedroso.dominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ItemGrade {

    private String titulo;
    private String descricao;
    private boolean concluido;

}
