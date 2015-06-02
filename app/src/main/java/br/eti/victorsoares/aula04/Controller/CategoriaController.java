package br.eti.victorsoares.aula04.Controller;

import android.content.Context;
import java.util.List;
import br.eti.victorsoares.aula04.Model.Categoria;
import br.eti.victorsoares.aula04.daos.CategoriaDAO;

/**
 * Created by vsoares on 01/06/15.
 */
public class CategoriaController {

    private CategoriaDAO categoriaDAO;
    private Context context;

    public CategoriaController(Context context) {
        this.context = context;
        categoriaDAO = new CategoriaDAO(context);
    }

    public void salvar(Categoria categoria){
        categoriaDAO.insert(categoria);
    }

    public List getList(){
        return categoriaDAO.getList();
    }

    public void apagar(Categoria categoria){
        categoriaDAO.delete(categoria);
    }
}
