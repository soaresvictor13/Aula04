package br.eti.victorsoares.aula04.Controller;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.eti.victorsoares.aula04.Model.Amigo;
import br.eti.victorsoares.aula04.Model.Item;
import br.eti.victorsoares.aula04.Model.Pessoa;
import br.eti.victorsoares.aula04.Model.Usuario;
import br.eti.victorsoares.aula04.daos.ItemDAO;
import br.eti.victorsoares.aula04.smldao.ItensDAO;

/**
 * Created by vsoares on 01/06/15.
 */
public class ItemController {

    private Context context;
    private ItensDAO itemDAO;

    public ItemController(Context context) {
        this.context = context;
        this.itemDAO  = new ItensDAO(context);
    }

    public ArrayList<Item> getList(Amigo amigo){

//        ArrayList<Object> list = new ArrayList<>();
//        list.add(getItem(1));
//        return list;
        return null;
    }

    public Item getItem(long id) {
//        Item item = new Item();
//        item.setDescricao("teste");
//        return item;
        return itemDAO.getItem(id);
    }

    public void insert(Item item, Usuario usuario) {
        itemDAO.insert(item);
    }

    public void insert(Item item, Usuario usuario, Amigo amigo) {

    }

    public ArrayList getItensAmigos(Usuario usuario) {
        return itemDAO.get();
    }
    public ArrayList getItensAmigos(Usuario usuario, Amigo amigo) {
        return new ArrayList<>();
    }

    public ArrayList<Item> getMeusItens(Usuario usuario) {
        return new ArrayList<>();
    }
}
