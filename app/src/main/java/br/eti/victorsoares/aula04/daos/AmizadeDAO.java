package br.eti.victorsoares.aula04.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.Model.Pessoa;
import br.eti.victorsoares.aula04.Model.Usuario;
import br.eti.victorsoares.aula04.smldao.AcessoDB;

/**
* Created by VictorSoares on 21/05/2015.
*/
public class AmizadeDAO {

    protected static final String SCRIPT_CREATE = "CREATE TABLE amizade(" +
            "id_usuario INTEGER, " +
            "id_amigo INTEGER," +
            "FOREIGN KEY (id_usuario) REFERENCES pessoa(_id)," +
            "FOREIGN KEY (id_amigo) REFERENCES pessoa(_id));";

    AcessoDB acessoDB;

    public AmizadeDAO(Context ctx) {
        acessoDB = new AcessoDB(ctx);
    }

    public void insert(Usuario usuario, Pessoa pessoa) {

        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues valoresInserir = new ContentValues();
        valoresInserir.put("id_usuario", usuario.getIdPessoa());
        valoresInserir.put("id_amigo", pessoa.getId());
        baseDados.insert("amizade", null, valoresInserir);
        baseDados.close();
    }

    public ArrayList<Object> getList() {
        return null;
    }

    public ArrayList<Object> get(long id_pessoa) {

        ArrayList<Object> list = new ArrayList<>();
        SQLiteDatabase baseDados = acessoDB.getReadableDatabase();
        String query = "SELECT * FROM pessoa JOIN amizade on (_id = id_pessoa) WHERE id_usuario = ?;";
        Cursor retornoBase = baseDados.rawQuery(query, new String[] { String.valueOf(id_pessoa) });

        while(retornoBase.moveToFirst()) {
            Pessoa p = new Pessoa();
            p.setId(retornoBase.getLong(retornoBase.getColumnIndex("_id")));
            p.setNome(retornoBase.getString((retornoBase.getColumnIndex("nome"))));
            p.setEmail(retornoBase.getString(retornoBase.getColumnIndex("email")));
            p.setTelefone(retornoBase.getString(retornoBase.getColumnIndex("telefone")));
            list.add(p);
        }

        baseDados.close();
        return list;

    }

    public void delete(Object obj) {
    }
}
