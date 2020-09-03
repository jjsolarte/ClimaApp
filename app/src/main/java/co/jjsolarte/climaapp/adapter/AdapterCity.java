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

public class AdapterCity extends RecyclerView.Adapter<AdapterCity.AdapterViewHolder> {
        /*
    1. Creación de Parámetros a Recibir
    2. Creación del Constructor
    3. Creación de la clase AdapterViewHolder de Optimización
    4. Extender de la clase ReciclerView.Adapter<Adapter.AdapterViewHolder>
*/
    private List<City> listaDatos;      //Lista a mostrar
    private int resource;               //Layout plantilla que modela la info
    private Activity context;           //Contexto o Activity dónde se implementará

    public AdapterCity(List<City> listaDatos, int resource, Activity context) {
        this.listaDatos = listaDatos;
        this.resource = resource;
        this.context = context;
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView titulo;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.itemCityImg);
            this.titulo = itemView.findViewById(R.id.itemCityTxt);
        }
    }

    @NonNull
    @Override   //Método que infla el recurso xml
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(resource, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override   //Le pasamos a los widgets por medio del holder la info de la lista
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        City city = listaDatos.get(position);
        holder.titulo.setText(city.getTitle());
        //Pasar la img de cada city
        //Podemos usar Picasso
    }

    @Override   //Verificar las veces que hace el procedimiento
    public int getItemCount() {
        return listaDatos.size();
    }

}
