package br.eti.victorsoares.aula04.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.eti.victorsoares.aula04.Model.Amigo;
import br.eti.victorsoares.aula04.Model.Pessoa;
import br.eti.victorsoares.aula04.R;

/**
 * Created by vsoares on 08/06/15.
 */
public class AdapterAmigos extends BaseAdapter{
    Context context;
    List list;

    public AdapterAmigos(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        Amigo p = (Amigo) getItem(i);
        return p.getCod_amigo();
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

        Amigo p = (Amigo) getItem(i);

        TextView nome = (TextView) layout.findViewById(R.id.text);

        nome.setText(p.getNome());

        return layout;
    }
}
