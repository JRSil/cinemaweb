package br.com.cinemajava.webcinema.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Sessao implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idSessao;

    private Integer idSala;
    private String dia;
    private String hora;
    private boolean dublagem;

    @ManyToOne
    private Filme filme;

    @ManyToOne
    private Sala sala;

    public Integer getIdSessao()
    {
        return idSessao;
    }

    public void setIdSessao(Integer idSessao)
    {
        this.idSessao = idSessao;
    }

    public Integer getIdSala()
    {
        return idSala;
    }

    public void setIdSala(Integer idSala)
    {
        this.idSala = idSala;
    }

    public String getDia()
    {
        return dia;
    }

    public void setDia(String dia)
    {
        this.dia = dia;
    }

    public String getHora()
    {
        return hora;
    }

    public void setHora(String hora)
    {
        this.hora = hora;
    }

    public boolean isDublagem()
    {
        return dublagem;
    }

    public void setDublagem(boolean dublagem)
    {
        this.dublagem = dublagem;
    }

    public Filme getFilme()
    {
        return filme;
    }

    public void setFilme(Filme filme)
    {
        this.filme = filme;
    }

    public Sala getSala()
    {
        return sala;
    }

    public void setSala(Sala sala)
    {
        this.sala = sala;
    }
}
