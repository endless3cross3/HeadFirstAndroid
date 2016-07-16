package com.endless3cross3.no07workout;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        /* 新舊寫法 */
////        WorkoutDetailFragment frag = (WorkoutDetailFragment)
////                getSupportFragmentManager().findFragmentById(R.id.detail_frag); // 和書上寫法不同，以 getSupportFragmentManager 取代 getFragment
//        WorkoutDetailFragment frag = (WorkoutDetailFragment)
//                getFragmentManager().findFragmentById(R.id.detail_frag); // 舊
//        /**/
//
//        frag.setWorkout(1);
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.Fragment_container);
        if (fragmentContainer != null) {

            WorkoutDetailFragment details = new WorkoutDetailFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            details.setWorkout(id);
            ft.replace(R.id.Fragment_container, details);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        } else {

            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
            startActivity(intent);

        }

    }
}
