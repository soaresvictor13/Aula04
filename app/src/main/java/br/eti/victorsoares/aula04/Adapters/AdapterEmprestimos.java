package br.eti.victorsoares.aula04.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.eti.victorsoares.aula04.Model.Emprestimo;
import br.eti.victorsoares.aula04.Model.Pessoa;
import br.eti.victorsoares.aula04.R;

/**
 * Created by vsoares on 10/06/15.
 */
public class AdapterEmprestimos extends BaseAdapter {

    Context context;
    List lista;

    public AdapterEmprestimos(Context context, List lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View layout;

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = inflater.inflate(R.layout.adapter_generico, null);
        }else {
            layout = view;
        }

        Emprestimo emprestimo = (Emprestimo) getItem(i);

        TextView nome = (TextView) layout.findViewById(R.id.text);


        return layout;
    }
}
