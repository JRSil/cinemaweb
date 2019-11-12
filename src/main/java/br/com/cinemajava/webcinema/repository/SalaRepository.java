package br.com.cinemajava.webcinema.repository;

import br.com.cinemajava.webcinema.models.Sala;
import org.springframework.data.repository.CrudRepository;

public interface SalaRepository extends CrudRepository<Sala, String>
{
}
