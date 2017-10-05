package com.mycompany.aplicacaocompleta.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Venda implements Serializable {

    private int id;
    private List<ItemVenda> itens;
    private LocalDate data;

    public Venda() {
        itens = new ArrayList<>();
    }

    public Venda(int id, List<ItemVenda> itens, LocalDate data) {
        this.id = id;
        this.itens = itens;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", itens=" + itens + ", data=" + data + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.itens);
        hash = 29 * hash + Objects.hashCode(this.data);
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
        final Venda other = (Venda) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.itens, other.itens)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    public float calcularTotal() {
        float total = 0;

        for (ItemVenda i : itens) {
            total += i.calcularSubtotal();
        }

        return total;
    }
    
    public boolean addItem(ItemVenda i){
        return itens.add(i);
    }

}
