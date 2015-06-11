package br.eti.victorsoares.aula04.smldao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.Model.Amigo;
import br.eti.victorsoares.aula04.Model.Categoria;
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
        Log.i("BANCO0", "Inserindo novo amigo");
        Amigo amigo = (Amigo) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues valoresInserir = new ContentValues();
        valoresInserir.put("nome_amigo", amigo.getNome());
        valoresInserir.put("img_amigo", amigo.getImagem());
        baseDados.insert("Amigos",null,valoresInserir);
        baseDados.close();
    }

    @Override
    public void update(Object obj) {
        Log.i("BANCO0", "Atualizando amigo");
        Amigo amigo = (Amigo) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome_amigo" , amigo.getNome());
        cv.put("img_amigo" , amigo.getImagem());
        baseDados.update("Amigos", cv, "_cod_amigo", new String[]{String.valueOf(amigo.getCod_amigo())});
        baseDados.close();
    }

    @Override
    public void delete(Object obj) {
        Log.i("BANCO0", "Desfazendo uma linda amizade");
        Amigo amigo = (Amigo) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("cod_amigo",amigo.getCod_amigo());
        baseDados.delete("Amigos", "_cod_amigo", new String[]{String.valueOf(amigo.getCod_amigo())});
        baseDados.close();
    }

    @Override
    public ArrayList<Object> get() {
        ArrayList<Object> list = new ArrayList<>();
        SQLiteDatabase baseDados = acessoDB.getReadableDatabase();
        String query = "SELECT * FROM Amigos";
        Cursor retornoBase = baseDados.rawQuery(query, null);

        if(retornoBase.moveToFirst()) {
            do {
                //Recuperando valores e add a lista.
                //
                Amigo amigo = new Amigo();
                amigo.setCod_amigo(retornoBase.getLong(retornoBase.getColumnIndex("_cod_amigo")));
                amigo.setCod_usuario(retornoBase.getLong(retornoBase.getColumnIndex("_cod_usuario")));
                amigo.setNome(retornoBase.getString(retornoBase.getColumnIndex("nome_amigo")));
                amigo.setImagem(retornoBase.getString(retornoBase.getColumnIndex("img_amigo")));
                list.add(amigo);
            } while (retornoBase.moveToNext());
        }
        baseDados.close();
        return list;
    }
}
