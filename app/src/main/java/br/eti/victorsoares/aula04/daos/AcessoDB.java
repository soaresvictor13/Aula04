package br.eti.victorsoares.aula04.daos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import br.eti.victorsoares.aula04.daos.PessoaDAO;
import br.eti.victorsoares.aula04.daos.UsuarioDAO;

/**
 * Created by VictorSoares on 21/05/2015.
 */
public class AcessoDB extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 3;
	private static final String DATABASE_NAME = "trabalhoCM";
	
	
	
	public AcessoDB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.v("AcessoDB", "Criando o banco de dados V1");
        //Criando tabelas

        db.execSQL(UsuarioDAO.SCRIPT_CREATE);
        db.execSQL(PessoaDAO.SCRIPT_CREATE);
        db.execSQL(CategoriaDAO.SCRIPT_CREATE);
        db.execSQL(ItemDAO.SCRIPT_CREATE);
        db.execSQL(AmizadeDAO.SCRIPT_CREATE);
        //fim criação de tabelas

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int versaoAnterior, int versaoRecente) {
		Log.v("AcessoDB", "Estou atualizando banco de dados :)");


//        db.execSQL("DELETE FROM historico_comandos");

        if(versaoAnterior == 1 && versaoRecente == 2){
            db.execSQL(CategoriaDAO.SCRIPT_CREATE);
            db.execSQL(ItemDAO.SCRIPT_CREATE);
        }else if(versaoAnterior == 2 && versaoRecente == 3) {
            db.execSQL(AmizadeDAO.SCRIPT_CREATE);
        }else if(versaoAnterior == 3 && versaoRecente == 4){

        }


	}

}
