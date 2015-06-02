//package br.eti.victorsoares.aula04.Controller.Adapters;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Color;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.google.android.gms.maps.MapFragment;
//
//import java.util.ArrayList;
//
//import br.eti.victorsoares.personalcarmonitor.Model.Veiculo;
//import br.eti.victorsoares.personalcarmonitor.Model.VeiculoDAO;
//import br.eti.victorsoares.personalcarmonitor.R;
//import br.eti.victorsoares.personalcarmonitor.View.EditarVeiculo;
//import br.eti.victorsoares.personalcarmonitor.View.MainActivity;
//import br.eti.victorsoares.personalcarmonitor.View.MapActivity;
//import br.eti.victorsoares.personalcarmonitor.View.VeiculosActivity;
//
///**
// * Created by VictorSoares on 03/01/2015.
// */
//public class VeiculoAdapter extends BaseAdapter{
//
//    Context context;
//    ArrayList<Veiculo> lstVeiculos;
//
//    public VeiculoAdapter(Context context, ArrayList<Veiculo> lista){
//        this.context = context;
//        this.lstVeiculos = lista;
//    }
//
//    @Override
//    public int getCount() {
//        return lstVeiculos.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return lstVeiculos.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        Veiculo v = (Veiculo) getItem(i);
//        return v.getId();
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//
//        final Veiculo v = (Veiculo) getItem(i);
//
//
//
//        layout.setFocusable(true);
//        layout.setClickable(true);
//        layout.setBackgroundResource(R.drawable.abc_item_background_holo_light);
//
//        if(v.getIdRastreador() != -1){
//            ImageButton btnEditar = (ImageButton) layout.findViewById(R.id.btnEditarVeiculo);
//            btnEditar.setFocusable(false);
//            btnEditar.setBackgroundResource(R.drawable.abc_item_background_holo_light);
//            btnEditar.setVisibility(View.VISIBLE);
//            btnEditar.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    Intent it = new Intent(context, EditarVeiculo.class);
//                    it.putExtra("veiculo", v);
//                    context.startActivity(it);
//
//                }
//            });
//        }else {
//            ImageButton remover = (ImageButton) layout.findViewById(R.id.btnRemoverVeiculo);
//            remover.setBackgroundResource(R.drawable.abc_item_background_holo_light);
//            remover.setFocusable(false);
//            remover.setVisibility(View.VISIBLE);
//            remover.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    VeiculoDAO vd = new VeiculoDAO(layout.getContext());
//                    vd.delete(v);
//                }
//            });
//        }
//
//        TextView nomeVeiculo = (TextView) layout.findViewById(R.id.txtNomeVeiculo);
//        ImageView icone = (ImageView) layout.findViewById(R.id.imgIcone);
//        icone.setImageResource(R.drawable.ic_veiculo);
//        icone.setClickable(false);
//
//        nomeVeiculo.setText(v.getDescricao());
//        nomeVeiculo.setClickable(false);
//
//        layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), MapActivity.class);
//                intent.putExtra("veiculo", v);
//                context.startActivity(intent);
//            }
//        });
//
//        return layout;
//    }
//}
