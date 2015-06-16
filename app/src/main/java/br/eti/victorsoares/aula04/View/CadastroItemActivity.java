package br.eti.victorsoares.aula04.View;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.eti.victorsoares.aula04.Adapters.AdapterAmigos;
import br.eti.victorsoares.aula04.Adapters.AdapterCategoria;
import br.eti.victorsoares.aula04.Adapters.AdapterCategoriaView;
import br.eti.victorsoares.aula04.Controller.AmigoController;
import br.eti.victorsoares.aula04.Controller.CategoriaController;
import br.eti.victorsoares.aula04.Controller.ItemController;
import br.eti.victorsoares.aula04.Model.Amigo;
import br.eti.victorsoares.aula04.Model.Categoria;
import br.eti.victorsoares.aula04.Model.Item;
import br.eti.victorsoares.aula04.Model.Usuario;
import br.eti.victorsoares.aula04.R;

public class CadastroItemActivity extends Activity {

    private Usuario usuario;
    private Amigo amigo;
    private boolean amigos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_item);

        usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        amigos = getIntent().getExtras().getBoolean("amigo");

        if(amigos){
            final Spinner spinnerAmigos = (Spinner) findViewById(R.id.meusAmigos);

            spinnerAmigos.setVisibility(View.VISIBLE);
            spinnerAmigos.setAdapter(new AdapterAmigos(getBaseContext(), new AmigoController(getBaseContext()).getAmigos(usuario)));
            spinnerAmigos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    amigo = (Amigo) spinnerAmigos.getAdapter().getItem(spinnerAmigos.getSelectedItemPosition());
                    spinnerAmigos.setSelected(false);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

        final Spinner spinner = (Spinner) findViewById(R.id.spiner);
        spinner.setAdapter(new AdapterCategoriaView(new CategoriaController(this).getList(), this));

        Button salvar = (Button) findViewById(R.id.salvar);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText descricao =(EditText) findViewById(R.id.descricao);

                if(descricao.getText().length() > 0) {
                    Item item = new Item();
                    item.setDescricao(descricao.getText().toString());
                    item.setCategoria((Categoria) spinner.getAdapter().getItem(spinner.getSelectedItemPosition()));

                    ItemController controller = new ItemController(view.getContext());
                    controller.insert(item, usuario);
                    if(amigo != null){
                        controller.insert(item, usuario, amigo);
                    }
                    Toast.makeText(view.getContext(), "Item cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(view.getContext(), "Digite uma descrição do item", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
