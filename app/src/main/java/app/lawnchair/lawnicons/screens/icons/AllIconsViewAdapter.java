package app.lawnchair.lawnicons.screens.icons;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
        holder.appName.setText(icons.get(position).getName());
        holder.itemView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.zoom_in));
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
        private TextView appName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            appIcon = itemView.findViewById(R.id.appIcon);
            appName = itemView.findViewById(R.id.appName);
            parent = itemView.findViewById(R.id.allIconsListItem);
        }
    }

    public static int getColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        return (int) (dpWidth / 100);
    }
}
