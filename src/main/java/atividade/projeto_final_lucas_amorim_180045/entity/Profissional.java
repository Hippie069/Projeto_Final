package atividade.projeto_final_lucas_amorim_180045.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Profissional implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    @OneToMany
    @JoinColumn(name="ID_AGENDADO")
    private List<Horario> horario;

    @ManyToMany
    @JoinTable(
        name="ServicoProfissional",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_profissional, id_servico"}),
        joinColumns = @JoinColumn(name="id_profissional"),
        inverseJoinColumns = @JoinColumn(name="id_servico")
    )
    private List<Servico> servico;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Servico> getServico() {
        return servico;
    }

    public void setServico(List<Servico> servico) {
        this.servico = servico;
    }

    public List<Horario> getHorario() {
        return horario;
    }

    public void setHorario(List<Horario> horario) {
        this.horario = horario;
    }

    
}