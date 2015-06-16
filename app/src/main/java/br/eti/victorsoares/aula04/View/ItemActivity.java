package br.eti.victorsoares.aula04.View;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import br.eti.victorsoares.aula04.Adapters.AdapterItem;
import br.eti.victorsoares.aula04.Controller.ItemController;
import br.eti.victorsoares.aula04.Model.Pessoa;
import br.eti.victorsoares.aula04.Model.Usuario;
import br.eti.victorsoares.aula04.daos.ItemDAO;
import br.eti.victorsoares.aula04.R;

public class ItemActivity extends Activity {

    private Usuario usuario;
    private boolean amigos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        amigos = getIntent().getExtras().getBoolean("amigo");

        usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        ListView listView = (ListView) findViewById(R.id.listViewItem);

        if(amigos){
            listView.setAdapter(new AdapterItem(new ItemController(this).getItensAmigos(usuario), this));
        }
        else{
            listView.setAdapter(new AdapterItem(new ItemController(this).getMeusItens(usuario), this));
        }

        Button novo = (Button) findViewById(R.id.btnNovoItem);
        novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Activity novo item.

                if(amigos) {
                    Intent intent = new Intent(view.getContext(), CadastroItemActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("amigo", true);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else{

                    Intent intent = new Intent(view.getContext(), CadastroItemActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("amigo", false);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
