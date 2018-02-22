package com.tutorial.macbookpro.interviewer.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.tutorial.macbookpro.interviewer.R;
import com.tutorial.macbookpro.interviewer.model.UserEntity;

/**
 * Created by macbookpro on 2017-10-30.
 */

public class MainPageFragment extends Fragment {

    public static View view = null;
    static public UserEntity userEntity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(R.layout.fragment_main_page,container,false);
        } catch (InflateException e) {
        /* map is already there, just return view as it is */
        }

        ImageView imageView = (ImageView) view.findViewById(R.id.logo);
        Drawable logo = getResources().getDrawable(R.drawable.interview);

        imageView.setImageDrawable(logo);

        Button btnLogin = (Button) view.findViewById(R.id.btnLogin);
        Button btnRegister = (Button) view.findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new LoginFragment();
                moveToFragment(fragment);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new RegisterFragment();
                moveToFragment(fragment);
            }
        });

        return view;
    }

    private void moveToFragment(Fragment fragment) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_frame, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
    }
}
