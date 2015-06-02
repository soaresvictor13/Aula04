package br.eti.victorsoares.aula04.View;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.eti.victorsoares.aula04.Model.Usuario;
import br.eti.victorsoares.aula04.R;


public class SussessoActivity extends Activity {

    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sussesso);

        usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        TextView msg = (TextView) findViewById(R.id.textMessage);
        msg.setText("Bem vindo "+ usuario.getUsuario() + "!");

        Button meusItens = (Button) findViewById(R.id.meusItens);
        meusItens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(view.getContext(), ItemActivity.class);
                it.putExtra("usuario", usuario);
                startActivity(it);
            }
        });
        Button categorias = (Button) findViewById(R.id.categorias);
        categorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(view.getContext(), CategoriaActivity.class);
                startActivity(it);
            }
        });
        Button amigos = (Button) findViewById(R.id.meusAmigos);
        amigos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(view.getContext(), AmigosActivity.class);
                it.putExtra("usuario", usuario);
                startActivity(it);
            }
        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sussesso, menu);
        return true;
    }

    public void sair(final View view){

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Logoff");
        builder.setMessage("Deseja realmente sair? =(");
        builder.setCancelable(true);
        builder.setNegativeButton("Não", null);
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(view.getContext(), "Tchau, Bobo! =(", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        builder.create().show();
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



    @Override
    public void onBackPressed() {
        sair(new View(getApplicationContext()));
    }
}
