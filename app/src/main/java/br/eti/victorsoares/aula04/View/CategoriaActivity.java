package br.eti.victorsoares.aula04.View;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import br.eti.victorsoares.aula04.Adapters.AdapterCategoria;
import br.eti.victorsoares.aula04.Controller.CategoriaController;
import br.eti.victorsoares.aula04.Model.Categoria;
import br.eti.victorsoares.aula04.R;

public class CategoriaActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        final ListView listView = (ListView) findViewById(R.id.list);
        final AdapterCategoria adapterCategoria = new AdapterCategoria(new CategoriaController(this).getList(), this);
        listView.setAdapter(adapterCategoria);

        final EditText editText = (EditText) findViewById(R.id.novaCategoria);

        Button salvar = (Button) findViewById(R.id.salvar);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().length() > 0){
                    Categoria c = new Categoria();
                    c.setDescricao(editText.getText().toString());
                    new CategoriaController(view.getContext()).salvar(c);
                    adapterCategoria.add(c);
                }
            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_categoria, menu);
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
