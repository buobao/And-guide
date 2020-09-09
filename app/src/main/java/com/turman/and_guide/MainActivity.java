package com.turman.and_guide;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        try {
            ActivityInfo[] activityInfos = getPackageManager().getPackageInfo(getApplication().getPackageName(),PackageManager.GET_ACTIVITIES).activities;
            if (activityInfos!=null && activityInfos.length>1) {
                ArrayList<String> titles = new ArrayList<>();
                ArrayList<String> clazzes = new ArrayList<>();
                for (int i = 0; i < activityInfos.length; i++) {
                    if (activityInfos[i].name.contains("MainActivity")) {
                        continue;
                    }
                    titles.add(getResources().getString(activityInfos[i].descriptionRes));
                    clazzes.add(activityInfos[i].name);
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,titles);
                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener((parent, view, position, id) -> {
                    try {
                        Intent intent = new Intent(this, Class.forName(clazzes.get(position)));
                        startActivity(intent);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
