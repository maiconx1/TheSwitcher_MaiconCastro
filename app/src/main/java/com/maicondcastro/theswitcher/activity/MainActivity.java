package com.maicondcastro.theswitcher.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.maicondcastro.theswitcher.R;
import com.maicondcastro.theswitcher.data.DivisionRepository;
import com.maicondcastro.theswitcher.model.Division;

public class MainActivity extends AppCompatActivity {

    private boolean fimDb = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            public void run() {
                initDb();
            }
        }).start();
        try {
            while (!fimDb) {
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initDb() {
        DivisionRepository repository = new DivisionRepository(getApplication());
        if(repository.getDivisions().size() == 0) {

            repository.insert(new Division(1, "Kitchen", false));
            repository.insert(new Division(2, "Living room", false));
            repository.insert(new Division(3, "Master bedroom", false));
            repository.insert(new Division(4, "Guest's bedroom", false));
        }
        fimDb = true;
    }
}
