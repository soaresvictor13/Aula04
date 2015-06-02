package br.eti.victorsoares.aula04.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.Model.Categoria;
import br.eti.victorsoares.aula04.Model.Pessoa;
import br.eti.victorsoares.aula04.Model.Usuario;

/**
* Created by VictorSoares on 21/05/2015.
*/
public class CategoriaDAO {

    protected static final String SCRIPT_CREATE = "CREATE TABLE categoria(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "descricao TEXT);";

    AcessoDB acessoDB;

    public CategoriaDAO(Context ctx) {
        acessoDB = new AcessoDB(ctx);
    }

    public void insert(Object obj) {

        Categoria c = (Categoria) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues valoresInserir = new ContentValues();
        valoresInserir.put("descricao", c.getDescricao());
        long novoId = baseDados.insert("categoria", null, valoresInserir);
        c.setId(novoId);
        baseDados.close();
    }

    public ArrayList<Object> getList() {

        ArrayList<Object> list = new ArrayList<Object>();
        SQLiteDatabase baseDados = acessoDB.getReadableDatabase();
        String query = "SELECT * FROM categoria";
        Cursor retornoBase = baseDados.rawQuery(query, null);

        if(retornoBase.moveToFirst()) {
            do {
                //Recuperando valores e add a lista.
                Categoria c = new Categoria();
                c.setId(retornoBase.getLong(retornoBase.getColumnIndex("_id")));
                c.setDescricao(retornoBase.getString((retornoBase.getColumnIndex("descricao"))));
                list.add(c);
            } while (retornoBase.moveToNext());
        }
        baseDados.close();
        return list;
    }

    public Object get(long id) {

        SQLiteDatabase baseDados = acessoDB.getReadableDatabase();
        String query = "SELECT * FROM categoria WHERE _id=?";
        Cursor retornoBase = baseDados.rawQuery(query, new String[] { String.valueOf(id) });

        if(retornoBase.moveToFirst()) {
            Categoria c = new Categoria();
            c.setId(retornoBase.getLong(retornoBase.getColumnIndex("_id")));
            c.setDescricao(retornoBase.getString((retornoBase.getColumnIndex("descricao"))));
            baseDados.close();
            return c;
        } else {
            baseDados.close();
            return null;
        }
    }

    public void update(Object obj) {

        Categoria c = (Categoria) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("decricao", c.getDescricao());
        baseDados.update("categoria", cv, "_id =" + c.getId(), null);

    }

    public void delete(Object obj) {
        Categoria c = (Categoria) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        baseDados.delete("categoria", "_id =" + c.getId(), null);
        baseDados.close();
    }
}
