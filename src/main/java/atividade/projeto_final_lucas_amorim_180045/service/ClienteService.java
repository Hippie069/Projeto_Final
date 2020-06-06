package atividade.projeto_final_lucas_amorim_180045.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atividade.projeto_final_lucas_amorim_180045.entity.Cliente;
import atividade.projeto_final_lucas_amorim_180045.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository cr;

    public List<Cliente> getClientes(){
        return cr.findAll();
    }

    public void salvar(Cliente cliente){
        cr.save(cliente);
    }

	public Cliente getClienteById(Integer id) {
		return cr.findById(id).get();
    } 
    public void remover(Cliente cliente) {
        cr.delete(cliente);
	}
}