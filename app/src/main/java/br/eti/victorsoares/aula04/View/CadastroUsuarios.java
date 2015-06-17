package br.eti.victorsoares.aula04.View;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.eti.victorsoares.aula04.Controller.UsuarioController;
import br.eti.victorsoares.aula04.Model.Usuario;
import br.eti.victorsoares.aula04.R;

public class CadastroUsuarios extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuarios);

        Button salvar = (Button) findViewById(R.id.salvar);

        final UsuarioController controller = new UsuarioController(this);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText usuario = (EditText) findViewById(R.id.usuario);
                EditText senha = (EditText) findViewById(R.id.senha);
                EditText confirmaSenha = (EditText) findViewById(R.id.confirmaSenha);
                EditText email = (EditText) findViewById(R.id.email);


                if(senha.getText().toString().equals(confirmaSenha.getText().toString()) & usuario.getText().length() > 0){

                    if(!controller.isUsuario(view.getContext(), usuario.getText().toString())) {
                        if(email.getText().toString().length() > 5){
                            Usuario u = new Usuario();
                            u.setUsuario(usuario.getText().toString());
                            u.setSenha(senha.getText().toString());
                            u.setEmail(email.getText().toString());
                            controller.insert(u);
                            Toast.makeText(view.getContext(), "Usuário salvo com sucesso!", Toast.LENGTH_SHORT).show();
                            CadastroUsuarios.this.finish();
                        }else{

                            AlertDialog.Builder alerta = new AlertDialog.Builder(view.getContext());
                            alerta.setTitle("Erro!");
                            alerta.setMessage("Email invalido!");
                            alerta.create().show();
                        }

                    }else{
                        AlertDialog.Builder alerta = new AlertDialog.Builder(view.getContext());
                        alerta.setTitle("Erro!");
                        alerta.setMessage("O Usuário já existe!\n Tente outro usuário.");
                        alerta.create().show();

                    }
                }else{
                    AlertDialog.Builder alerta = new AlertDialog.Builder(view.getContext());
                    alerta.setTitle("Erro!");
                    alerta.setMessage("As senhas digitadas são diferentes.");
                    alerta.create().show();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro_usuarios, menu);
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
