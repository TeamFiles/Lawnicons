package app.lawnchair.lawnicons;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContributorsRecViewAdapter extends RecyclerView.Adapter<ContributorsRecViewAdapter.ViewHolder> {

    private ArrayList<Contributor> contributors = new ArrayList<>();
    private final Context context;

    public ContributorsRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ContributorsRecViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contributors_list_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ContributorsRecViewAdapter.ViewHolder holder, int position) {

        holder.contributorName.setText(contributors.get(position).getName());
//        holder.contributorRole.setText(contributors.get(position).getRole());
        holder.contributorAvatar.setImageDrawable(contributors.get(position).getAvatar());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, contributors.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contributors.size();
    }

    public void setContributors(ArrayList<Contributor> contributors) {
        this.contributors = contributors;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView contributorName;
        private ImageView contributorAvatar;
        private RelativeLayout parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contributorName = itemView.findViewById(R.id.contributorName);
            contributorAvatar = itemView.findViewById(R.id.contributorAvatar);
            parent = itemView.findViewById(R.id.conListItem);
        }
    }

}
