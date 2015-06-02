package br.eti.victorsoares.aula04.daos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.Model.Item;
import br.eti.victorsoares.aula04.Model.Pessoa;

/**
 * Created by vsoares on 26/05/15.
 */
public class ItemDAO {

    protected static final String SCRIPT_CREATE = "CREATE TABLE item(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "descricao TEXT, " +
            "_id_categoria INTEGER, " +
            "_id_pessoa INTEGER, " +
            "FOREIGN KEY (_id_categoria) REFERENCES categoria(_id)," +
            "FOREIGN KEY (_id_pessoa) REFERENCES pessoa(_id));";

    AcessoDB acessoDB;

    public ItemDAO(Context ctx) {
        acessoDB = new AcessoDB(ctx);
    }


    public ArrayList<Object> getList() {

        ArrayList<Object> list = new ArrayList<Object>();
        SQLiteDatabase baseDados = acessoDB.getReadableDatabase();
        String query = "SELECT * FROM item";
        Cursor retornoBase = baseDados.rawQuery(query, null);

        if(retornoBase.moveToFirst()) {
            do {
                //Recuperando valores e add a lista.
                Item i = new Item();
                i.setId(retornoBase.getLong(retornoBase.getColumnIndex("_id")));
                i.setDescricao(retornoBase.getString((retornoBase.getColumnIndex("descricao"))));
                list.add(i);
            } while (retornoBase.moveToNext());
        }
        baseDados.close();
        return list;
    }


    public ArrayList<Object> getList(long idPessoa) {

        ArrayList<Object> list = new ArrayList<Object>();
        SQLiteDatabase baseDados = acessoDB.getReadableDatabase();
        String query = "SELECT * FROM item where _id_pessoa = ?";
        Cursor retornoBase = baseDados.rawQuery(query, new String[] {String.valueOf(idPessoa)});

        if(retornoBase.moveToFirst()) {
            do {
                //Recuperando valores e add a lista.
                Item i = new Item();
                i.setId(retornoBase.getLong(retornoBase.getColumnIndex("_id")));
                i.setDescricao(retornoBase.getString((retornoBase.getColumnIndex("descricao"))));
                list.add(i);
            } while (retornoBase.moveToNext());
        }
        baseDados.close();
        return list;
    }


    public Item getItem(long id) {
        return null;
    }
}

