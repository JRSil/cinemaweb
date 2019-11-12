package br.com.cinemajava.webcinema.controllers;

import br.com.cinemajava.webcinema.models.Atendente;
import br.com.cinemajava.webcinema.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class AtendenteController
{
    @Autowired
    private AtendenteRepository ar;

    @RequestMapping(value = "/cadastrarAtendente", method = RequestMethod.GET)
    public String form()
    {
        return "atendente/formAtendente";
    }

    @RequestMapping(value = "/cadastrarAtendente", method = RequestMethod.POST)
    public String form(Atendente atendente)
    {
        ar.save(atendente);
        return "redirect:/cadastrarAtendente";
    }
}
