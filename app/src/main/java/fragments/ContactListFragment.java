package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycontacts.mycontacts.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import adapters.ContactsListAdapter;
import models.ContactModel;

public class ContactListFragment extends Fragment {

    ArrayList<ContactModel> contactsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_contact_list, container, false);
        populateContacts();

        Map<String, ArrayList<ContactModel>> sortedMap = new HashMap<>();

        for(int i = 0; i < contactsList.size(); i++) {

            String firstKey = String.valueOf(contactsList.get(i).getFirstName().charAt(0));

            if (sortedMap.containsKey(firstKey)) {

                ArrayList<ContactModel> existingKeyList = sortedMap.get(firstKey);
                existingKeyList.add(contactsList.get(i));
            } else {

                ArrayList<ContactModel> newKey = new ArrayList<>();
                newKey.add(contactsList.get(i));
                sortedMap.put(firstKey, newKey);
            }
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        ContactsListAdapter adapter = new ContactsListAdapter(sortedMap, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(itemAnimator);

        return view;

    }

    private void populateContacts() {

        contactsList = new ArrayList<>();

        ContactModel contactModel1  = new ContactModel();
        contactModel1.setFirstName("Andy");
        contactModel1.setLastName("Murray");
        contactModel1.setNickName("AM");
        contactModel1.setEmail("andy.murray@gmail.com");
        contactModel1.setMobile("18207935277");
        contactModel1.setHomeNumber("25698746513");
        contactModel1.setAddress("ABCD EFGH IJKL");
        contactModel1.setSkype("andy_murray");
        contactModel1.setRelationship("Friend");
        contactModel1.setDob("25/11/1987");
        contactModel1.setFavourite(false);

        ContactModel contactModel2  = new ContactModel();
        contactModel2.setFirstName("Roger");
        contactModel2.setLastName("Federer");
        contactModel2.setNickName("RF");
        contactModel2.setEmail("andy.murray@gmail.com");
        contactModel2.setMobile("18207935277");
        contactModel2.setHomeNumber("25698746513");
        contactModel2.setAddress("ABCD EFGH IJKL");
        contactModel2.setSkype("andy_murray");
        contactModel2.setRelationship("Friend");
        contactModel2.setDob("25/11/1987");
        contactModel2.setFavourite(true);

        ContactModel contactModel3  = new ContactModel();
        contactModel3.setFirstName("Rafael");
        contactModel3.setLastName("Nadal");
        contactModel3.setNickName("RN");
        contactModel3.setEmail("andy.murray@gmail.com");
        contactModel3.setMobile("18207935277");
        contactModel3.setHomeNumber("25698746513");
        contactModel3.setAddress("ABCD EFGH IJKL");
        contactModel3.setSkype("andy_murray");
        contactModel3.setRelationship("Friend");
        contactModel3.setDob("25/11/1987");
        contactModel3.setFavourite(true);

        ContactModel contactModel4  = new ContactModel();
        contactModel4.setFirstName("Novak");
        contactModel4.setLastName("Djokovick");
        contactModel4.setNickName("ND");
        contactModel4.setEmail("andy.murray@gmail.com");
        contactModel4.setMobile("18207935277");
        contactModel4.setHomeNumber("25698746513");
        contactModel4.setAddress("ABCD EFGH IJKL");
        contactModel4.setSkype("andy_murray");
        contactModel4.setRelationship("Friend");
        contactModel4.setDob("25/11/1987");
        contactModel4.setFavourite(false);

        ContactModel contactModel5  = new ContactModel();
        contactModel5.setFirstName("Andy");
        contactModel5.setLastName("Rodick");
        contactModel5.setNickName("AR");
        contactModel5.setEmail("andy.murray@gmail.com");
        contactModel5.setMobile("18207935277");
        contactModel5.setHomeNumber("25698746513");
        contactModel5.setAddress("ABCD EFGH IJKL");
        contactModel5.setSkype("andy_murray");
        contactModel5.setRelationship("Friend");
        contactModel5.setDob("25/11/1987");
        contactModel5.setFavourite(false);

        ContactModel contactModel6  = new ContactModel();
        contactModel6.setFirstName("Jo-Wilfried");
        contactModel6.setLastName("Tsonga");
        contactModel6.setNickName("JWT");
        contactModel6.setEmail("andy.murray@gmail.com");
        contactModel6.setMobile("18207935277");
        contactModel6.setHomeNumber("25698746513");
        contactModel6.setAddress("ABCD EFGH IJKL");
        contactModel6.setSkype("andy_murray");
        contactModel6.setRelationship("Friend");
        contactModel6.setDob("25/11/1987");
        contactModel6.setFavourite(false);

        contactsList.add(contactModel1);
        contactsList.add(contactModel2);
        contactsList.add(contactModel3);
        contactsList.add(contactModel4);
        contactsList.add(contactModel5);
        contactsList.add(contactModel6);
    }
}
