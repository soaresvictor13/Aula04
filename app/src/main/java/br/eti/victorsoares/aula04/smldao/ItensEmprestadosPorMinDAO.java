package br.eti.victorsoares.aula04.smldao;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.daos.AcessoDB;

/**
 * Created by samuel on 09/06/15.
 */
public class ItensEmprestadosPorMinDAO implements modeloDAO {

    private AcessoDB acessoDB;
    protected static final String SCRIPT_CREATE="CREATE TABLE Itens_Emprestados_Por_Min(" +
            "_cod_emprestimo INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "FOREIGN KEY (_cod_usuario) REFERENCES Usuario(_cod_usuario),"+
            "FOREIGN KEY (_cod_amigo) REFERENCES Amigo(_cod_amigo),"+
            "FOREIGN KEY (_cod_item) REFERENCES Itens(_cod_item),"+
            "data_emprestimo TEXT,"+
            "data_devolucao TEXT,"+
            "status TEXT;";


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
