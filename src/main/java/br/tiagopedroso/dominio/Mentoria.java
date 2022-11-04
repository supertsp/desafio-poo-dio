package br.tiagopedroso.dominio;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class Mentoria extends Atividade implements XpCalculavel {

    private LocalDateTime dataLiberacao;
    private String url;

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitulo(), getDescricao(), getDataLiberacao(), getUrl());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mentoria mentoria)) return false;

        return Objects.equals(getTitulo(), mentoria.getTitulo()) &&
                Objects.equals(getDescricao(), mentoria.getDescricao()) &&
                Objects.equals(getDataLiberacao(), mentoria.getDataLiberacao()) &&
                Objects.equals(getUrl(), mentoria.getUrl());
    }

    @Override
    public String toString() {
        return "Mentoria{ " +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", criadoEm='" + getCriadoEm() + '\'' +
                ", dataLiberacao=" + getDataLiberacao() +
                ", url=" + getUrl() +
                ", concluido=" + isConcluido() +
                ", xp=" + calcularXp() +
                " }";
    }

}
