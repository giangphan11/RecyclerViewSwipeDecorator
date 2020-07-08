package phanbagiang.com.recyclerview222;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xuLyListView(View view) {
        Intent intent=new Intent(MainActivity.this,ListViewActivity.class);
        startActivity(intent);
    }

    public void xuLyRecyclerView(View view) {
        Intent intent=new Intent(MainActivity.this,RecyclerViewActivity.class);
        startActivity(intent);
    }
}
