package br.eti.victorsoares.aula04.Controller;

import android.content.Context;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.Model.Amigo;
import br.eti.victorsoares.aula04.Model.Usuario;
import br.eti.victorsoares.aula04.smldao.AmigosDAO;

/**
 * Created by vsoares on 16/06/15.
 */
public class AmigoController {

    private Context context;
    private AmigosDAO adao;

    public AmigoController(Context context) {
        this.context = context;
        this.adao = new AmigosDAO(context);
    }

    public void insert(Amigo amigo){
        this.adao.insert(amigo);
    }

    public void insert(Amigo amigo , Usuario usuario){
        amigo.setCod_usuario(usuario.getId());
        this.adao.insert(amigo);
    }

    public ArrayList getAmigos(Usuario usuario) {
        return this.adao.getAmigos(usuario);
    }
}
