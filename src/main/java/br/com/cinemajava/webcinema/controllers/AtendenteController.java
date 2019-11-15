package br.com.cinemajava.webcinema.controllers;

import br.com.cinemajava.webcinema.models.Atendente;
import br.com.cinemajava.webcinema.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/atendentes")
    public ModelAndView listaAtendentes()
    {
        ModelAndView mv = new ModelAndView("atendente/atendentes");
        Iterable<Atendente> atendentes = ar.findAll();
        mv.addObject("atendente", atendentes);
        return mv;
    }
}
