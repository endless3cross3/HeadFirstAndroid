package com.endless3cross3.no06starbuzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {
    public static final String EXTRA_DRINKNO = "drinkNo"; // 增加 EXTRA_DRINKNO 常數

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        // 從 intent 取得飲料資訊
        int drinkNo = (Integer) getIntent().getExtras().get(EXTRA_DRINKNO);
        Drink drink = Drink.drinks[drinkNo]; // 利用 drinkNo 取得使用者選取之飲料的細節

        /* 使用飲料資訊為視圖元件填值。*/
        // 填寫飲料圖像
        ImageView photo = (ImageView) findViewById(R.id.photo);
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());

        // 填寫飲料名稱
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(drink.getName());

        // 填寫飲料敘述
        TextView description = (TextView) findViewById(R.id.description);
        description.setText(drink.getDescription());
        /**/
    }
}
