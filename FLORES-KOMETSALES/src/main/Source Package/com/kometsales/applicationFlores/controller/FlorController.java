package com.kometsales.applicationFlores.controller;

import com.kometsales.applicationFlores.Service.FloresServiceImpl;
import com.kometsales.applicationFlores.model.Flor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlorController {

	@Autowired
    private FloresServiceImpl floresServiceImpl;
    
    @GetMapping("/")
    public ModelAndView viewHomePage(Model model) {
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("floreslist", floresServiceImpl.getAllFlowers());
        return modelAndView;
    }
    
    @GetMapping("/flowersPrice")
    public ModelAndView viewHomePage2(Model model) {
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("floresPrice");
        modelAndView.addObject("floreslist", floresServiceImpl.getFlowersPrice());
        return modelAndView;
    }
    
    @GetMapping("/borrarFlor/{id}")
    public ModelAndView deleteThroughId(@PathVariable(value = "id") long id) {
    	ModelAndView modelAndView =  new ModelAndView("redirect:/");
    	floresServiceImpl.deleteViaId(id);
        return modelAndView;
    }
    
    @GetMapping("/buscarFlor")
    public ModelAndView buscarFlor() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("flor", new Flor());
        modelAndView.setViewName("searchFlower");
        return modelAndView;
    }

    @GetMapping("/resultadoBusqueda")
    public ModelAndView buscarResultado(@ModelAttribute("flor") Flor flor) {
        ModelAndView modelAndView = new ModelAndView();
        List<Flor> floresEncontradas = floresServiceImpl.getFlowersSearch(flor.getNombre());
        modelAndView.addObject("floresList", floresEncontradas);
        modelAndView.setViewName("mostrarFlores");
        return modelAndView;
    }
}
