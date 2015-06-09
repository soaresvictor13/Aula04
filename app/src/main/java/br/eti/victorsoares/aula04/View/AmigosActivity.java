package br.eti.victorsoares.aula04.View;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import br.eti.victorsoares.aula04.Adapters.AdapterAmigos;
import br.eti.victorsoares.aula04.Controller.UsuarioController;
import br.eti.victorsoares.aula04.Model.Usuario;
import br.eti.victorsoares.aula04.R;

public class AmigosActivity extends Activity{

    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amigos);

        usuario = (Usuario) getIntent().getSerializableExtra("usuario");



    }

    @Override
    protected void onResume() {
        super.onResume();

        ListView lista = (ListView) findViewById(R.id.list);

        AdapterAmigos adapterAmigos = new AdapterAmigos(this, new UsuarioController(this).getFriends(usuario));
        lista.setAdapter(adapterAmigos);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    public void novoAmigo(View view){
        Intent intent = new Intent(view.getContext(), NovoAmigoActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }
}
