package br.eti.victorsoares.aula04.smldao;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.daos.AcessoDB;

/**
 * Created by samuel on 09/06/15.
 */
public class ItensDAO implements modeloDAO{

    protected static final String SCRIPT_CREATE="CREATE TABLE Itens(" +
                                                "_cod_item INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                "descricao_item TEXT,"+
                                                "nome_item TEXT;";
    private AcessoDB acessoDB;

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
