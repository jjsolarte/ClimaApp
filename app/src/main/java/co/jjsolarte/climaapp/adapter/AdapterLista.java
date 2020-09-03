package co.jjsolarte.climaapp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.jjsolarte.climaapp.R;
import co.jjsolarte.climaapp.model.City;

public class AdapterLista extends RecyclerView.Adapter<AdapterLista.AdapterViewHolder> {
    /*
    1. Creación de Parámetros a Recibir
    2. Creación del Constructor
    3. Creación de la clase AdapterViewHolder de Optimización
    4. Recordar añadir implementation 'com.android.support:recyclerview-v7:28.0.0'
    5. Extender de la clase ReciclerView.Adapter<Adapter.AdapterViewHolder>
*/
    private List<City> listaDatos;          //lista de obj a utilizar
    private int resource;                   //Layout que modela la info
    private Activity context;               //Donde se implementa el Adapter

    public AdapterLista(List<City> listaDatos, int resource, Activity context) {
        this.listaDatos = listaDatos;
        this.resource = resource;
        this.context = context;
    }

    //Aqui definimos la organización de nuestra información
    //implementamos el método constructor
    public class AdapterViewHolder extends RecyclerView.ViewHolder{

        ImageView imagen1;
        ImageView imagen2;
        TextView título;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            //pasamos cada view a los views definidos en la vista item xml
            this.imagen1 = itemView.findViewById(R.id.itemImg1);
            this.imagen2 = itemView.findViewById(R.id.itemImg2);
            this.título = itemView.findViewById(R.id.itemTxt);
        }
    }


    @NonNull
    @Override //Método que infla el recurso xml
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(resource, parent,false);
        return new AdapterViewHolder(view);
    }

    @Override //Le pasamos a los view por medio del adapterviewholder la info de la lista
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        City city = listaDatos.get(position);
        holder.título.setText(city.getTitle());
        //Ponemos img a holder.imagen1
        //Ponemos img a holder.imagen2
    }

    @Override //Definimos cuantas veces debe hacer el proceso
    public int getItemCount() {
        return listaDatos.size();
    }
}
