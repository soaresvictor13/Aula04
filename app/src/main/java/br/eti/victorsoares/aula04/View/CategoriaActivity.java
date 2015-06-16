package br.eti.victorsoares.aula04.View;

import android.app.Activity;
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

public class CategoriaActivity extends Activity {

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
                    editText.setText("");
                    editText.clearFocus();
                }
            }
        });


    }

}
