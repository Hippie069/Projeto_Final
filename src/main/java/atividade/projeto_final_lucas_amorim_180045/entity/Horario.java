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
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;

@Entity
public class Horario implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String data;
    private String hora;

    @ManyToMany
    @JoinTable(
        name = "HorarioServico",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_horario", "id_servi"}),
        joinColumns = @JoinColumn(name="id_horario"),
        inverseJoinColumns = @JoinColumn(name="id_servi")
    )
    private List<Servico> servicos;

    @ManyToOne
    @JoinColumn(name="ID_MARCADO")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="ID_AGENDADO")
    private Profissional profissional;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    
}