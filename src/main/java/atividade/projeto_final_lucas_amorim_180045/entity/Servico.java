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
public class Servico implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    @OneToMany
    @JoinColumn(name="ID_PRESTADO")    
    private List<Horario> horario;

    @ManyToMany
    @JoinTable(
        name="ServicoProfissional",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_profissional, id_servico"}),
        joinColumns = @JoinColumn(name="id_servico"),
        inverseJoinColumns = @JoinColumn(name="id_profissional")
    )
    private List<Profissional> profissional;

    

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

    public List<Profissional> getProfissional() {
        return profissional;
    }

    public void setProfissional(List<Profissional> profissional) {
        this.profissional = profissional;
    }

    public Servico(String nome) {
        this.nome = nome;
    }

    public Servico() {
        
    }
    
}