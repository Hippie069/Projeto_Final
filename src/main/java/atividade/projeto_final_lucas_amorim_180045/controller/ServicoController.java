package atividade.projeto_final_lucas_amorim_180045.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import atividade.projeto_final_lucas_amorim_180045.entity.Servico;
import atividade.projeto_final_lucas_amorim_180045.service.ServicoService;

@Controller
public class ServicoController {
    @Autowired
    private ServicoService ss;

    @GetMapping("/servico")
    public ModelAndView servicoView(){
        ModelAndView mv = new ModelAndView ("ServicoView");
        
        mv.addObject("servico", new Servico());
        mv.addObject("servicos", ss.getServicos());

        return mv;
    } 

    @PostMapping("/salvarservico")
    public String save(@ModelAttribute Servico servico){
        ss.salvar(servico);

        return "redirect:/servico";
    }

    @GetMapping("/atualizarservico/{id}")
    public ModelAndView update(@PathVariable(name="id") Integer id){
        ModelAndView mv = new ModelAndView("ServicoUpdate");
        Servico servico = ss.getServicoById(id);

        mv.addObject("servico", servico);
        return mv;
    }

    @GetMapping("/removerservico/{id}")
    public String remover(@PathVariable (name="id") Integer id){
        
        Servico servico = ss.getServicoById(id);
        ss.remover(servico);

        return "redirect:/servico";
    }
}