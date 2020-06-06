package atividade.projeto_final_lucas_amorim_180045.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import atividade.projeto_final_lucas_amorim_180045.entity.Horario;
import atividade.projeto_final_lucas_amorim_180045.entity.Servico;
import atividade.projeto_final_lucas_amorim_180045.service.ClienteService;
import atividade.projeto_final_lucas_amorim_180045.service.HorarioService;
import atividade.projeto_final_lucas_amorim_180045.service.ProfissionalService;
import atividade.projeto_final_lucas_amorim_180045.service.ServicoService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HorarioController {
    @Autowired
    private HorarioService hs;

    @Autowired
    private ClienteService cs;

    @Autowired
    private ProfissionalService ps;

    @Autowired
    private ServicoService ss;

    @GetMapping("/horario")
    public ModelAndView horarioView(){
        ModelAndView mv = new ModelAndView ("HorarioView");

                
        mv.addObject("horario", new Horario());
        mv.addObject("horarios", hs.getHorarios());
        mv.addObject("clientes", cs.getClientes());
        mv.addObject("profissionais", ps.getProfissionais());
        

        return mv;
    } 

    @PostMapping("/salvarhorario")
    public String save(@ModelAttribute Horario horario){
        hs.salvar(horario);

        return "redirect:/horario";
    }

    @GetMapping("/escolherservicos/{cod}")
    public ModelAndView getServicos(@PathVariable (name="cod") Integer cod) {
        ModelAndView mv = new ModelAndView("HorarioServico");
        Horario horario = hs.getHorarioById(cod);

 
        mv.addObject("horario", horario);
        mv.addObject("servicos", horario.getProfissional().getServico());

        return mv;
    }

    @PostMapping("/associarservico")
    public String associarServico(HttpServletRequest req , @RequestParam Integer cod) {

        Horario horario = hs.getHorarioById(cod);
        Servico servico = ss.getServicoById(Integer.parseInt(req.getParameter("id")));

        horario.getServicos().add(servico);
        hs.salvar(horario);

        return "redirect:/escolherservicos/" + cod;
    }

    @GetMapping("/atualizarhorario/{id}")
    public ModelAndView update(@PathVariable(name="id") Integer id){
        ModelAndView mv = new ModelAndView("HorarioUpdate");
        Horario horario = hs.getHorarioById(id);

        mv.addObject("horario", horario);
        mv.addObject("clientes", cs.getClientes());
        mv.addObject("profissionais", ps.getProfissionais());
        return mv;
    }

    @GetMapping("/removerhorario/{id}")
    public String remover(@PathVariable (name="id") Integer id){
        
        Horario horario = hs.getHorarioById(id);
        hs.remover(horario);

        return "redirect:/horario";
    }
    
}