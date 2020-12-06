package com.example.finalb_rushadmin;

import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class UserFragment extends Fragment {
    private Button b1;
    private ImageView imgUp, imgDel;
    private ListView listView;
    private DatabaseHelper databaseHelper;
    private ArrayList<String> listUserName;
    private ArrayAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user, container, false);

        initializeDB();
        listView = (ListView) v.findViewById(R.id.listViewUsers);
        listUserName = new ArrayList<String>();
        viewData();

        b1 = v.findViewById(R.id.btnAddUser);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddUser.class);
                startActivity(intent);
            }
        });

        return v;
    }
    public void initializeDB()
    {
        if(databaseHelper == null){
            databaseHelper = new DatabaseHelper(getActivity());
        }
    }
    public void viewData()
    {
        Cursor cursor = databaseHelper.getListUsers();
        if(cursor.getCount() == 0){ Toast.makeText(getActivity(), "Database is empty", Toast.LENGTH_SHORT).show(); }
        else{
            while(cursor.moveToNext()){
                long personID = cursor.getLong(cursor.getColumnIndex("PersonID"));
                Cursor user = databaseHelper.getPerson(personID);
                String name = user.getString(user.getColumnIndex("FirstName"))+" "+user.getString(user.getColumnIndex("LastName"));
                listUserName.add(name);
            }
            adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, listUserName);
            listView.setAdapter(adapter);
        }
    }
}
