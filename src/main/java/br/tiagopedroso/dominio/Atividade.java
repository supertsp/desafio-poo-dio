package br.tiagopedroso.dominio;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class Atividade extends ItemGrade implements XpCalculavel {

    private LocalDateTime criadoEm = LocalDateTime.now();

}
