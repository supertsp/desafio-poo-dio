package br.tiagopedroso.dominio;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
public class Bootcamp extends ItemGrade {
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Atividade> atividades = new LinkedHashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(
                getTitulo(),
                getDescricao(),
                getDataInicial(),
                getDataFinal(),
                getDevsInscritos(),
                getAtividades()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bootcamp bootcamp)) return false;

        return Objects.equals(getTitulo(), bootcamp.getTitulo()) &&
                Objects.equals(getDescricao(), bootcamp.getDescricao()) &&
                Objects.equals(getDataInicial(), bootcamp.getDataInicial()) &&
                Objects.equals(getDataFinal(), bootcamp.getDataFinal());
    }

    @Override
    public String toString() {
        return "Bootcamp{ " +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", dataInicial='" + getDataInicial() + '\'' +
                ", dataFinal=" + getDataFinal() +
                ", totalInscritos=" + devsInscritos.size() +
                ", totalAtividades=" + atividades.size() +
                " }";
    }

}
