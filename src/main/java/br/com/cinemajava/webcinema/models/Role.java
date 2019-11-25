package br.com.cinemajava.webcinema.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Role implements GrantedAuthority
{
    @Id
    private String nomeRole;

    @ManyToMany
    private List<Atendente> atendentes;

    public String getNomeRole()
    {
        return nomeRole;
    }

    public void setNomeRole(String nomeRole)
    {
        this.nomeRole = nomeRole;
    }

    @Override
    public String getAuthority()
    {
        return this.nomeRole;
    }
}
