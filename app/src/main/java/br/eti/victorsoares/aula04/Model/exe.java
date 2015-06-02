package br.eti.victorsoares.aula04.Model;//package br.eti.victorsoares.personalcarmonitor.Model;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.util.Log;
//
//import java.util.ArrayList;
//
///**
// * Created by VictorSoares on 02/01/2015.
// */
//public class AlertaDAO implements DAO{
//
//    protected static final String SCRIPT_CREATE = "CREATE TABLE alerta(" +
//            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            "id_rastreador INTEGER, " +
//            "alerta TEXT, " +
//            "descricao TEXT, " +
//            "FOREIGN KEY(id_rastreador) REFERENCES rastreador(_id)" +
//            ");";
//
//    AcessoDB acessoDB;
//
//
//    public AlertaDAO(Context ctx) {
//        acessoDB = new AcessoDB(ctx);
//    }
//
//    @Override
//    public void insert(Object obj) {
//
//        Alerta a = (Alerta) obj;
//        Log.i("AlertaDAO", "Inserindo registro no banco!");
//        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
//        ContentValues valoresInserir = new ContentValues();
//        valoresInserir.put("alerta", a.getAlerta());
//        valoresInserir.put("descricao", a.getDescricao());
//        long novoId = baseDados.insert("alerta", null, valoresInserir);
//        a.setId(novoId);
//        baseDados.close();
//    }
//
//    @Override
//    public ArrayList<Object> getList() {
//
//        ArrayList<Object> list = new ArrayList<Object>();
//        Log.i("AlertaDAO","Selecionando registros no banco.");
//        SQLiteDatabase baseDados = acessoDB.getReadableDatabase();
//        String query = "SELECT * FROM alerta";
//        Cursor retornoBase = baseDados.rawQuery(query, null);
//
//        if(retornoBase.moveToFirst()) {
//            do {
//                //Recuperando valores e add a lista.
//                Alerta a = new Alerta();
//                a.setId(retornoBase.getLong(retornoBase.getColumnIndex("_id")));
//                a.setAlerta(retornoBase.getString((retornoBase.getColumnIndex("alerta"))));
//                a.setDescricao(retornoBase.getString(retornoBase.getColumnIndex("descricao")));
//                a.setIdRastreador(retornoBase.getLong(retornoBase.getColumnIndex("id_rastreador")));
//                list.add(a);
//            } while (retornoBase.moveToNext());
//        }
//        baseDados.close();
//        return list;
//    }
//
//    @Override
//    public Object get(long id) {
//
//        SQLiteDatabase baseDados = acessoDB.getReadableDatabase();
//        String query = "SELECT * FROM alerta WHERE _id=?";
//        Cursor c = baseDados.rawQuery(query, new String[] { String.valueOf(id) });
//
//        if(c.moveToFirst()) {
//            Alerta a = new Alerta();
//            a.setId(c.getLong(c.getColumnIndex("_id")));
//            a.setAlerta(c.getString((c.getColumnIndex("alerta"))));
//            a.setDescricao(c.getString(c.getColumnIndex("descricao")));
//            a.setIdRastreador(c.getLong(c.getColumnIndex("id_rastreador")));
//            baseDados.close();
//            return a;
//        } else {
//            Log.v("AlertaDAO", "ID não encontrado.");
//            baseDados.close();
//            return null;
//        }
//    }
//
//    @Override
//    public void update(Object obj) {
//
//        Alerta a = (Alerta) obj;
//        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put("alerta", a.getAlerta());
//        cv.put("descricao", a.getDescricao());
//        baseDados.update("alerta", cv, "_id =" + a.getId(), null);
//
//    }
//
//    @Override
//    public void delete(Object obj) {
//        Alerta a = (Alerta) obj;
//        Log.v("AlertaDAO", "Apagando registro no banco!");
//        SQLiteDatabase baseDados = acessoDB.getWritableDatabase();
//        baseDados.delete("alerta", "_id =" + a.getId(), null);
//        baseDados.close();
//    }
//}
