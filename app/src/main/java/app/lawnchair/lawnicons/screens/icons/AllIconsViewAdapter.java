package app.lawnchair.lawnicons.screens.icons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.lawnchair.lawnicons.R;
import app.lawnchair.lawnicons.screens.home.Icon;

public class AllIconsViewAdapter extends RecyclerView.Adapter<AllIconsViewAdapter.ViewHolder> {

    private ArrayList<Icon> icons = new ArrayList<>();
    private final Context context;

    public AllIconsViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public AllIconsViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_icons_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllIconsViewAdapter.ViewHolder holder, int position) {
        holder.appIcon.setImageDrawable(icons.get(position).getIcon());
        Icon.setDrawableColor(holder.appIcon, context);
    }

    @Override
    public int getItemCount() {
        return icons.size();
    }

    public void setIcons(ArrayList<Icon> icons) {
        this.icons = icons;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView appIcon;
        private RelativeLayout parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            appIcon = itemView.findViewById(R.id.appIcon);
            parent = itemView.findViewById(R.id.allIconsListItem);
        }
    }
}
