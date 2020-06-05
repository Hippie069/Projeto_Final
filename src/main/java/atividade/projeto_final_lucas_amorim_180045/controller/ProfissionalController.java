package atividade.projeto_final_lucas_amorim_180045.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import atividade.projeto_final_lucas_amorim_180045.entity.Profissional;
import atividade.projeto_final_lucas_amorim_180045.service.ProfissionalService;

@Controller
public class ProfissionalController {
    @Autowired
    private ProfissionalService ps;

    @GetMapping("/profissional")
    public ModelAndView profissionalView(){
        ModelAndView mv = new ModelAndView ("ProfissinalView");
        
        mv.addObject("profissional", new Profissional());
        mv.addObject("Profissionais", ps.getProfissionais());

        return mv;
    } 

    @PostMapping("/salvarprofissional")
    public String save(@ModelAttribute Profissional profissional){
        ps.salvar(profissional);

        return "redirect:/profissional";
    }
}