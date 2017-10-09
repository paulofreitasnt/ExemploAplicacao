package com.mycompany.aplicacaocompleta.controle;

import com.mycompany.aplicacaocompleta.banco.ConFactory;
import com.mycompany.aplicacaocompleta.modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProdutoDaoBanco implements Dao<Produto> {

    private Connection con;

    public ProdutoDaoBanco(){
        try {
            con = new ConFactory().getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Falha na conexão com o banco",
                    "Mensagem de Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public boolean salvar(Produto obj) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO produto (id,descricao,preco)"
                + " VALUES (?,?,?)");

        stmt.setInt(1, obj.getCodigo());
        stmt.setString(2, obj.getDescricao());
        stmt.setFloat(3, obj.getPreco());

        return stmt.executeUpdate() > 0;
    }

    @Override
    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM produto");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Produto p = new Produto();
            p.setCodigo(rs.getInt(1));
            p.setDescricao(rs.getString(2));
            p.setPreco(rs.getFloat(3));
            produtos.add(p);
        }
        
        return produtos;
    }

}
