package com.tutorial.macbookpro.interviewer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.tutorial.macbookpro.interviewer.fragments.MainPageFragment;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new MainPageFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_frame, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();



//        btnResult.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), AnswerActivity.class);
//                intent.putExtra("answers",correctAnswer);
//
//                startActivity(intent);
//            }
//        });
    }

}
