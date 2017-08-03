package adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mycontacts.mycontacts.R;
import com.example.mycontacts.mycontacts.ViewDetailsActivity;

import java.util.ArrayList;

import models.ContactModel;

public class FavoritesAdapter  extends
        RecyclerView.Adapter<FavoritesAdapter.ViewHolder> implements View.OnClickListener {

    private Context context;
    private ArrayList<ContactModel> contactsList;

    public FavoritesAdapter(ArrayList<ContactModel> contactsList, Context context) {
        this.context = context;
        this.contactsList = contactsList;
    }

    @Override
    public FavoritesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.favorite_item_view, parent, false);

        return new FavoritesAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FavoritesAdapter.ViewHolder holder, int position) {

        holder.tv_name.setText(contactsList.get(position).getFirstName() +
                                    " " +
                                contactsList.get(position).getLastName());
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(context, ViewDetailsActivity.class);
        context.startActivity(i);
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_name;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
