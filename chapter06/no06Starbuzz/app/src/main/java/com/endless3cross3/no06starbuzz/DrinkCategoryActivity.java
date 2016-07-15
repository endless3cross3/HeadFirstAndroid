package com.endless3cross3.no06starbuzz;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<Drink>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                Drink.drinks);

        ListView listView = getListView();
        listView.setAdapter(listAdapter);
    }

    public void onListItemClick(ListView listView, // 列表視圖
                                View itemView, // 被點擊的項目視圖元件 (item view)
                                int position, // 它在列表視圖裡的位置 (position)
                                long id) { // 以及底層資料的列ID (row ID)
        Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
        intent.putExtra(DrinkActivity.EXTRA_DRINKNO, (int) id);
        startActivity(intent);
    }
}
