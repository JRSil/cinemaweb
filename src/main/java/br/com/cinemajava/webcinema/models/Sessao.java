package br.com.cinemajava.webcinema.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Sessao implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idSessao;

    @NotEmpty
    private String dia;
    @NotEmpty
    private String hora;

    private boolean dublagem;

    @ManyToOne
    private Filme filme;

    @ManyToOne
    private Sala sala;

    private int codS;

    public long getIdSessao()
    {
        return idSessao;
    }

    public void setIdSessao(long idSessao)
    {
        this.idSessao = idSessao;
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

    public int getCodS()
    {
        return codS;
    }

    public void setCodS(int codS)
    {
        this.codS = codS;
    }
}
