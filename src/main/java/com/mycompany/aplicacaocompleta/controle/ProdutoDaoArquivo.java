package com.mycompany.aplicacaocompleta.controle;

import com.mycompany.aplicacaocompleta.modelo.Produto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDaoArquivo implements Dao<Produto> {

    private final File arquivo;

    public ProdutoDaoArquivo() throws IOException {

        arquivo = new File("produtos.bin");

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

    }

    @Override
    public boolean salvar(Produto obj) throws IOException, ClassNotFoundException {
        List<Produto> produtos = listar();

        if (produtos.add(obj)) {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(arquivo));

            out.writeObject(produtos);
            out.close();
            return true;

        } else {
            return false;
        }

    }

    @Override
    public List<Produto> listar() throws IOException, ClassNotFoundException {
        if (arquivo.length() > 0) {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(arquivo));

            return (List<Produto>) in.readObject();
        } else {
            return new ArrayList<>();
        }
    }

}
