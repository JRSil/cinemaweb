package br.com.cinemajava.webcinema.models;

import org.hibernate.validator.constraints.NotEmpty;

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
    private long idAtendente;

    @NotEmpty
    private String nome;
    @NotEmpty
    private String CPF;
    @NotEmpty
    private String nasc;
    @NotEmpty
    private String email;
    @NotEmpty
    private String user;
    @NotEmpty
    private String senha;
    @NotEmpty
    private String tipo;

    public long getIdAtendente()
    {
        return idAtendente;
    }

    public void setIdAtendente(long idAtendente)
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
