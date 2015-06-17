package br.eti.victorsoares.aula04.smldao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import br.eti.victorsoares.aula04.Model.ItensAmigos;
import br.eti.victorsoares.aula04.daos.*;

/**
 * Created by VictorSoares on 21/05/2015.
 */
public class AcessoDB extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 4;
	private static final String DATABASE_NAME = "trabalhoCM";
	
	
	
	public AcessoDB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.v("AcessoDB", "Criando o banco de dados V1");
        //Criando tabelas

        db.execSQL(UsuarioDAO.SCRIPT_CREATE);
        db.execSQL(AmigosDAO.SCRIPT_CREATE);

        //fim criação de tabelas

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int versaoAnterior, int versaoRecente) {
		Log.v("AcessoDB", "Estou atualizando banco de dados :)");

        db.execSQL(ItensAmigoDAO.SCRIPT_CREATE);
        db.execSQL(ItensDAO.SCRIPT_CREATE);
        db.execSQL(CategoriaDAO.SCRIPT_CREATE);
        db.execSQL(ItensEmprestadosPorMinDAO.SCRIPT_CREATE);
        db.execSQL(ItensEmprestadosParaMinDAO.SCRIPT_CREATE);

	}

}
