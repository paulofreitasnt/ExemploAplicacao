package com.mycompany.aplicacaocompleta.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Supermercado implements Serializable {

    private int id;
    private String nome;
    private List<Venda> vendas;

    public Supermercado() {
        vendas = new ArrayList<>();
    }

    public Supermercado(int id, String nome, List<Venda> vendas) {
        this.id = id;
        this.nome = nome;
        this.vendas = vendas;
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

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    @Override
    public String toString() {
        return "Supermercado{" + "id=" + id + ", nome=" + nome + ", vendas=" + vendas + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + Objects.hashCode(this.vendas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Supermercado other = (Supermercado) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.vendas, other.vendas)) {
            return false;
        }
        return true;
    }

    public boolean addVenda(Venda v){
        return vendas.add(v);
    }
    
}
