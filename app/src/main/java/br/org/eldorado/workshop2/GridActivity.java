package br.org.eldorado.workshop2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        GridView gridView = (GridView) findViewById(R.id.gridExample);
        gridView.setAdapter(new ImageAdapter(this));
    }
}
