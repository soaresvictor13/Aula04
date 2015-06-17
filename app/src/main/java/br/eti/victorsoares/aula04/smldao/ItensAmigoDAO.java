package br.eti.victorsoares.aula04.smldao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.Model.ItensAmigos;

/**
 * Created by samuel on 10/06/15.
 */
public class ItensAmigoDAO implements modeloDAO {

    protected static final String SCRIPT_CREATE="CREATE TABLE ItensAmigos(" +
            "_cod_item INTEGER PRIMARY KEY AUTOINCREMENT," +
            "FOREIGN KEY (_cod_amigo) REFERENCES Amigos(_cod_amigo),"+
            "descricao_item TEXT,"+
            "nome_item TEXT;";
    private AcessoDB acessoDB;

    @Override
    public void insert(Object obj) {
        Log.i("BANCO0", "Inserindo novo item de amigo");
        ItensAmigos ia = (ItensAmigos) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues valoresInserir = new ContentValues();
        valoresInserir.put("_cod_amigo", ia.getCod_amigo());
        valoresInserir.put("nome_item", ia.getNome_item());
        valoresInserir.put("descricao_item" , ia.getDescricao_item());
        baseDados.insert("ItensAmigos",null,valoresInserir);
        baseDados.close();
    }

    @Override
    public void update(Object obj) {
        Log.i("BANCO0", "Atualizando itens de amigos");
        ItensAmigos ia = (ItensAmigos) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome_item" , ia.getNome_item());
        cv.put("descricao_item" , ia.getDescricao_item());
        cv.put("_cod_amigo" , ia.getCod_amigo());
        baseDados.update("ItensAmigos", cv, "_cod_item", new String[]{String.valueOf(ia.getCod_item())});
        baseDados.close();
    }

    @Override
    public void delete(Object obj) {
        Log.i("BANCO0", "Deletando um item de amigo");
        ItensAmigos ia = (ItensAmigos) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("_cod_item",ia.getCod_amigo());
        baseDados.delete("ItensAmigos", "_cod_item", new String[]{String.valueOf(ia.getCod_item())});
        baseDados.close();
    }

    @Override
    public ArrayList<Object> get() {
        ArrayList<Object> list = new ArrayList<>();
        SQLiteDatabase baseDados = acessoDB.getReadableDatabase();
        String query = "SELECT * FROM ItensAmigos";
        Cursor retornoBase = baseDados.rawQuery(query, null);

        if(retornoBase.moveToFirst()) {
            do {
                //Recuperando valores e add a lista.
                //
                ItensAmigos ia = new ItensAmigos();
                ia.setCod_item(retornoBase.getLong(retornoBase.getColumnIndex("_cod_item")));
                ia.setCod_amigo(retornoBase.getLong(retornoBase.getColumnIndex("_cod_amigo")));
                ia.setDescricao_item(retornoBase.getString(retornoBase.getColumnIndex("descricao_item")));
                ia.setNome_item(retornoBase.getString(retornoBase.getColumnIndex("nome_item")));
                list.add(ia);
            } while (retornoBase.moveToNext());
        }
        baseDados.close();
        return list;
    }
}
