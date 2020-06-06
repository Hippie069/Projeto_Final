package atividade.projeto_final_lucas_amorim_180045.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import atividade.projeto_final_lucas_amorim_180045.entity.Cliente;
import atividade.projeto_final_lucas_amorim_180045.service.ClienteService;

@Controller
public class ClienteController {
    @Autowired
    private ClienteService cs;

    @GetMapping("/cliente")
    public ModelAndView ClienteView(){
        ModelAndView mv = new ModelAndView ("ClienteView");
        
        mv.addObject("cliente", new Cliente());
        mv.addObject("clientes", cs.getClientes());

        return mv;
    } 

    @PostMapping("/salvarcliente")
    public String save(@ModelAttribute Cliente cliente){
        cs.salvar(cliente);

        return "redirect:/cliente";
    }

    @GetMapping("/atualizarcliente/{id}")
    public ModelAndView update(@PathVariable(name="id") Integer id){
        ModelAndView mv = new ModelAndView("ClienteUpdate");
        Cliente cliente = cs.getClienteById(id);

        mv.addObject("cliente", cliente);
        return mv;
    }

    @GetMapping("/removercliente/{id}")
    public String remover(@PathVariable (name="id") Integer id){
        
        Cliente cliente = cs.getClienteById(id);
        cs.remover(cliente);

        return "redirect:/cliente";
    }


    /*@GetMapping("/associados/{id}")
    public ModelAndView associados(@PathVariable(name="id") Integer id){
        ModelAndView mv = new ModelAndView("listaComunidades");
        SerVivo serVivo = svs.getSerVivoById(id);
        List<Comunidade> comunidade = cs.getTodasComunidades();

        mv.addObject("servivo", serVivo);
        mv.addObject("comunidades", comunidade);

        return mv;
    }*/
}