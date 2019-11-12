package br.com.cinemajava.webcinema.repository;

import br.com.cinemajava.webcinema.models.Filme;
import org.springframework.data.repository.CrudRepository;

public interface FilmeRepository extends CrudRepository<Filme, String>
{
    Filme findByIdFilme(long idFilme);
}
