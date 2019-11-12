package br.com.cinemajava.webcinema.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Filme implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idFilme;

    private String nomeFilme;
    private Integer classificacao;
    private float duracao;
    private boolean cartaz;
    private String vigencia;
    private String categoria;

    @OneToMany
    private List<Sessao> sessao;

    public long getIdFilme()
    {
        return idFilme;
    }

    public void setIdFilme(long idFilme)
    {
        this.idFilme = idFilme;
    }

    public String getNomeFilme()
    {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme)
    {
        this.nomeFilme = nomeFilme;
    }

    public Integer getClassificacao()
    {
        return classificacao;
    }

    public void setClassificacao(Integer classificacao)
    {
        this.classificacao = classificacao;
    }

    public float getDuracao()
    {
        return duracao;
    }

    public void setDuracao(float duracao)
    {
        this.duracao = duracao;
    }

    public boolean isCartaz()
    {
        return cartaz;
    }

    public void setCartaz(boolean cartaz)
    {
        this.cartaz = cartaz;
    }

    public String getVigencia()
    {
        return vigencia;
    }

    public void setVigencia(String vigencia)
    {
        this.vigencia = vigencia;
    }

    public String getCategoria()
    {
        return categoria;
    }

    public void setCategoria(String categoria)
    {
        this.categoria = categoria;
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
