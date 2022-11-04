package br.tiagopedroso;

import br.tiagopedroso.dominio.Bootcamp;
import br.tiagopedroso.dominio.Dev;
import br.tiagopedroso.dominio.Materia;
import br.tiagopedroso.dominio.Mentoria;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Materia materia1 = new Materia();
        materia1.setTitulo("Introdução à Plataforma Java");
        materia1.setDescricao("Conhecimentos básicos da linguagem Java");
        materia1.setCargaHoraria(8);
        System.out.println("\n" + materia1);

        Materia materia2 = new Materia();
        materia2.setTitulo("Ambiente de Desenvolvimento Java");
        materia2.setDescricao("Conhecendo as IDEs mais utilizadas no mercado para se trabalhar com Java");
        materia2.setCargaHoraria(4);
        System.out.println("\n" + materia2);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Cloud Fullstack Bootcamp - Warburg Pincus | Aula Inaugural");
        mentoria.setDescricao("Apresentação do Bootcamp e da empresa Warburg");
        mentoria.setDataLiberacao(LocalDateTime.parse("2023-01-01T00:00:00"));
        mentoria.setUrl("https://www.youtube.com/watch?v=e2hHdjOF3jk");
        System.out.println("\n" + mentoria);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setTitulo("Cloud Fullstack Bootcamp - Warburg Pincus");
        bootcamp.setDescricao("Bootcamp focado em Java, SpringBoot e Angular");
        bootcamp.getAtividades().add(materia1);
        bootcamp.getAtividades().add(materia2);
        bootcamp.getAtividades().add(mentoria);
        System.out.println("\n" + bootcamp);

        System.out.println("\n---------------------\n");

        Dev dev1 = new Dev("Tiago");
        dev1.inscreverBootcamp(bootcamp);
        System.out.println("\n" + dev1);

        dev1.progredir();
        dev1.progredir();

        System.out.println("Conteúdos Inscritos:");
        dev1.getAtividadesInscritas().forEach(System.out::println);
        System.out.println("\nConteúdos Concluídos:");
        dev1.getAtividadesConcluidas().forEach(System.out::println);
        System.out.println("\n" + dev1);

        System.out.println("\n---------------------\n");

        Dev dev2 = new Dev();
        dev2.setNome("Pedroso");
        dev2.inscreverBootcamp(bootcamp);
        System.out.println("\n" + dev2);

        System.out.println("Conteúdos Inscritos:");
        dev2.getAtividadesInscritas().forEach(System.out::println);
        System.out.println("\nConteúdos Concluídos:");
        dev2.getAtividadesConcluidas().forEach(System.out::println);
        System.out.println("\n" + dev2);

        dev2.progredir();
        dev2.progredir();
        dev2.progredir();

        System.out.println("Conteúdos Inscritos:");
        dev2.getAtividadesInscritas().forEach(System.out::println);
        System.out.println("\nConteúdos Concluídos:");
        dev2.getAtividadesConcluidas().forEach(System.out::println);
        System.out.println("\n" + dev2);
    }

}
