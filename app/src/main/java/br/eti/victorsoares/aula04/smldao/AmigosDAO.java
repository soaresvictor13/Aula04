package br.eti.victorsoares.aula04.smldao;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.daos.AcessoDB;

/**
 * Created by samuel on 09/06/15.
 */
public class AmigosDAO implements modeloDAO{

    private AcessoDB acessoDB;

    protected static final String SCRIPT_CREATE = "CREATE TABLE Amigos(" +
            "_cod_amigo INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "FOREIGN KEY (_cod_usuario) REFERENCES Usuarios(_cod_usuario)," +
            "nome_amigo TEXT," +
            "img_amigo BLOB";


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
