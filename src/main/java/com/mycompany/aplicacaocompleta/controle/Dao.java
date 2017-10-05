package com.mycompany.aplicacaocompleta.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    
    public boolean salvar(T obj) throws IOException, ClassNotFoundException, SQLException;
    public List<T> listar() throws IOException, ClassNotFoundException, SQLException;
    
}
