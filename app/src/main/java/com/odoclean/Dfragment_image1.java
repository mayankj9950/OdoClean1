package com.odoclean;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;

public class Dfragment_image1 extends Activity {
    ListView list;
    String[] web = {
            "Description",
            "Description",
            "Description",
            "Description",
            "Description",
            "Description",
            "Description"
    } ;
    Integer[] imageId = {
            R.drawable.cloth1,
            R.drawable.cloth1,
            R.drawable.cloth,
            R.drawable.cloth2,
            R.drawable.cloth4,
            R.drawable.cloth1,
            R.drawable.cloth2

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dfragment_list1);

        CustomList adapter = new
                CustomList(Dfragment_image1.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(Dfragment_image1.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });

    }

}
