package atividade.projeto_final_lucas_amorim_180045.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atividade.projeto_final_lucas_amorim_180045.entity.Horario;
import atividade.projeto_final_lucas_amorim_180045.repository.HorarioRepository;

@Service
public class HorarioService {
    @Autowired
    private HorarioRepository hr;

    public List<Horario> getHorarios(){
        return hr.findAll();
    }

    public void salvar(Horario horario){
        hr.save(horario);
    }

	public Horario getHorarioById(Integer id) {
		return hr.findById(id).get();
    } 

    public void remover(Horario horario) {
        hr.delete(horario);
	}
}