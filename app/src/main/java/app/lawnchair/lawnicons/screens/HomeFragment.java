package app.lawnchair.lawnicons.screens;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import app.lawnchair.lawnicons.R;

public class HomeFragment extends Fragment {


    public HomeFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        Button requestBtn = view.findViewById(R.id.requestBtn);
        ImageView mr = view.findViewById(R.id.home_iconMR);

        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/iconrequestsbot"));
                    startActivity(intent);
                } catch(ActivityNotFoundException e){
                    Toast.makeText(view.getContext(), R.string.install_browser, Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });

        mr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/fileschat"));
                    startActivity(intent);
                } catch(ActivityNotFoundException e){
                    Toast.makeText(view.getContext(), R.string.install_browser, Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });

        return view;
    }



}