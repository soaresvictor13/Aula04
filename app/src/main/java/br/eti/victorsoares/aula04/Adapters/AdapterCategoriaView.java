package br.eti.victorsoares.aula04.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import br.eti.victorsoares.aula04.Controller.CategoriaController;
import br.eti.victorsoares.aula04.Model.Categoria;
import br.eti.victorsoares.aula04.R;

/**
 * Created by vsoares on 01/06/15.
 */
public class AdapterCategoriaView extends BaseAdapter {

    private List list;
    private Context context;

    public AdapterCategoriaView(List list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void add(Categoria categoria){
        list.add(categoria);
        AdapterCategoriaView.this.notifyDataSetChanged();
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
        Categoria c = (Categoria) getItem(i);
        return c.getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View layout;

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = inflater.inflate(R.layout.adapter_categoria, null);
        }else {
            layout = view;
        }

        final Categoria categoria = ((Categoria) getItem(i));

        TextView label = (TextView) layout.findViewById(R.id.label);
        label.setText(categoria.getDescricao());

        Button apagar = (Button) layout.findViewById(R.id.apagar);
        apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CategoriaController(layout.getContext()).apagar(categoria);
                list.remove(categoria);
                AdapterCategoriaView.this.notifyDataSetChanged();
            }
        });

        apagar.setVisibility(View.GONE);

        return layout;
    }
}
