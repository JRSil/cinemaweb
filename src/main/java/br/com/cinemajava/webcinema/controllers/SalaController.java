package br.com.cinemajava.webcinema.controllers;

import br.com.cinemajava.webcinema.models.Sala;
import br.com.cinemajava.webcinema.models.Sessao;
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
    public String formSala(@Valid Sala sala, BindingResult result, RedirectAttributes attributes)
    {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrarSala";
        }
        sar.save(sala);
        attributes.addFlashAttribute("mensagem", "Sala adicionada com sucesso!");
        return "redirect:/cadastrarSala";
    }

    @RequestMapping("/salas")
    public ModelAndView listaSalas()
    {
        ModelAndView mv = new ModelAndView("sala/salas");
        Iterable<Sala> salas = sar.findAll();
        mv.addObject("sala", salas);
        return mv;
    }

    @RequestMapping(value = "/salas/{idSala}", method = RequestMethod.GET)
    public ModelAndView detalhesSala(@PathVariable("idSala") long idSala)
    {
        Sala sala = sar.findByIdSala(idSala);
        ModelAndView mv = new ModelAndView("sala/detalhesSala");
        mv.addObject("sala", sala);

        Iterable<Sessao> sessoes = sr.findBySala(sala);
        mv.addObject("sessoes", sessoes);
        return mv;
    }
}
