package Model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private String nome;
    private List<Double> notas = new ArrayList<Double>();

    public Aluno() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(@NotNull String nome) {
        if (nome.length() == 0  || nome.length()> 100){
            throw new RuntimeException("Nome inválido!");
        } else {
            this.nome = nome;
        }
    }

    public void entraNota(Double nota) {
        if(nota < 0.0 || nota > 30.0) {
            throw new RuntimeException("Nota inválida");
        } else {
            notas.add(nota);
        }
    }

    public double retornaNotaTotal() {
        Double soma = 0.0;
        for (Double nota : notas) {
            soma += nota;
        }
        if(soma > 100) {
            throw new RuntimeException("Nota ultrapassou 100 pontos!");
        } else {
            return soma;
        }
    }
}