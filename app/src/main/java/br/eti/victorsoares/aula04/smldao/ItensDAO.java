package br.eti.victorsoares.aula04.smldao;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.daos.AcessoDB;

/**
 * Created by samuel on 09/06/15.
 */
public class ItensDAO implements modeloDAO{

    private AcessoDB acessoDB;

    protected static final String SCRIPT_CREATE="CREATE TABLE Itens(" +
                                                "_cod_item INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                "FOREIGN KEY (_cod_categoria) REFERENCES Categoria(_cod_categoria),"+
                                                "descricao_item TEXT,"+
                                                "nome_item TEXT;";
    @Override
    public void insert(Object obj) {

    }

    @Override
    public void update(Object obj) {

    }

    @Override
    public void delete(Object obj) {

    }

    @Override
    public ArrayList<Object> get() {
        return null;
    }
}
