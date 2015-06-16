package br.eti.victorsoares.aula04.Controller;

import android.content.Context;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.Model.Emprestimo;
import br.eti.victorsoares.aula04.Model.Usuario;

/**
 * Created by vsoares on 10/06/15.
 */
public class EmprestimoController {

    Context context;

    public EmprestimoController(Context context) {
        this.context = context;
    }

    public ArrayList<Object> getPegueiEmprestado(Usuario usuario) {
        return null;
    }

    public ArrayList<Object> getEmprestei(Usuario usuario) {
        return null;
    }

    public static void insertPegueiEmprestado(Emprestimo novoEmprestimo) {
    }

    public static void insertEmprestei(Emprestimo novoEmprestimo) {
    }
}
