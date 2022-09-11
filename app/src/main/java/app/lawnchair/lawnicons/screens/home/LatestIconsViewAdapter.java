package app.lawnchair.lawnicons.screens.home;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.lawnchair.lawnicons.R;

public class LatestIconsViewAdapter extends RecyclerView.Adapter<LatestIconsViewAdapter.ViewHolder> {

    private ArrayList<Icon> icons = new ArrayList<>();
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
        if (icons.get(position).isRequestBtn()) {
            holder.iconBg.setCardBackgroundColor(context.getColor(R.color.reqBtnBg));
            holder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://telegram.me/iconrequestsbot"));
                        context.startActivity(intent);
                    } catch(ActivityNotFoundException e){
                        Toast.makeText(context, R.string.install_browser, Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }
            });
        }
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

        private TextView appName;
        private ImageView appIcon;
        private RelativeLayout parent;
        private CardView iconBg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            appName = itemView.findViewById(R.id.appName);
            appIcon = itemView.findViewById(R.id.appIcon);
            iconBg = itemView.findViewById(R.id.iconHolder);
            parent = itemView.findViewById(R.id.latestIconsListItem);
        }
    }
}
