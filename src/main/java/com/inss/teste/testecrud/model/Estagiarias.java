package com.inss.teste.testecrud.model;

public class Estagiarias {
    private int id;
    private String nome;

    public Estagiarias(){}

    public Estagiarias(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

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
    @Override
    public String toString() {
        return this.nome;
    }

    public int getCdEstagiarias() {
        return 0;
    }
}
