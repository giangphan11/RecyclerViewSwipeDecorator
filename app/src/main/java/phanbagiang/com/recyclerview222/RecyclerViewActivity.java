package phanbagiang.com.recyclerview222;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;
import phanbagiang.com.adapter.CatRecyclerViewAdapter;
import phanbagiang.com.adapter.IRecyclerViewClick;
import phanbagiang.com.model.Cat;

public class RecyclerViewActivity extends AppCompatActivity implements IRecyclerViewClick {
    RecyclerView recycler_cat;
    CatRecyclerViewAdapter catRecyclerViewAdapter;
    ArrayList<Cat>dsCat;

    RecyclerView.Adapter mAdapter;

    RecyclerView.LayoutManager layoutManager;

    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        addControls();
        fakeData();
        addEvents();
    }

    private void addEvents() {
        
    }

    private void fakeData() {
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
        dsCat.add(cat1);dsCat.add(cat2);dsCat.add(cat3);dsCat.add(cat4);dsCat.add(cat5);

        // chức năng làm tươi
        swipeRefreshLayout=findViewById(R.id.swipeFreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Cat cat6=new Cat(R.drawable.cat6,"Cat 6","5500000");
                Cat cat7=new Cat(R.drawable.cat7,"Cat 7","5006000");
                Cat cat8=new Cat(R.drawable.cat8,"Cat 8","5000040");
                Cat cat9=new Cat(R.drawable.cat9,"Cat 9","5000030");
                Cat cat10=new Cat(R.drawable.cat10,"Cat 10","5002000");
                dsCat.add(cat6);dsCat.add(cat7);dsCat.add(cat8);dsCat.add(cat9);dsCat.add(cat10);
                catRecyclerViewAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        // sự kiện vuốt trái phải
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(simpleCallback);
        // cài đặt cho recyclerview
        itemTouchHelper.attachToRecyclerView(recycler_cat);

    }

    private void addControls() {
        dsCat=new ArrayList<>();
        recycler_cat=findViewById(R.id.recycler_Cat);
        recycler_cat.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recycler_cat.setLayoutManager(layoutManager);

        // thêm giải phân cách
        DividerItemDecoration decoration=new DividerItemDecoration(recycler_cat.getContext(),DividerItemDecoration.VERTICAL);
        //Drawable drawable =getDrawable(R.drawable.custom_divider);
        Drawable drawable= ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_divider);
        decoration.setDrawable(drawable);
        recycler_cat.addItemDecoration(decoration);

        catRecyclerViewAdapter=new CatRecyclerViewAdapter(this.getApplicationContext(),dsCat,R.layout.item_listview,this);
        recycler_cat.setAdapter(catRecyclerViewAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this,""+dsCat.get(position).getTen(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(int position) {
        dsCat.remove(position);
        catRecyclerViewAdapter.notifyItemRemoved(position);
    }


    String catRemoved=null;

    ItemTouchHelper.SimpleCallback simpleCallback=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT| ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        // xử lý trượt trái- phải
        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position=viewHolder.getAdapterPosition();

            switch (direction){
                case ItemTouchHelper.LEFT:
                    dsCat.remove(position);
                    catRecyclerViewAdapter.notifyItemRemoved(position);
                    //catRemoved=dsCat.get(position).getTen();
                    //Snackbar.make(recycler_cat,catRemoved, BaseTransientBottomBar.LENGTH_LONG).show();
                    break;
                case ItemTouchHelper.RIGHT:

                    break;
            }
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(RecyclerViewActivity.this, R.color.swipeLeft))
                    .addSwipeLeftActionIcon(R.drawable.ic_baseline_delete_24)
                    .addSwipeLeftLabel("Delete")

                    .addSwipeRightBackgroundColor(ContextCompat.getColor(RecyclerViewActivity.this, R.color.swipeRight))
                    .addSwipeRightActionIcon(R.drawable.ic_baseline_archive_24)
                    .addSwipeRightLabel("Archive")
                    .create()
                    .decorate();
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };


}
