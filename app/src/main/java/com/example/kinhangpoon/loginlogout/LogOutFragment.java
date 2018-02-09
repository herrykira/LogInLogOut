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
import android.widget.TextView;

/**
 * Created by KinhangPoon on 8/2/2018.
 */

public class LogOutFragment extends Fragment {
    Button LogOutButton;
    TextView show;
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
        final View view = inflater.inflate(R.layout.logout_fragment,container,false);
        LogOutButton = view.findViewById(R.id.buttonLogout);
        show = view.findViewById(R.id.textViewshow);
        sharedPreferences = getActivity().getSharedPreferences("myfile",Context.MODE_PRIVATE);
        show.setText(sharedPreferences.getString("username",""));
        LogOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username","");
                editor.putString("password","");
                editor.commit();
                myInterface.replace(view);
//                getFragmentManager().popBackStack();
//                getFragmentManager().beginTransaction().replace(R.id.logout,new LogInFragment()).commit();
            }
        });
        return view;
    }
}
