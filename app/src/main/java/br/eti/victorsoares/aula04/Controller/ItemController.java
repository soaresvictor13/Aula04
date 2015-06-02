package br.eti.victorsoares.aula04.Controller;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.eti.victorsoares.aula04.Model.Item;
import br.eti.victorsoares.aula04.Model.Pessoa;
import br.eti.victorsoares.aula04.daos.ItemDAO;

/**
 * Created by vsoares on 01/06/15.
 */
public class ItemController {

    private Context context;
    private ItemDAO itemDAO;

    public ItemController(Context context) {
        this.context = context;
        this.itemDAO  = new ItemDAO(context);
    }

    public List getList(){

//        ArrayList<Object> list = new ArrayList<>();
//        list.add(getItem(1));
//        return list;
        return itemDAO.getList();
    }

    public List getList(Pessoa pessoa){
        return itemDAO.getList(pessoa.getId());
    }

    public Item getItem(long id) {
//        Item item = new Item();
//        item.setDescricao("teste");
//        return item;
        return itemDAO.getItem(id);
    }
}
