package br.eti.victorsoares.aula04.View;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.eti.victorsoares.aula04.Controller.AmigoController;
import br.eti.victorsoares.aula04.Controller.UsuarioController;
import br.eti.victorsoares.aula04.Model.Amigo;
import br.eti.victorsoares.aula04.Model.Pessoa;
import br.eti.victorsoares.aula04.Model.Usuario;
import br.eti.victorsoares.aula04.R;

public class NovoAmigoActivity extends Activity{

    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_amigo);

        usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        final EditText nome = (EditText) findViewById(R.id.nome);
        final EditText email = (EditText) findViewById(R.id.email);


        Button btn = (Button) findViewById(R.id.salvar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Amigo p = new Amigo();
                p.setNome(nome.getText().toString());
                p.setImagem(email.getText().toString());

                AmigoController amigoController = new AmigoController(view.getContext());
                amigoController.insert(p);
                Toast.makeText(view.getContext(), "Novo amigo salvo com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });



    }

}
