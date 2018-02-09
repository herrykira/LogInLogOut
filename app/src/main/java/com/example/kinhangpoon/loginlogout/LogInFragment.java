package com.example.kinhangpoon.loginlogout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by KinhangPoon on 8/2/2018.
 */

public class LogInFragment extends Fragment {
    EditText Username,Password;
    Button LogInButton;
    SharedPreferences sharedPreferences;
    MyInterface myInterface;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        myInterface = (MyInterface) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.login_fragment,container,false);
        Username = view.findViewById(R.id.editTextUsername);
        Password = view.findViewById(R.id.editTextPassword);
        sharedPreferences = getActivity().getSharedPreferences("myfile",Context.MODE_PRIVATE);
        LogInButton = view.findViewById(R.id.buttonLogin);
        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username",username);
                editor.putString("password",password);
                editor.commit();
                myInterface.replace(view);
//                getFragmentManager().popBackStack();

//                getFragmentManager().beginTransaction().replace(R.id.login,new LogOutFragment()).commit();
            }
        });
        return view;
    }
}
