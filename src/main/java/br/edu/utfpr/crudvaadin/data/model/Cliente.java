package br.edu.utfpr.crudvaadin.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String primeiroNome = "";
    private String sobrenome = "";
    private LocalDate dataNascimento;
    private ClienteStatus status;
    private String email = "";

    public Cliente(){
    }

    public Cliente(String nome, String sobrenome, LocalDate dtNasc, String email) {
        this.primeiroNome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dtNasc;
        this.status = ClienteStatus.Ativo;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ClienteStatus getStatus() {
        return status;
    }

    public void setStatus(ClienteStatus status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPersisted() {
        return id != null;
    }

    @Override
    public String toString() {
        return primeiroNome + " " + sobrenome;
    }
}
