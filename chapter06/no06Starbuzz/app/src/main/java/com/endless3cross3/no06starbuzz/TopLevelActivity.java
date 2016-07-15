package com.endless3cross3.no06starbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TopLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        // 利用Lister讓ListView回應點擊
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            //            @Override
            public void onItemClick(AdapterView<?> listView, // 列表視圖
                                    View itemView, // 被點擊的項目視圖元件 (item view)
                                    int position, // 它在列表視圖裡的位置 (position)
                                    long id) { // 以及底層資料的列ID (row ID)
                if (position == 0) {
                    Intent intent = new Intent(TopLevelActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                }

            }
        };
        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }
}
