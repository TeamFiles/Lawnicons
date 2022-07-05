package app.lawnchair.lawnicons.screens.home;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.lawnchair.lawnicons.R;

public class LatestIconsViewAdapter extends RecyclerView.Adapter<LatestIconsViewAdapter.ViewHolder> {

    private ArrayList<LatestIcon> icons = new ArrayList<>();
    private final Context context;

    public LatestIconsViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public LatestIconsViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.latest_icons_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LatestIconsViewAdapter.ViewHolder holder, int position) {
        holder.appName.setText(icons.get(position).getName());
        holder.appIcon.setImageDrawable(icons.get(position).getIcon());
        setDrawableColor(holder.appIcon);
    }

    @Override
    public int getItemCount() {
        return icons.size();
    }

    public void setIcons(ArrayList<LatestIcon> icons) {
        this.icons = icons;
        notifyDataSetChanged();
    }

    public void setDrawableColor(ImageView icon) {
        int nightModeFlags = context.getApplicationContext().getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                DrawableCompat.setTint(icon.getDrawable(), ContextCompat.getColor(context.getApplicationContext(), R.color.app_icon_color_dark));
                break;
            case Configuration.UI_MODE_NIGHT_NO:
            case Configuration.UI_MODE_NIGHT_UNDEFINED:
                DrawableCompat.setTint(icon.getDrawable(), ContextCompat.getColor(context.getApplicationContext(), R.color.app_icon_color_light));
                break;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView appName;
        private ImageView appIcon;
        private RelativeLayout parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            appName = itemView.findViewById(R.id.appName);
            appIcon = itemView.findViewById(R.id.appIcon);
            parent = itemView.findViewById(R.id.iconsListItem);
        }
    }
}
