package br.com.cinemajava.webcinema.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Sala implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idSala;

    private String tipoImagem;
    private int qtdMax;

    public Integer getIdSala()
    {
        return idSala;
    }

    public void setIdSala(Integer idSala)
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
}
