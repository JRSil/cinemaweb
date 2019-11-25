package br.com.cinemajava.webcinema.repository;

import br.com.cinemajava.webcinema.models.Atendente;
import org.springframework.data.repository.CrudRepository;

public interface AtendenteRepository extends CrudRepository<Atendente, String>
{
    Atendente findByUser(String user);
}
