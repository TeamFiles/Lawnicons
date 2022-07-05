package app.lawnchair.lawnicons.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import app.lawnchair.lawnicons.ContributorsRecViewAdapter;
import app.lawnchair.lawnicons.Data;
import app.lawnchair.lawnicons.R;

public class AboutFragment extends Fragment {

    public AboutFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about, container, false);
        RecyclerView contributorRecView = view.findViewById(R.id.conRecView);
        ContributorsRecViewAdapter adapter = new ContributorsRecViewAdapter(view.getContext());

        Data.setContext(view.getContext());
        adapter.setContributors(Data.contributors());
        contributorRecView.setAdapter(adapter);
        contributorRecView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }
}