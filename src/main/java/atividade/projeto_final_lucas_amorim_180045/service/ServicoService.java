package atividade.projeto_final_lucas_amorim_180045.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atividade.projeto_final_lucas_amorim_180045.entity.Servico;
import atividade.projeto_final_lucas_amorim_180045.repository.ServicoRepository;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository sr;

    public List<Servico> getServicos(){
        if(sr.count() == 0){
            sr.save(new Servico("Corte"));
            sr.save(new Servico("Barba"));
           
        }
        return sr.findAll();
    }

    public void salvar(Servico servico){
        sr.save(servico);
    }

	public Servico getServicoById(Integer id) {
		return sr.findById(id).get();
    } 
    
    public void remover(Servico servico) {
        sr.delete(servico);
	}
}