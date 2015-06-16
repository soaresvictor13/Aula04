package br.eti.victorsoares.aula04.View;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;

import br.eti.victorsoares.aula04.Adapters.AdapterCategoria;
import br.eti.victorsoares.aula04.Controller.CategoriaController;
import br.eti.victorsoares.aula04.R;

public class CadastroItemActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_item);

        Spinner spinner = (Spinner) findViewById(R.id.spiner);
        spinner.setAdapter(new AdapterCategoria(new CategoriaController(this).getList(), this));
    }

}
