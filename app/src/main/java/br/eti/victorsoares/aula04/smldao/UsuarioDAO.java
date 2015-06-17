package br.eti.victorsoares.aula04.smldao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.Model.Usuario;
import br.eti.victorsoares.aula04.smldao.AcessoDB;

/**
* Created by VictorSoares on 21/05/2015.
*/
public class UsuarioDAO{

    protected static final String SCRIPT_CREATE = "CREATE TABLE usuario(" +
            "_cod_usuario INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "usuario TEXT, " +
            "senha TEXT," +
            "UNIQUE (usuario));";

    AcessoDB acessoDB;

    public UsuarioDAO(Context ctx) {
        acessoDB = new AcessoDB(ctx);
    }

    public void insert(Object obj) {

        Usuario u = (Usuario) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues valoresInserir = new ContentValues();
        valoresInserir.put("usuario", u.getUsuario());
        valoresInserir.put("senha", u.getSenha());
        baseDados.insert("usuario", null, valoresInserir);
        baseDados.close();
    }

    public ArrayList<Object> getList() {

        ArrayList<Object> list = new ArrayList<Object>();
        SQLiteDatabase baseDados = acessoDB.getReadableDatabase();
        String query = "SELECT * FROM usuario";
        Cursor retornoBase = baseDados.rawQuery(query, null);

        if(retornoBase.moveToFirst()) {
            do {
                //Recuperando valores e add a lista.
                Usuario u = new Usuario();
                u.setId(retornoBase.getLong(retornoBase.getColumnIndex("_cod_usuario")));
                u.setUsuario(retornoBase.getString((retornoBase.getColumnIndex("usuario"))));
                list.add(u);
            } while (retornoBase.moveToNext());
        }
        baseDados.close();
        return list;
    }

    public Object get(long id) {

        SQLiteDatabase baseDados = acessoDB.getReadableDatabase();
        String query = "SELECT * FROM usuario WHERE _cod_usuario=?";
        Cursor c = baseDados.rawQuery(query, new String[] { String.valueOf(id) });

        if(c.moveToFirst()) {
            Usuario u = new Usuario();
            u.setId(c.getLong(c.getColumnIndex("_cod_usuario")));
            u.setUsuario(c.getString((c.getColumnIndex("usuario"))));
            baseDados.close();
            return u;
        } else {
            baseDados.close();
            return null;
        }
    }

    public Object get(String usuario) {

        SQLiteDatabase baseDados = acessoDB.getReadableDatabase();
        String query = "SELECT * FROM usuario WHERE usuario=?";
        Cursor c = baseDados.rawQuery(query, new String[] {usuario});

        if(c.moveToFirst()) {
            Usuario u = new Usuario();
            u.setId(c.getLong(c.getColumnIndex("_cod_usuario")));
            u.setUsuario(c.getString((c.getColumnIndex("usuario"))));
            baseDados.close();
            return u;
        } else {
            baseDados.close();
            return null;
        }
    }

    public void update(Object obj) {

        Usuario u = (Usuario) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("usuario", u.getUsuario());
        cv.put("senha", u.getSenha());
        baseDados.update("usuario", cv, "_cod_usuario =" + u.getId(), null);

    }

    public void delete(Object obj) {
        Usuario u = (Usuario) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        baseDados.delete("usuario", "_cod_usuario =" + u.getId(), null);
        baseDados.close();
    }


    public Object login(String usuario, String senha) {

        SQLiteDatabase baseDados = acessoDB.getReadableDatabase();
        String query = "SELECT * FROM usuario WHERE usuario=? AND senha=?";
        Cursor c = baseDados.rawQuery(query, new String[] { usuario, senha });

        if(c.moveToFirst()) {
            Usuario u = new Usuario();
            u.setId(c.getLong(c.getColumnIndex("_cod_usuario")));
            u.setUsuario(c.getString((c.getColumnIndex("usuario"))));
            baseDados.close();
            return u;
        } else {
            baseDados.close();
            return null;
        }
    }

}
