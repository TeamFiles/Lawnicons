package app.lawnchair.lawnicons.screens.icons;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import app.lawnchair.lawnicons.Data;
import app.lawnchair.lawnicons.R;

public class IconsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_icons, container, false);
        RecyclerView iconsRecView = view.findViewById(R.id.iconsRecView);
        AllIconsViewAdapter adapter = new AllIconsViewAdapter(view.getContext());

        Data.setContext(view.getContext());
        adapter.setIcons(Data.allIcons());
        iconsRecView.setAdapter(adapter);
        iconsRecView.setLayoutManager(new GridLayoutManager(view.getContext(), 3));

        return view;
    }
}
