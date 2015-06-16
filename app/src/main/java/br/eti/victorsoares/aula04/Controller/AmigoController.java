package br.eti.victorsoares.aula04.Controller;

import android.content.Context;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.Model.Usuario;

/**
 * Created by vsoares on 16/06/15.
 */
public class AmigoController {

    Context context;

    public AmigoController(Context context) {
        this.context = context;
    }

    public ArrayList getAmigos(Usuario usuario) {
        return new ArrayList();
    }
}
