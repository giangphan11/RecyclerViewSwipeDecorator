package phanbagiang.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import phanbagiang.com.model.Cat;
import phanbagiang.com.recyclerview222.R;

public class CatAdapter extends ArrayAdapter<Cat> {
    Context context;
    int resource;

    public CatAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context=context;
        this.resource=resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(this.context);
        View customView=inflater.inflate(this.resource,null);

        Cat cat=getItem(position);
        ImageView imgHinh=customView.findViewById(R.id.imgHinh);
        TextView txtTen=customView.findViewById(R.id.txtTen);
        TextView txtGia= customView.findViewById(R.id.txtGia);

        imgHinh.setImageResource(cat.getHinh());
        txtTen.setText(cat.getTen());
        txtGia.setText(cat.getGia());

        return customView;
    }
}
