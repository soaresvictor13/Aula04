package br.eti.victorsoares.aula04.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import br.eti.victorsoares.aula04.Controller.ItemController;
import br.eti.victorsoares.aula04.Model.Item;
import br.eti.victorsoares.aula04.R;

/**
 * Created by vsoares on 26/05/15.
 */
public class AdapterItem extends BaseAdapter{

    private List list;
    private Context context;

    public AdapterItem(List list, Context context) {
        this.list = list;
        this.context = context;
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
        Item item = (Item) getItem(i);
        return item.getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View layout;

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = inflater.inflate(R.layout.adapter_item, null);
        }else {
            layout = view;
        }

        TextView text = (TextView) layout.findViewById(R.id.text); // recupera TextView do layout inflado.
        Button apagar = (Button) layout.findViewById(R.id.apagar); // recupera TextView do layout inflado.
        Button editar = (Button) layout.findViewById(R.id.editar); // recupera TextView do layout inflado.
        apagar.setVisibility(View.GONE);
        editar.setVisibility(View.GONE);

        Item item = (Item) getItem(i);

        text.setText(item.getDescricao());
//
//        apagar.setClickable(true);
//        apagar.setFocusable(true);
//        apagar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(layout.getContext(), "clicou apagar", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        editar.setClickable(true);
//        editar.setFocusable(true);
//        editar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(layout.getContext(), "clicou editar", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        layout.setClickable(true);
//        layout.setFocusable(true);
//        layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(layout.getContext(), "clicou item", Toast.LENGTH_SHORT).show();
//            }
//        });


        return layout;
    }
}
