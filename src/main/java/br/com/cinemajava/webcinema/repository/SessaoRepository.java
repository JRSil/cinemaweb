package br.com.cinemajava.webcinema.repository;

import br.com.cinemajava.webcinema.models.Filme;
import br.com.cinemajava.webcinema.models.Sessao;
import org.springframework.data.repository.CrudRepository;

public interface SessaoRepository extends CrudRepository<Sessao, String>
{
    Iterable<Sessao> findByFilme(Filme filme);
}
