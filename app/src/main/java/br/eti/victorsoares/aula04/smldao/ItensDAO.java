package br.eti.victorsoares.aula04.smldao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Objects;

import br.eti.victorsoares.aula04.Model.Item;

/**
 * Created by samuel on 09/06/15.
 */
public class ItensDAO implements modeloDAO{

    protected static final String SCRIPT_CREATE="CREATE TABLE Itens(" +
                                                "_cod_item INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                "nome_item TEXT,"+
                                                "descricao_item TEXT)";

    private AcessoDB acessoDB;

    public ItensDAO(Context context) {
        acessoDB = new AcessoDB(context);
    }

    @Override
    public void insert(Object obj) {
        Log.i("BANCO0", "Inserindo novo item");
        Item ia = (Item) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues valoresInserir = new ContentValues();
        valoresInserir.put("nome_item", ia.getNome());
        valoresInserir.put("descricao_item", ia.getDescricao());
        baseDados.insert("Itens",null,valoresInserir);
        baseDados.close();
    }

    @Override
    public void update(Object obj) {
        Log.i("BANCO0", "Atualizando itens de amigos");
        Item ia = (Item) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome_item" , ia.getNome());
        cv.put("descricao_item" , ia.getDescricao());
        baseDados.update("Itens", cv, "_cod_item", new String[]{String.valueOf(ia.getId())});
        baseDados.close();
    }

    @Override
    public void delete(Object obj) {
        Log.i("BANCO0", "Deletando um item");
        Item ia = (Item) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("_cod_item",ia.getId());
        baseDados.delete("Itens", "_cod_item = ?", new String[]{String.valueOf(ia.getId())});
        baseDados.close();
    }

    @Override
    public ArrayList<Object> get() {
        ArrayList<Object> list = new ArrayList<Object>();
        SQLiteDatabase baseDados = acessoDB.getReadableDatabase();
        String query = "SELECT * FROM Itens";
        Cursor retornoBase = baseDados.rawQuery(query, null);

        if(retornoBase.moveToFirst()) {
            do {
                //Recuperando valores e add a lista.
                //
                Item ia = new Item();
                ia.setId(retornoBase.getLong(retornoBase.getColumnIndex("_cod_item")));
                ia.setDescricao(retornoBase.getString(retornoBase.getColumnIndex("descricao_item")));
                ia.setNome(retornoBase.getString(retornoBase.getColumnIndex("nome_item")));
                list.add(ia);
            } while (retornoBase.moveToNext());
        }

        Log.d("Banco", "Retornou "+ list.size());
        baseDados.close();
        return list;
    }

    public Item getItem(long id) {
        return null;
    }
}
