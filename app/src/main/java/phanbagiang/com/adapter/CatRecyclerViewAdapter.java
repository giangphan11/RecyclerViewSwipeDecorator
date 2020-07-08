package phanbagiang.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import phanbagiang.com.model.Cat;
import phanbagiang.com.recyclerview222.R;

public class CatRecyclerViewAdapter extends RecyclerView.Adapter<CatRecyclerViewAdapter.CatHolder> {
    Context context;
    ArrayList<Cat>dsCat;
    int resource;
    IRecyclerViewClick iRecyclerViewClick;

    public CatRecyclerViewAdapter(Context context, ArrayList<Cat> dsCat, int resource,IRecyclerViewClick iRecyclerViewClick) {
        this.context = context;
        this.dsCat = dsCat;
        this.resource = resource;
        this.iRecyclerViewClick=iRecyclerViewClick;
    }

    @NonNull
    @Override
    public CatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(this.context);
        View customView= inflater.inflate(this.resource,parent,false);
        return new CatHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull CatHolder holder, int position) {
        Cat cat=dsCat.get(position);
        holder.imgHinh.setImageResource(cat.getHinh());
        holder.txtTen.setText(cat.getTen());
        holder.txtGia.setText(cat.getGia());
    }

    @Override
    public int getItemCount() {
        return dsCat.size();
    }

    public class CatHolder extends RecyclerView.ViewHolder {
        ImageView imgHinh;
        TextView txtTen;
        TextView txtGia;

        public CatHolder(@NonNull View itemView) {
            super(itemView);
            imgHinh=itemView.findViewById(R.id.imgHinh);
            txtTen=itemView.findViewById(R.id.txtTen);
            txtGia=itemView.findViewById(R.id.txtGia);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iRecyclerViewClick.onItemClick(getAdapterPosition());
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    iRecyclerViewClick.onItemLongClick(getAdapterPosition());
                    return true;
                }
            });
        }
    }
}
