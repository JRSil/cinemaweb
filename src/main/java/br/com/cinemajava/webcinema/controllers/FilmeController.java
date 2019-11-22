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
    public String formFilme(@Valid Filme filme, BindingResult result, RedirectAttributes attributes)
    {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrarFilme";
        }
        fr.save(filme);
        attributes.addFlashAttribute("mensagem", "Filme adicionado com sucesso!");
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

    @RequestMapping("/deletarFilme")
    public String deletarFilme(long idFilme)
    {
        Filme filme = fr.findByIdFilme(idFilme);
        fr.delete(filme);
        return "redirect:/filmes";
    }

    @RequestMapping(value = "/filmes/{idFilme}", method = RequestMethod.POST)
    public String detalhesFilmePost(@PathVariable("idFilme") long idFilme, @Valid Sessao sessao, BindingResult result, RedirectAttributes attributes)
    {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            System.err.println("idFilme = " + idFilme + ", sessao = " + sessao.getCodS() + ", result = " + result + ", attributes = " + attributes);
            return "redirect:/filmes/{idFilme}";
        }
        System.err.println("idFilme = " + idFilme + ", sessao = " + sessao.getCodS() + ", result = " + result + ", attributes = " + attributes);
        Filme filme = fr.findByIdFilme(idFilme);
        Sala sala = sar.findByIdSala(sessao.getCodS());
        sessao.setFilme(filme);
        sessao.setSala(sala);
        sr.save(sessao);
        attributes.addFlashAttribute("mensagem", "Sessao adicionada com sucesso!");
        return "redirect:/filmes/{idFilme}";
    }

    @RequestMapping("/deletarSessao")
    public String deletarSessao(long idSessao)
    {
        Sessao sessao = sr.findByIdSessao(idSessao);
        sr.delete(sessao);

        Filme filme = sessao.getFilme();
        long idFilmeLong = filme.getIdFilme();
        String idFilme = "" + idFilmeLong;
        return "redirect:/filmes/" + idFilme;
    }
}
