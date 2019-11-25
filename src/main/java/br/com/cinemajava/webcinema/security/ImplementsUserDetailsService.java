package br.com.cinemajava.webcinema.security;

import br.com.cinemajava.webcinema.models.Atendente;
import br.com.cinemajava.webcinema.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService
{
    @Autowired
    private AtendenteRepository ar;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException
    {
        Atendente atendente = ar.findByUser(user);

        if (atendente == null) {
            throw new UsernameNotFoundException("Usuario nao encontrado!");
        }
        return new User(atendente.getUsername(), atendente.getPassword(), true, true, true, true, atendente.getAuthorities());
    }
}
