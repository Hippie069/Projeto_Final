package atividade.projeto_final_lucas_amorim_180045.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atividade.projeto_final_lucas_amorim_180045.entity.Profissional;
import atividade.projeto_final_lucas_amorim_180045.repository.ProfissionalRepository;

@Service
public class ProfissionalService {
    @Autowired
    private ProfissionalRepository pr;

    public List<Profissional> getProfissionais(){
        return pr.findAll();
    }

    public void salvar(Profissional profissional){
        pr.save(profissional);
    }

	public Profissional getProfissionalById(Integer id) {
		return pr.findById(id).get();
	} 
}