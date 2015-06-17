package br.eti.victorsoares.aula04.Controller;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.eti.victorsoares.aula04.Model.Amigo;
import br.eti.victorsoares.aula04.Model.Item;
import br.eti.victorsoares.aula04.Model.ItensAmigos;
import br.eti.victorsoares.aula04.Model.Pessoa;
import br.eti.victorsoares.aula04.Model.Usuario;
import br.eti.victorsoares.aula04.daos.ItemDAO;
import br.eti.victorsoares.aula04.smldao.ItensAmigoDAO;
import br.eti.victorsoares.aula04.smldao.ItensDAO;

/**
 * Created by vsoares on 01/06/15.
 */
public class ItemController {

    private Context context;
    private ItensDAO itemDAO;
    private ItensAmigoDAO itensAmigoDAO;

    public ItemController(Context context) {
        this.context = context;
        this.itemDAO  = new ItensDAO(context);
        this.itensAmigoDAO = new ItensAmigoDAO(context);
    }

    public Item getItem(long id) {
        return itemDAO.getItem(id);
    }
    //insere meus itens
    public void insert(Item item, Usuario usuario) {
        itemDAO.insert(item);
    }

    //insere itens de amigos
    public void insert(Item item, Usuario usuario, Amigo amigo) {

        ItensAmigos itensAmigos = new ItensAmigos();
        itensAmigos.setCod_item(item.getId());
        itensAmigos.setDescricao_item(item.getDescricao());
        itensAmigos.setCod_amigo(amigo.getCod_amigo());
        itensAmigoDAO.insert(itensAmigos);

    }

    //retorna itens de todos os amigos
    public ArrayList getItensAmigos(Usuario usuario) {
        ArrayList<Item> lista = new ArrayList<>();
        for(Object o :itensAmigoDAO.get()){
            ItensAmigos i =(ItensAmigos) o;
            Item i2 = new Item();
            i2.setId(i.getCod_item());
            i2.setNome(i.getNome_item());
            i2.setDescricao(i.getDescricao_item());
            lista.add(i2);
        }
        return lista;
    }

    //retorna itens de um amigo
    public ArrayList<Item> getItensAmigos(Usuario usuario, Amigo amigo) {
        ArrayList<Item> lista = new ArrayList<>();
        for(Object o :itensAmigoDAO.get()){
            ItensAmigos i =(ItensAmigos) o;
            Item i2 = new Item();
            i2.setId(i.getCod_item());
            i2.setNome(i.getNome_item());
            lista.add(i2);
        }
        return lista;
    }

    //retorna meus itens
    public ArrayList<Item> getMeusItens(Usuario usuario) {
        ArrayList<Item> lista = new ArrayList<>();
        for(Object o :itemDAO.get()){
            lista.add((Item) o);
        }
        return lista;
    }

    public void deletarMeuItem(Item itemSelecionado) {
        itemDAO.delete(itemSelecionado);
    }

    public void deletarItemDeAmigo(Item itemSelecionado) {

    }
}
