package br.com.cinemajava.webcinema.controllers;

import br.com.cinemajava.webcinema.models.Sala;
import br.com.cinemajava.webcinema.repository.SalaRepository;
import br.com.cinemajava.webcinema.repository.SessaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SalaController
{
    @Autowired
    private SalaRepository sar;

    @Autowired
    private SessaoRepository sr;

    @RequestMapping(value = "/cadastrarSala", method = RequestMethod.GET)
    public String formSala()
    {
        return "sala/formSala";
    }

    @RequestMapping(value = "/cadastrarSala", method = RequestMethod.POST)
    public String formSala(Sala sala)
    {
        sar.save(sala);
        return "redirect:/cadastrarSala";
    }

    @RequestMapping("/salas")
    public ModelAndView listaSalas()
    {
        ModelAndView mv = new ModelAndView("home/index");
        Iterable<Sala> salas = sar.findAll();
        mv.addObject("sala", salas);
        return mv;
    }

    @RequestMapping(value = "/{idSala}", method = RequestMethod.GET)
    public ModelAndView detalhesSala(@PathVariable("idSala") long idSala)
    {
        Sala sala = sar.findByIdSala(idSala);
        ModelAndView mv = new ModelAndView("sala/detalhesSala");
        mv.addObject("sala", sala);
        return mv;
    }
}
