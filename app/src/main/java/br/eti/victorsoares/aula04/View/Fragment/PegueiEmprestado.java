package br.eti.victorsoares.aula04.View.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.eti.victorsoares.aula04.Adapters.AdapterAmigos;
import br.eti.victorsoares.aula04.Adapters.AdapterEmprestimos;
import br.eti.victorsoares.aula04.Adapters.AdapterItem;
import br.eti.victorsoares.aula04.Controller.AmigoController;
import br.eti.victorsoares.aula04.Controller.EmprestimoController;
import br.eti.victorsoares.aula04.Controller.ItemController;
import br.eti.victorsoares.aula04.Model.Amigo;
import br.eti.victorsoares.aula04.Model.Emprestimo;
import br.eti.victorsoares.aula04.Model.Item;
import br.eti.victorsoares.aula04.Model.Usuario;
import br.eti.victorsoares.aula04.R;

/**
 * Created by vsoares on 10/06/15.
 */
public class PegueiEmprestado extends Fragment {

    private Usuario usuario;
    private Bundle b;
    private View view;
    private TextView textView;
    private ListView listView;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param args Parameter 1.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PegueiEmprestado newInstance(Bundle args) {
        PegueiEmprestado fragment = new PegueiEmprestado();
        fragment.setArguments(args);
        return fragment;
    }

    public PegueiEmprestado() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            b = getArguments();
            usuario = (Usuario) b.getSerializable("usuario");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_peguei_emprestado, container, false);
        listView = (ListView) view.findViewById(R.id.list);


        Button novo = (Button) view.findViewById(R.id.btnNovoEmprestimo);
        novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DEBUG", "Clicou");
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Novo Emprestimo");
                LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View v = inflater.inflate(R.layout.alert_emprestimo,null);
                builder.setView(v);


                final Spinner meusAmigos = (Spinner) v.findViewById(R.id.meusAmigos);
                final Spinner itens = (Spinner) v.findViewById(R.id.itens);

                AmigoController controller = new AmigoController(view.getContext());
                ArrayList listaAmigos = new ArrayList();
                listaAmigos = controller.getAmigos(usuario);
                if(listaAmigos != null)meusAmigos.setAdapter(new AdapterAmigos(view.getContext(), listaAmigos));

                meusAmigos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        ItemController itemController = new ItemController(view.getContext());
                        ArrayList<Item> listaItens = itemController.getItensAmigos(usuario, (Amigo) meusAmigos.getAdapter().getItem(meusAmigos.getSelectedItemPosition()));
                        itens.setAdapter(new AdapterItem(listaItens, view.getContext()));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });


                final ListView itensSelecionados = (ListView) v.findViewById(R.id.list_itens_selecionados);

                final ArrayList<Item> listaItensSelecionados = new ArrayList();
                itens.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if(i != 0) {
                            Item item1 = (Item) itens.getAdapter().getItem(i);

                            if(!listaItensSelecionados.contains(item1)) {
                                listaItensSelecionados.add((Item) itens.getAdapter().getItem(i));
                                ((AdapterItem) itensSelecionados.getAdapter()).notifyDataSetChanged();
                                itens.setSelection(0);
                            }else{
                                Toast.makeText(view.getContext(), "Item já foi selecionado.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });


                itensSelecionados.setAdapter(new AdapterItem(listaItensSelecionados, v.getContext()));



                builder.setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Emprestimo novoEmprestimo = new Emprestimo();

                        EmprestimoController.insertPegueiEmprestado(novoEmprestimo);

                    }
                });


                builder.setNegativeButton("Cancelar", null);
                builder.create().show();
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onStart();
        if(view != null & usuario != null){
            EmprestimoController emprestimoController = new EmprestimoController(view.getContext());
            AdapterEmprestimos adapterEmprestimos = new AdapterEmprestimos(view.getContext(), emprestimoController.getPegueiEmprestado(usuario));
            listView.setAdapter(adapterEmprestimos);
        }
    }
}
