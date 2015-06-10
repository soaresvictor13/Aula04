package br.eti.victorsoares.aula04.smldao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.Model.Amigo;
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
            "img_amigo TEXT";


    @Override
    public void insert(Object obj) {
        Log.i("BANCO0", "Inserindo nova pessoa");
        Amigo amigo = (Amigo) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues valoresInserir = new ContentValues();
        valoresInserir.put("nome_amigo", amigo.getNome());
        valoresInserir.put("img_amigo", amigo.getImagem());
        baseDados.close();
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
