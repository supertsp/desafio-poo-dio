package br.tiagopedroso.dominio;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Materia extends Atividade {

    private int cargaHoraria;

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitulo(), getDescricao(), getCargaHoraria());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Materia materia)) return false;

        return Objects.equals(getTitulo(), materia.getTitulo()) &&
                Objects.equals(getDescricao(), materia.getDescricao()) &&
                getCargaHoraria() == materia.getCargaHoraria();
    }

    @Override
    public String toString() {
        return "Materia{ " +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", criadoEm='" + getCriadoEm() + '\'' +
                ", cargaHoraria=" + getCargaHoraria() + "h" +
                ", concluido=" + isConcluido() +
                ", xp=" + calcularXp() +
                " } ";
    }
}
