package phanbagiang.com.recyclerview222;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import phanbagiang.com.adapter.CatAdapter;
import phanbagiang.com.model.Cat;

public class ListViewActivity extends AppCompatActivity {

    ListView lvCat;
    CatAdapter adapter;
    ArrayList<Cat>dsCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        fakeData();
        addControls();
        addEvents();
    }

    private void addEvents() {
        lvCat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dsCat.remove(position);
            }
        });
    }

    private void fakeData() {
        dsCat=new ArrayList<>();
        Cat cat1=new Cat(R.drawable.cat1,"Cat 1","500000");
        Cat cat2=new Cat(R.drawable.cat2,"Cat 2","5002000");
        Cat cat3=new Cat(R.drawable.cat3,"Cat 3","5003000");
        Cat cat4=new Cat(R.drawable.cat4,"Cat 4","5010000");
        Cat cat5=new Cat(R.drawable.cat5,"Cat 5","5400000");
        Cat cat6=new Cat(R.drawable.cat6,"Cat 6","5500000");
        Cat cat7=new Cat(R.drawable.cat7,"Cat 7","5006000");
        Cat cat8=new Cat(R.drawable.cat8,"Cat 8","5000040");
        Cat cat9=new Cat(R.drawable.cat9,"Cat 9","5000030");
        Cat cat10=new Cat(R.drawable.cat10,"Cat 10","5002000");
        dsCat.add(cat1);dsCat.add(cat2);dsCat.add(cat3);dsCat.add(cat4);dsCat.add(cat5);
        dsCat.add(cat6);dsCat.add(cat7);dsCat.add(cat8);dsCat.add(cat9);dsCat.add(cat10);
    }

    private void addControls() {
        lvCat=findViewById(R.id.lvCat);
        adapter=new CatAdapter(this.getApplicationContext(),R.layout.item_listview);
        adapter.addAll(dsCat);
        lvCat.setAdapter(adapter);
    }
}
