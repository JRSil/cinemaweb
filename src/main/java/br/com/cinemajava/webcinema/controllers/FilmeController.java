package br.com.cinemajava.webcinema.controllers;

import br.com.cinemajava.webcinema.models.Filme;
import br.com.cinemajava.webcinema.repository.FilmeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FilmeController
{
    @Autowired
    private FilmeRepository fr;

    @RequestMapping(value = "/cadastrarFilme", method = RequestMethod.GET)
    public String form()
    {
        return "filme/formFilme";
    }

    @RequestMapping(value = "/cadastrarFilme", method = RequestMethod.POST)
    public String form(Filme filme)
    {
        fr.save(filme);
        return "redirect:/cadastrarFilme";
    }

    @RequestMapping("/filmes")
    public ModelAndView listaFilmes()
    {
        ModelAndView mv = new ModelAndView("home/index");
        Iterable<Filme> filmes = fr.findAll();
        mv.addObject("filme", filmes);
        return mv;
    }

    @RequestMapping("/{idFilme}")
    public ModelAndView detalhesFilme(@PathVariable("idFilme") long idFilme)
    {
        Filme filme = fr.findByIdFilme(idFilme);
        ModelAndView mv = new ModelAndView("filme/detalhesFilme");
        mv.addObject("filme", filme);
        System.out.println("filme" + filme);
        return mv;
    }
}
