package br.com.cinemajava.webcinema.models;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Atendente implements UserDetails
{
    @Id
    @NotEmpty
    private String user;

    @NotEmpty
    private String senha;

    @NotEmpty
    private String nome;
    @NotEmpty
    private String CPF;
    @NotEmpty
    private String nasc;
    @NotEmpty
    private String email;

    @ManyToMany
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(
            name = "atendente_id", referencedColumnName = "user"),
            inverseJoinColumns = @JoinColumn(
            name = "role_id", referencedColumnName = "nomeRole")
    )
    private List<Role> roles;

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

    public List<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(List<Role> roles)
    {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.user;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
