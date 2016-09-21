package br.org.eldorado.workshop2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import br.org.eldorado.workshop2.fragments.FragmentExampleActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String[] EXAMPLES = new String[]{"Activity", "Shared Preferences",
            "Fragment", "Service", "GridView", "Sensors"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.action_bar_title);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, EXAMPLES);

        ListView listView = (ListView) findViewById(R.id.listExamples);
        listView.setAdapter(adapter);

        final MainActivity holder = this;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, String.format("Item position %d tapped", position));
                switch (position) {
                    case 0:
                    case 1:
                        startActivity(new Intent(holder, ActivitiesFirstActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(holder, FragmentExampleActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(holder, ServiceActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(holder, GridActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(holder, SensorActivity.class));
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), R.string.example_default_text, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        listView.setBackgroundColor(getResources().getColor(android.R.color.background_light));
    }
}
