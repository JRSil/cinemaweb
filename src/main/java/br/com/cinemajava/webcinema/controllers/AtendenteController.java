package br.com.cinemajava.webcinema.controllers;

import br.com.cinemajava.webcinema.models.Atendente;
import br.com.cinemajava.webcinema.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AtendenteController
{
    @Autowired
    private AtendenteRepository ar;

    @RequestMapping(value = "/cadastrarAtendente", method = RequestMethod.GET)
    public String formAtendente()
    {
        return "atendente/formAtendente";
    }

    @RequestMapping(value = "/cadastrarAtendente", method = RequestMethod.POST)
    public String formAtendente(@Valid Atendente atendente, BindingResult result, RedirectAttributes attributes)
    {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrarAtendente";
        }
        ar.save(atendente);
        attributes.addFlashAttribute("mensagem", "Filme adicionado com sucesso!");
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
