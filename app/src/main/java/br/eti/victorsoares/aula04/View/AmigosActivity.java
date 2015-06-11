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
import android.widget.ListView;
import android.widget.Toast;

import br.eti.victorsoares.aula04.Adapters.AdapterAmigos;
import br.eti.victorsoares.aula04.Controller.UsuarioController;
import br.eti.victorsoares.aula04.Model.Pessoa;
import br.eti.victorsoares.aula04.Model.Usuario;
import br.eti.victorsoares.aula04.R;

public class AmigosActivity extends Activity{

    private Usuario usuario;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amigos);

        usuario = (Usuario) getIntent().getSerializableExtra("usuario");

    }

    @Override
    protected void onResume() {
        super.onResume();

        lista = (ListView) findViewById(R.id.list);

        AdapterAmigos adapterAmigos = new AdapterAmigos(this, new UsuarioController(this).getFriends(usuario));
        lista.setAdapter(adapterAmigos);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        registerForContextMenu(lista);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mf = getMenuInflater();
        mf.inflate(R.menu.context_menu_amigo, menu);

        Toast.makeText(getApplicationContext(), "ID:", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        Pessoa pessoa = null;

        pessoa = (Pessoa) lista.getAdapter().getItem(lista.getSelectedItemPosition());

        switch (item.getItemId()){
            case R.id.editar:
                    editarAmigo(pessoa);
                return true;
            case R.id.apagar:
                    apagarAmigo(pessoa);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void apagarAmigo(Pessoa pessoa) {

        Toast.makeText(this, "apagar: "+pessoa.getNome(), Toast.LENGTH_SHORT).show();

        Log.e("teste", "teste");

    }

    private void editarAmigo(Pessoa pessoa) {

        Toast.makeText(this, "editar: "+pessoa.getNome(), Toast.LENGTH_SHORT).show();

        Log.e("teste", "teste");
    }

    public void novoAmigo(View view){
        Intent intent = new Intent(view.getContext(), NovoAmigoActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }


}
