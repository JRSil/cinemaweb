package br.com.cinemajava.webcinema.controllers;

import br.com.cinemajava.webcinema.models.Filme;
import br.com.cinemajava.webcinema.models.Sala;
import br.com.cinemajava.webcinema.repository.FilmeRepository;
import br.com.cinemajava.webcinema.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
   @Autowired
   private FilmeRepository fr;

   @Autowired
   private SalaRepository sar;

   @GetMapping(value = "/")
   public ModelAndView index()
   {
      ModelAndView mv = new ModelAndView("home/index");
      Iterable<Filme> filmes = fr.findAll();
      mv.addObject("filme", filmes);

      Iterable<Sala> salas = sar.findAll();
      mv.addObject("sala", salas);

      return mv;
   }
}
