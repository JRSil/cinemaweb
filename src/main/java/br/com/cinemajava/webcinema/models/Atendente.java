package br.com.cinemajava.webcinema.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Atendente implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAtendente;

    private String nome;
    private String CPF;
    private String nasc;
    private String email;
    private String user;
    private String senha;
    private String tipo;

    public Integer getIdAtendente()
    {
        return idAtendente;
    }

    public void setIdAtendente(Integer idAtendente)
    {
        this.idAtendente = idAtendente;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getCPF()
    {
        return CPF;
    }

    public void setCPF(String CPF)
    {
        this.CPF = CPF;
    }

    public String getNasc()
    {
        return nasc;
    }

    public void setNasc(String nasc)
    {
        this.nasc = nasc;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
}
