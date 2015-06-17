package br.eti.victorsoares.aula04.smldao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.Model.ItensEmprestadosParaMin;
import br.eti.victorsoares.aula04.Model.ItensEmprestadosPorMin;
import br.eti.victorsoares.aula04.Util.Data;
import br.eti.victorsoares.aula04.daos.AcessoDB;

/**
 * Created by samuel on 09/06/15.
 */
public class ItensEmprestadosPorMinDAO implements modeloDAO {

    protected static final String SCRIPT_CREATE="CREATE TABLE Itens_Emprestados_Por_Min(" +
            "_cod_emprestimo INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "_cod_usuario INTEGER ,"+
            "_cod_amigo INTEGER ,"+
            "_cod_item INTEGER ,"+
            "data_emprestimo TEXT,"+
            "data_devolucao TEXT,"+
            "status TEXT,"+
            "FOREIGN KEY (_cod_usuario) REFERENCES Usuarios(_cod_usuario),"+
            "FOREIGN KEY (_cod_amigo) REFERENCES Amigos(_cod_amigo),"+
            "FOREIGN KEY (_cod_item) REFERENCES ItensAmigo(_cod_item);";
    
    private AcessoDB acessoDB;

    public void insert(Object obj) {
        Log.i("BANCO0", "Inserindo novo item de amigo");
        ItensEmprestadosPorMin ieparam = (ItensEmprestadosPorMin) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues valoresInserir = new ContentValues();
        valoresInserir.put("_cod_usuario" , ieparam.getCod_usuario());
        valoresInserir.put("_cod_amigo" , ieparam.getCod_amigo());
        valoresInserir.put("_cod_item" , ieparam.getCod_item());
        valoresInserir.put("data_emprestimo" , Data.fromCalendar(ieparam.getData_emprestimo()));
        valoresInserir.put("data_devolucao" , Data.fromCalendar(ieparam.getData_devolucao()));
        valoresInserir.put("status" , ieparam.getStatus_emprestimo());
        baseDados.close();
    }

    @Override
    public void update(Object obj) {
        Log.i("BANCO0", "Atualizando categoria");
        ItensEmprestadosPorMin ieparam = (ItensEmprestadosPorMin) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("_cod_usuario",ieparam.getCod_usuario());
        cv.put("_cod_amigo",ieparam.getCod_amigo());
        cv.put("_cod_item",ieparam.getCod_item());
        cv.put("data_emprestimo",Data.fromCalendar(ieparam.getData_emprestimo()));
        cv.put("data_devolucao",Data.fromCalendar(ieparam.getData_devolucao()));
        cv.put("status",ieparam.getStatus_emprestimo());
        baseDados.update("Itens_Emprestados_Para_Min", cv, "_cod_emprestimo", new String[]{String.valueOf(ieparam.getCod_emprestimo())});
        baseDados.close();
    }

    @Override
    public void delete(Object obj) {
        Log.i("BANCO0", "Deletando um item de amigo");
        ItensEmprestadosPorMin ieparam = (ItensEmprestadosPorMin) obj;
        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("_cod_emprestimo",ieparam.getCod_emprestimo());
        baseDados.delete("Itens_Emprestados_Para_Min", "_cod_emprestimo", new String[]{String.valueOf(ieparam.getCod_emprestimo())});
        baseDados.close();
    }

    @Override
    public ArrayList<Object> get() {
        ArrayList<Object> list = new ArrayList<>();
        SQLiteDatabase baseDados = acessoDB.getReadableDatabase();
        String query = "SELECT * FROM Itens_Emprestados_Para_Min";
        Cursor retornoBase = baseDados.rawQuery(query, null);

        if(retornoBase.moveToFirst()) {
            do {
                //Recuperando valores e add a lista.
                //
                ItensEmprestadosPorMin ieparam = new ItensEmprestadosPorMin();
                ieparam.setCod_emprestimo(retornoBase.getLong(retornoBase.getColumnIndex("_cod_emprestimo")));
                ieparam.setCod_amigo(retornoBase.getLong(retornoBase.getColumnIndex("_cod_amigo")));
                ieparam.setCod_item(retornoBase.getLong(retornoBase.getColumnIndex("_cod_item")));
                ieparam.setCod_usuario(retornoBase.getLong(retornoBase.getColumnIndex("_cod_usuario")));
                ieparam.setData_devolucao(Data.toCalendar(retornoBase.getString(retornoBase.getColumnIndex("data_devolucao"))));
                ieparam.setData_emprestimo(Data.toCalendar(retornoBase.getString(retornoBase.getColumnIndex("data_emprestimo"))));
                ieparam.setStatus_emprestimo(retornoBase.getString(retornoBase.getColumnIndex("status")));
                list.add(ieparam);
            } while (retornoBase.moveToNext());
        }
        baseDados.close();
        return list;
    }
}
