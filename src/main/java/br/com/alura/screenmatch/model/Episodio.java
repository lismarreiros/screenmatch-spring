package br.com.alura.screenmatch.model;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Episodio {
    private Integer temporada;
    private String titulo;
    private Integer numeroEpisodio;
    private Double avaliacao;
    private LocalDate dataLancamento;

    public Episodio(Integer numeroTemporada, DadosEpisodio dadosEpisodio) {
        this.temporada = numeroTemporada;
        this.titulo = dadosEpisodio.titulo();
        this.numeroEpisodio = dadosEpisodio.numero();

        try {
            this.avaliacao = Double.valueOf(dadosEpisodio.avaliacao());
        } catch (NumberFormatException ex) {
            this.avaliacao = 0.0;
        }

        try {
            this.dataLancamento = LocalDate.parse(dadosEpisodio.dataDeLancamento());
        } catch (DateTimeException ex) {
            this.dataLancamento = null;
        }

    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Integer getTemporada() {
        return temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "temporada -> " + temporada +
                ", titulo -> '" + titulo + '\'' +
                ", numeroEpisodio -> " + numeroEpisodio +
                ", avaliacao -> " + avaliacao +
                ", dataLancamento -> " + dataLancamento;
    }
}
