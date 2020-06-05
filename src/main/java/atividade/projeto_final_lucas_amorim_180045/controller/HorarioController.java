package atividade.projeto_final_lucas_amorim_180045.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import atividade.projeto_final_lucas_amorim_180045.entity.Horario;
import atividade.projeto_final_lucas_amorim_180045.service.HorarioService;

@Controller
public class HorarioController {
    @Autowired
    private HorarioService hs;

    @GetMapping("/horario")
    public ModelAndView horarioView(){
        ModelAndView mv = new ModelAndView ("HorarioView");
        
        mv.addObject("horario", new Horario());
        mv.addObject("horarios", hs.getHorarios());

        return mv;
    } 

    @PostMapping("/salvarhorario")
    public String save(@ModelAttribute Horario horario){
        hs.salvar(horario);

        return "redirect:/horario";
    }
}