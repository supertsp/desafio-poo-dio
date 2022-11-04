package br.tiagopedroso.dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class Dev {
    private String nome;
    private Set<Atividade> atividadesInscritas = new LinkedHashSet<>();
    private Set<Atividade> atividadesConcluidas = new LinkedHashSet<>();

    private Set<Bootcamp> bootcampsIncritos = new LinkedHashSet<>();

    public Dev(String nome) {
        this.nome = nome;
    }

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.bootcampsIncritos.add(bootcamp);
        this.atividadesInscritas.addAll(bootcamp.getAtividades());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Atividade> atividade = this.atividadesInscritas.stream().findFirst();
        if (atividade.isPresent()) {
            atividade.get().setConcluido(true);
            this.atividadesConcluidas.add(atividade.get());
            this.atividadesInscritas.remove(atividade.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        return this.atividadesConcluidas
                .stream()
                .mapToDouble(Atividade::calcularXp)
                .sum();
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, atividadesInscritas, atividadesConcluidas);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dev dev)) return false;

        return Objects.equals(nome, dev.nome) &&
                calcularTotalXp() == dev.calcularTotalXp();
    }

    @Override
    public String toString() {
        return "Dev{ " +
                "nome='" + getNome() + '\'' +
                ", totalXp='" + calcularTotalXp() +
                ", totalAtividadesInscritas=" + atividadesInscritas.size() +
                ", totalAtividadesConcluidas=" + atividadesConcluidas.size() +
                ", totalBootcampsInscritos=" + bootcampsIncritos.size() +
                " }";
    }


}
