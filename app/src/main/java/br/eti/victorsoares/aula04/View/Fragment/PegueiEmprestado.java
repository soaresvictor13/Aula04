package br.eti.victorsoares.aula04.View.Fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import br.eti.victorsoares.aula04.Adapters.AdapterEmprestimos;
import br.eti.victorsoares.aula04.Adapters.AdapterItem;
import br.eti.victorsoares.aula04.Controller.EmprestimoController;
import br.eti.victorsoares.aula04.Model.Usuario;
import br.eti.victorsoares.aula04.R;

/**
 * Created by vsoares on 10/06/15.
 */
public class PegueiEmprestado extends Fragment {

    private Usuario usuario;
    private Bundle b;
    private View layout;
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
        layout = inflater.inflate(R.layout.fragment_peguei_emprestado, container, false);
        listView = (ListView) layout.findViewById(R.id.list);
        return layout;
    }

    @Override
    public void onResume() {
        super.onStart();
        if(layout != null & usuario != null){
            EmprestimoController emprestimoController = new EmprestimoController(layout.getContext());
            AdapterEmprestimos adapterEmprestimos = new AdapterEmprestimos(layout.getContext(), emprestimoController.getPegueiEmprestado(usuario));
            listView.setAdapter(adapterEmprestimos);
        }
    }
}
