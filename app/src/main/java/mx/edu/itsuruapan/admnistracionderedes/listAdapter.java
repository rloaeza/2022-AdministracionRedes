package mx.edu.itsuruapan.admnistracionderedes;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class listAdapter extends RecyclerView.Adapter<listAdapter.ViewHolder> {
    private List<ListaPlanes> planesList;
    private LayoutInflater inflater;
    private Context context;

    public listAdapter(List<ListaPlanes> planesLista, Context context){
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.planesList = planesLista;
    }

    @Override
    public int getItemCount(){return planesList.size();}

   @Override
   public listAdapter.ViewHolder  onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.list_pd, null);
        return new listAdapter.ViewHolder(view);
    }

    
    @Override
    public void onBindViewHolder(final listAdapter.ViewHolder holder, final int position){
        holder.binData(planesList.get(position));

    }

    public void setItems(List<ListaPlanes> items){
        planesList = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView nombre, descripcion;

                ViewHolder(View viewItem){
                    super(viewItem);
                    iconImage = viewItem.findViewById(R.id.icono);
                    nombre = viewItem.findViewById(R.id.nombreTextView);
                    descripcion = viewItem.findViewById(R.id.desc_plan);

                }

                void binData(final ListaPlanes item){
                    nombre.setText(item.getNombre_plan());
                    descripcion.setText(item.getDescripcion_plan());

                }
    }

}
