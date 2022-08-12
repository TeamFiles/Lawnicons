package app.lawnchair.lawnicons.screens.home;

import android.content.ActivityNotFoundException;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import app.lawnchair.lawnicons.Data;
import app.lawnchair.lawnicons.R;

public class HomeFragment extends Fragment {


    public HomeFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        MaterialCardView mr = view.findViewById(R.id.home_iconMR);

        RecyclerView iconsRecView = view.findViewById(R.id.latestIconsRecView);
        LatestIconsViewAdapter adapter = new LatestIconsViewAdapter(view.getContext());

        mr.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                try{
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://telegram.me/fileschat"));
                    startActivity(intent);
                } catch(ActivityNotFoundException e){
                    Toast.makeText(view.getContext(), R.string.install_browser, Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

                return true;
            }
        });

        adapter.setIcons(Data.getLatestIcons());
        iconsRecView.setAdapter(adapter);
        iconsRecView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));

        return view;
    }



}