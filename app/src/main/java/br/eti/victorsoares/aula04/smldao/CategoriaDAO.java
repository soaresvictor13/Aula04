package br.eti.victorsoares.aula04.smldao;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.daos.AcessoDB;

/**
 * Created by samuel on 09/06/15.
 */
public class CategoriaDAO implements modeloDAO {

    private AcessoDB acessoDB;

    protected static final String SCRIPT_CREATE = "CREATE TABLE Categoria(" +
                                              "_cod_categoria INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                              "nome_categoria TEXT;";

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
