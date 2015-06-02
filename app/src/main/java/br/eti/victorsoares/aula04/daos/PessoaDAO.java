package br.eti.victorsoares.aula04.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.Model.Pessoa;
import br.eti.victorsoares.aula04.Model.Usuario;

/**
* Created by VictorSoares on 21/05/2015.
*/
public class PessoaDAO {

    protected static final String SCRIPT_CREATE = "CREATE TABLE pessoa(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nome TEXT, " +
            "telefone TEXT," +
            "email TEXT);";

    AcessoDB acessoDB;

    public PessoaDAO(Context ctx) {
        acessoDB = new AcessoDB(ctx);
    }

    public void insert(Object obj) {

        Pessoa p = (Pessoa) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues valoresInserir = new ContentValues();
        valoresInserir.put("nome", p.getNome());
        valoresInserir.put("telefone", p.getTelefone());
        valoresInserir.put("email", p.getEmail());
        long novoId = baseDados.insert("pessoa", null, valoresInserir);
        p.setId(novoId);
        baseDados.close();
    }

    public ArrayList<Object> getList() {

        ArrayList<Object> list = new ArrayList<Object>();
        SQLiteDatabase baseDados = acessoDB.getReadableDatabase();
        String query = "SELECT * FROM pessoa";
        Cursor retornoBase = baseDados.rawQuery(query, null);

        if(retornoBase.moveToFirst()) {
            do {
                //Recuperando valores e add a lista.
                Pessoa p = new Pessoa();
                p.setId(retornoBase.getLong(retornoBase.getColumnIndex("_id")));
                p.setNome(retornoBase.getString((retornoBase.getColumnIndex("nome"))));
                p.setEmail(retornoBase.getString(retornoBase.getColumnIndex("email")));
                p.setTelefone(retornoBase.getString(retornoBase.getColumnIndex("telefone")));
                list.add(p);
            } while (retornoBase.moveToNext());
        }
        baseDados.close();
        return list;
    }

    public Object get(long id) {

        SQLiteDatabase baseDados = acessoDB.getReadableDatabase();
        String query = "SELECT * FROM pessoa WHERE _id=?";
        Cursor retornoBase = baseDados.rawQuery(query, new String[] { String.valueOf(id) });

        if(retornoBase.moveToFirst()) {
            Pessoa p = new Pessoa();
            p.setId(retornoBase.getLong(retornoBase.getColumnIndex("_id")));
            p.setNome(retornoBase.getString((retornoBase.getColumnIndex("nome"))));
            p.setEmail(retornoBase.getString(retornoBase.getColumnIndex("email")));
            p.setTelefone(retornoBase.getString(retornoBase.getColumnIndex("telefone")));
            baseDados.close();
            return p;
        } else {
            baseDados.close();
            return null;
        }
    }

    public void update(Object obj) {

        Pessoa p = (Pessoa) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome", p.getNome());
        cv.put("email", p.getEmail());
        cv.put("telefone", p.getTelefone());
        baseDados.update("pessoa", cv, "_id =" + p.getId(), null);

    }

    public void delete(Object obj) {
        Usuario u = (Usuario) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        baseDados.delete("pessoa", "_id =" + u.getId(), null);
        baseDados.close();
    }
}
