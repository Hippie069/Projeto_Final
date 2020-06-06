package atividade.projeto_final_lucas_amorim_180045.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import atividade.projeto_final_lucas_amorim_180045.entity.Horario;
import atividade.projeto_final_lucas_amorim_180045.entity.Profissional;
import atividade.projeto_final_lucas_amorim_180045.entity.Servico;
import atividade.projeto_final_lucas_amorim_180045.service.HorarioService;
import atividade.projeto_final_lucas_amorim_180045.service.ProfissionalService;
import atividade.projeto_final_lucas_amorim_180045.service.ServicoService;

@Controller
public class ProfissionalController {
    @Autowired
    private ProfissionalService ps;

    @Autowired
    private ServicoService ss;

    @Autowired
    private HorarioService hs;

    @GetMapping("/profissional")
    public ModelAndView profissionalView(){
        ModelAndView mv = new ModelAndView ("ProfissionalView");
        
        mv.addObject("profissional", new Profissional());
        mv.addObject("profissionais", ps.getProfissionais());

        return mv;
    } 

    @PostMapping("/salvarprofissional")
    public String save(@ModelAttribute Profissional profissional){
        ps.salvar(profissional);

        return "redirect:/profissional";
    }

    @GetMapping("/adicionarservicos/{cod}")
    public ModelAndView getServicos(@PathVariable (name="cod") Integer cod) {
        ModelAndView mv = new ModelAndView("ProfissionalServico");
        Profissional profissional = ps.getProfissionalById(cod);
        List<Servico> servico = ss.getServicos();

        servico.removeAll(profissional.getServico());

        mv.addObject("profissional", profissional);
        mv.addObject("servicos", servico);

        return mv;
    }

    @PostMapping("/addservico")
    public String associarServico(HttpServletRequest req , @RequestParam Integer cod) {

        Profissional profissional = ps.getProfissionalById(cod);
        Servico servico = ss.getServicoById(Integer.parseInt(req.getParameter("ids")));

        profissional.getServico().add(servico);
        ps.salvar(profissional);

        return "redirect:/adicionarservicos/" + cod;
    }

    @GetMapping("/verhorarios/{cod}")
    public ModelAndView gethorarios(@PathVariable (name="cod") Integer cod) {
        ModelAndView mv = new ModelAndView("ProfissionalHorario");
        Profissional profissional = ps.getProfissionalById(cod);
        List<Horario> horario = hs.getHorarios();

        mv.addObject("profissional", profissional);
        mv.addObject("horarios", horario);

        return mv;
    }

    @GetMapping("/atualizarprofissional/{id}")
    public ModelAndView update(@PathVariable(name="id") Integer id){
        ModelAndView mv = new ModelAndView("ProfissionalUpdate");
        Profissional profissional = ps.getProfissionalById(id);

        mv.addObject("profissional", profissional);
        return mv;
    }

    @GetMapping("/removerprofissional/{id}")
    public String remover(@PathVariable (name="id") Integer id){
        
        Profissional profissional = ps.getProfissionalById(id);
        ps.remover(profissional);

        return "redirect:/profissional";
    }
    
}