package com.endless3cross3.no07workout;


import android.app.FragmentTransaction;
import android.os.Bundle;

/* 新舊寫法 */
//import android.support.v4.app.Fragment; // 和書上寫法不同，取代 android.app.Fragment
import android.app.Fragment; // 舊
/**/

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {
    private long workoutId;

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if (savedInstanceState != null) {
            workoutId = savedInstanceState.getLong("workoutId");
        } else {

            FragmentTransaction ft = getChildFragmentManager().beginTransaction(); // 開啟交易
            StopwatchFragment stopwatchFragment = new StopwatchFragment();
            ft.replace(R.id.stopwatch_container, stopwatchFragment); // 替換框布局裡的 fragment
            ft.addToBackStack(null); // 將交易增加到返回堆疊
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); // 設定交易的動畫形式
            ft.commit(); // 提交並確認交易

        }

        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() { // 設定視圖元件的值
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            Workout workout = Workout.workouts[(int) workoutId];
            title.setText(workout.getName());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
//        super.onSaveInstanceState(outState);
        savedInstanceState.putLong("workoutId", workoutId);
    }

    public void setWorkout(long id) {
        this.workoutId = id;
    }
}
