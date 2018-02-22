package com.tutorial.macbookpro.interviewer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tutorial.macbookpro.interviewer.R;
import com.tutorial.macbookpro.interviewer.manager.ApiUtils;
import com.tutorial.macbookpro.interviewer.manager.SOService;
import com.tutorial.macbookpro.interviewer.model.UserEntity;
import com.tutorial.macbookpro.interviewer.request.RegisterRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by macbookpro on 2017-10-31.
 */

public class RegisterFragment extends Fragment {

    private SOService mService;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register,container,false);

        final EditText txtFirstName = (EditText) view.findViewById(R.id.edtFirstName);
        final EditText txtLastName = (EditText) view.findViewById(R.id.edtLastName);
        final EditText txtCountry = (EditText) view.findViewById(R.id.edtCountry);
        final EditText txtLogin = (EditText) view.findViewById(R.id.edtLogin);
        final EditText txtPassword = (EditText) view.findViewById(R.id.edtPassword);

        Button btnRegister = (Button) view.findViewById(R.id.buttonRegister);
        Button btnCancel = (Button) view.findViewById(R.id.buttonCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Fragment fragment = new MainPageFragment();
                moveToFragment(fragment);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register(String.valueOf(txtFirstName.getText()),
                        String.valueOf(txtLastName.getText()),
                        String.valueOf(txtCountry.getText()),
                        String.valueOf(txtLogin.getText()),
                        String.valueOf(txtPassword.getText()));
            }
        });

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public void register(String firstName, String lastName, String country, String userName, String password){

        RegisterRequest registerRequest = new RegisterRequest(firstName,lastName,country,userName,password);

        mService = ApiUtils.getSOService();
        mService.register(registerRequest).enqueue(new Callback<UserEntity>() {
            @Override
            public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {

                if(response.isSuccessful()) {

                    Toast.makeText(getActivity(), "User registered " + response.body().getFirstName(),
                            Toast.LENGTH_LONG).show();

                    Fragment fragment = new QuestionFragment();
                    MainPageFragment.userEntity = response.body();
                    moveToFragment(fragment);
                    Log.d("Login", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    Log.d("Login", "Error Java: " + Integer.toString(statusCode));
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<UserEntity> call, Throwable t) {
                //showErrorMessage();
                Log.d("Login", "error loading from API " + t.getMessage());
            }
        });



    }

    private void moveToFragment(Fragment fragment) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_frame, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();

    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
    }
}
