package Models;

import calculations.Classifiable;

public class Movie extends Title implements Classifiable {
    private String diretor;

    public Movie(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassifiable() {
        return (int) pegaMedia() / 2;
    }

    @Override
    public String toString() {
        return "Movie: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
    }
}
