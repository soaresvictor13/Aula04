package br.eti.victorsoares.aula04.View;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.eti.victorsoares.aula04.Controller.UsuarioController;
import br.eti.victorsoares.aula04.Model.Usuario;
import br.eti.victorsoares.aula04.R;


public class MainActivity extends ActionBarActivity {

    private String login;
    private String senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView cadastrar = (TextView) findViewById(R.id.cadastrar);
        cadastrar.setClickable(true);
        cadastrar.setFocusable(true);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(view.getContext(), CadastroUsuarios.class);
                startActivity(it);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    public void verificaSenha(View view){

        if(view != null){

            view = (View) view.getParent();
            EditText login = (EditText) view.findViewById(R.id.login);
            EditText senha = (EditText) view.findViewById(R.id.senha);
            String loginD = String.valueOf(login.getText());
            String senhaD = String.valueOf(senha.getText());

            UsuarioController usuarioController = new UsuarioController(this);
;
            Usuario usuario = usuarioController.login(this, loginD, senhaD);

            if(usuario != null){
                //criar outra activity
                Intent it = new Intent(this, SussessoActivity.class);
                it.putExtra("usuario", usuario);
                startActivity(it);

            }else{
                //cria activity de erro
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Erro!");
                builder.setMessage("Usuário ou senha inválidos!");
                builder.setCancelable(true);
                builder.setNegativeButton("Voltar", null);
                builder.create().show();
            }
        }

    }
}
