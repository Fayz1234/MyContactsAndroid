package adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mycontacts.mycontacts.R;
import com.example.mycontacts.mycontacts.ViewDetailsActivity;

import java.util.ArrayList;
import java.util.Map;

import models.ContactModel;

public class ContactsListAdapter extends
        RecyclerView.Adapter<ContactsListAdapter.ViewHolder> implements View.OnClickListener {

    private Context context;
    private Map<String, ArrayList<ContactModel>> detailsMap;

    public ContactsListAdapter(Map<String, ArrayList<ContactModel>> detailsMap, Context context) {
        this.context = context;
        this.detailsMap = detailsMap;
    }

    /*
    * Setting view to list items
    * */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.contacts_row_view, parent, false);
        v.findViewById(R.id.cardView).setOnClickListener(this);
        return new ViewHolder(v);
    }

    /*This method is populating Contacts list
    * We are inflating layout in CardView for better user experience*/
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String currentKey = new ArrayList<>(detailsMap.keySet()).get(position);
        holder.heading.setText(currentKey);
        holder.cv.setTag(position);

        final ArrayList<ContactModel> currentContacts = detailsMap.get(currentKey);

        for(int i = 0; i < currentContacts.size(); i++) {

            final ContactModel contact = currentContacts.get(i);

            LinearLayout ll = (LinearLayout) LayoutInflater.from(context).
                    inflate(R.layout.contacts_row, null);

            TextView title = (TextView) ll.findViewById(R.id.title);
            TextView data = (TextView) ll.findViewById(R.id.value);
            final ImageView iv_favorite = (ImageView) ll.findViewById(R.id.iv_favorite);

            title.setText(contact.getFirstName()+" "+currentContacts.get(i).getLastName());
            data.setText(contact.getRelationship());

            if(contact.isFavourite()) {

                iv_favorite.setImageResource(R.mipmap.favorite_star);
            } else {

                iv_favorite.setImageResource(R.mipmap.favorite_background);
            }

            iv_favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(contact.isFavourite()) {
                        contact.setFavourite(false);
                        iv_favorite.setImageResource(R.mipmap.favorite_background);
                    }
                    else {
                        contact.setFavourite(true);
                        iv_favorite.setImageResource(R.mipmap.favorite_star);
                    }
                }
            });

            holder.linearLayout.addView(ll);
        }
    }

    /*
    * This method returns the number of items of list
    * */
    @Override
    public int getItemCount() {
        return detailsMap.size();
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

        private TextView heading;
        private LinearLayout linearLayout;
        private CardView cv;

        public ViewHolder(View itemView) {
            super(itemView);
            heading = (TextView) itemView.findViewById(R.id.heading);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            cv = (CardView) itemView.findViewById(R.id.cardView);
        }
    }
}