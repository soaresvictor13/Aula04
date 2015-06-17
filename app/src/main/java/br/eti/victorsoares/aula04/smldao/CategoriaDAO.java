package br.eti.victorsoares.aula04.smldao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.Model.Categoria;

/**
 * Created by samuel on 09/06/15.
 */
public class CategoriaDAO implements modeloDAO {

    protected static final String SCRIPT_CREATE = "CREATE TABLE Categoria(" +
                                              "_cod_categoria INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                              "_cod_item INTEGER,"+
                                              "nome_categoria TEXT," +
                                              "FOREIGN KEY (_cod_item) REFERENCES Itens(_cod_item));" ;
    private AcessoDB acessoDB;

    public CategoriaDAO(Context context) {
        acessoDB = new AcessoDB(context);
    }

    @Override
    public void insert(Object obj) {
        Log.i("BANCO0", "Inserindo nova categoria");
        Categoria categoria = (Categoria) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues valoresInserir = new ContentValues();
        valoresInserir.put("nome_categoria", categoria.getDescricao());
        baseDados.insert("Categoria",null,valoresInserir);
        baseDados.close();
    }

    @Override
    public void update(Object obj) {
        Log.i("BANCO0", "Atualizando categoria");
        Categoria categoria = (Categoria) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome_categoria" , categoria.getDescricao());
        cv.put("_cod_item" , categoria.getCod_item());
        baseDados.update("Categoria", cv, "_cod_categoria", new String[]{String.valueOf(categoria.getId())});
        baseDados.close();
    }

    @Override
    public void delete(Object obj) {
        Log.i("BANCO0", "Desfazendo uma linda amizade");
        Categoria categoria = (Categoria) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("cod_amigo",categoria.getId());
        baseDados.delete("Categoria", "_cod_categoria", new String[]{String.valueOf(categoria.getId())});
        baseDados.close();
    }

    @Override
    public ArrayList<Object> get() {

        ArrayList<Object> list = new ArrayList<>();
        SQLiteDatabase baseDados = acessoDB.getReadableDatabase();
        String query = "SELECT * FROM Categoria";
        Cursor retornoBase = baseDados.rawQuery(query, null);

        if(retornoBase.moveToFirst()) {
            do {
                //Recuperando valores e add a lista.
                //
                Categoria categoria = new Categoria();
                categoria.setId(retornoBase.getLong(retornoBase.getColumnIndex("_cod_categoria")));
                categoria.setCod_item(retornoBase.getLong(retornoBase.getColumnIndex("_cod_item")));
                categoria.setDescricao(retornoBase.getString(retornoBase.getColumnIndex("nome_categoria")));
                list.add(categoria);
            } while (retornoBase.moveToNext());
        }
        baseDados.close();
        return list;
    }
}
