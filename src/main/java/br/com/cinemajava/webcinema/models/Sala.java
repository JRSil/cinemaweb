package br.com.cinemajava.webcinema.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Sala implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idSala;

    private String tipoImagem;
    private int qtdMax;

    @OneToMany
    private List<Sessao> sessao;

    public long getIdSala()
    {
        return idSala;
    }

    public void setIdSala(long idSala)
    {
        this.idSala = idSala;
    }

    public String getTipoImagem()
    {
        return tipoImagem;
    }

    public void setTipoImagem(String tipoImagem)
    {
        this.tipoImagem = tipoImagem;
    }

    public int getQtdMax()
    {
        return qtdMax;
    }

    public void setQtdMax(int qtdMax)
    {
        this.qtdMax = qtdMax;
    }

    public List<Sessao> getSessao()
    {
        return sessao;
    }

    public void setSessao(List<Sessao> sessao)
    {
        this.sessao = sessao;
    }
}
