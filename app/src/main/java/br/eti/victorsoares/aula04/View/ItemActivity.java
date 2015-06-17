package br.eti.victorsoares.aula04.View;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import br.eti.victorsoares.aula04.Adapters.AdapterItem;
import br.eti.victorsoares.aula04.Controller.ItemController;
import br.eti.victorsoares.aula04.Model.Item;
import br.eti.victorsoares.aula04.Model.Pessoa;
import br.eti.victorsoares.aula04.Model.Usuario;
import br.eti.victorsoares.aula04.daos.ItemDAO;
import br.eti.victorsoares.aula04.R;

public class ItemActivity extends Activity {

    private Usuario usuario;
    private boolean amigos;

    private ListView listView;
    protected Item itemSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        amigos = getIntent().getExtras().getBoolean("amigo");

        usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        listView = (ListView) findViewById(R.id.listViewItem);

        if(amigos){
            listView.setAdapter(new AdapterItem(new ItemController(this).getItensAmigos(usuario), this));
        }
        else{
            listView.setAdapter(new AdapterItem(new ItemController(this).getMeusItens(usuario), this));
        }

        registerForContextMenu(listView);

        Button novo = (Button) findViewById(R.id.btnNovoItem);
        novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Activity novo item.

                if(amigos) {
                    Intent intent = new Intent(view.getContext(), CadastroItemActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("usuario", usuario);
                    bundle.putBoolean("amigo", true);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else{

                    Intent intent = new Intent(view.getContext(), CadastroItemActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("usuario", usuario);
                    bundle.putBoolean("amigo", false);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                
            }
        });


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater mf = getMenuInflater();
        mf.inflate(R.menu.context_menu_amigo, menu);

        ListView listView1 = (ListView) v;
        AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) menuInfo;
        itemSelecionado = (Item) listView1.getItemAtPosition(acmi.position);
//        Toast.makeText(getBaseContext(), "clicou editar:" + i.getDescricao(), Toast.LENGTH_SHORT).show();

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

//        AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
//        Item i = (Item) listView1.getItemAtPosition(acmi.position);

        switch (item.getItemId()){
            case R.id.editar:
                  editar();
                return true;
            case R.id.apagar:
                apagar();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void editar(){

        if(itemSelecionado != null){
            Intent intent = new Intent(this, EditarItemActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("item", itemSelecionado);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
    public void apagar(){

        if(itemSelecionado != null){

            ItemController itemController = new ItemController(this);
            if(amigos){
                itemController.deletarItemDeAmigo(itemSelecionado);
                Toast.makeText(this, "Item apagado com sucesso!", Toast.LENGTH_SHORT).show();
                recreate();

            }else{
                itemController.deletarMeuItem(itemSelecionado);
                Toast.makeText(this, "Item apagado com sucesso!", Toast.LENGTH_SHORT).show();
                recreate();
            }
            itemSelecionado = null;
        }
    }

}
