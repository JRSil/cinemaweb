package br.com.cinemajava.webcinema.controllers;

import br.com.cinemajava.webcinema.models.Filme;
import br.com.cinemajava.webcinema.models.Sala;
import br.com.cinemajava.webcinema.models.Sessao;
import br.com.cinemajava.webcinema.repository.FilmeRepository;
import br.com.cinemajava.webcinema.repository.SalaRepository;
import br.com.cinemajava.webcinema.repository.SessaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class FilmeController
{
    @Autowired
    private FilmeRepository fr;

    @Autowired
    private SessaoRepository sr;

    @Autowired
    private SalaRepository sar;

    @RequestMapping(value = "/cadastrarFilme", method = RequestMethod.GET)
    public String formFilme()
    {
        return "filme/formFilme";
    }

    @RequestMapping(value = "/cadastrarFilme", method = RequestMethod.POST)
    public String formFilme(Filme filme)
    {
        fr.save(filme);
        return "redirect:/cadastrarFilme";
    }

    @RequestMapping("/filmes")
    public ModelAndView listaFilmes()
    {
        ModelAndView mv = new ModelAndView("filme/filmes");
        Iterable<Filme> filmes = fr.findAll();
        mv.addObject("filme", filmes);
        return mv;
    }

    @RequestMapping(value = "/filmes/{idFilme}", method = RequestMethod.GET)
    public ModelAndView detalhesFilme(@PathVariable("idFilme") long idFilme)
    {
        Filme filme = fr.findByIdFilme(idFilme);
        ModelAndView mv = new ModelAndView("filme/detalhesFilme");
        mv.addObject("filme", filme);

        Iterable<Sessao> sessoes = sr.findByFilme(filme);
        mv.addObject("sessoes", sessoes);

        Iterable<Sala> salas = sar.findAll();
        mv.addObject("sala", salas);
        return mv;
    }

    @RequestMapping(value = "/filmes/{idFilme}", method = RequestMethod.POST)
    public String detalhesFilmePost(@PathVariable("idFilme") long idFilme, @Valid Sessao sessao, BindingResult result, RedirectAttributes attributes)
    {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/filmes/{idFilme}";
        }
        Filme filme = fr.findByIdFilme(idFilme);
//        Sala sala = sar.findByIdSala(idSala);
        sessao.setFilme(filme);
//        sessao.setSala(sala);
        sr.save(sessao);
        attributes.addFlashAttribute("mensagem", "Sessao adicionada com sucesso!");
        return "redirect:/filmes/{idFilme}";
    }
}
