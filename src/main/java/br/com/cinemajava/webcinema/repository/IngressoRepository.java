package br.com.cinemajava.webcinema.repository;

import br.com.cinemajava.webcinema.models.Ingresso;
import org.springframework.data.repository.CrudRepository;

public interface IngressoRepository extends CrudRepository<Ingresso, String>
{
}
