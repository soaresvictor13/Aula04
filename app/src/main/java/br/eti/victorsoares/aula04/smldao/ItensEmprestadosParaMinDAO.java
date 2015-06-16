package br.eti.victorsoares.aula04.smldao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.Model.ItensAmigos;
import br.eti.victorsoares.aula04.daos.AcessoDB;

/**
 * Created by samuel on 09/06/15.
 */
public class ItensEmprestadosParaMinDAO implements modeloDAO {

    protected static final String SCRIPT_CREATE="CREATE TABLE Itens_Emprestados_Para_Min(" +
            "_cod_emprestimo INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "FOREIGN KEY (_cod_usuario) REFERENCES Usuarios(_cod_usuario),"+
            "FOREIGN KEY (_cod_amigo) REFERENCES Amigos(_cod_amigo),"+
            "FOREIGN KEY (_cod_item) REFERENCES ItensAmigo(_cod_item),"+
            "data_emprestimo TEXT,"+
            "data_devolucao TEXT,"+
            "status TEXT;";
    private AcessoDB acessoDB;

    @Override
    public void insert(Object obj) {
        Log.i("BANCO0", "Inserindo novo item de amigo");
        ItensAmigos ia = (ItensAmigos) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues valoresInserir = new ContentValues();
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
