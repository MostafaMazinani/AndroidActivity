package com.google.connectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import model.Contact;

public class CustomListActivity extends AppCompatActivity {

    List<Contact> contacts;
    ListView listView;
    ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        listView = findViewById(R.id.lv_contact);
        prepareData();
        displayData();

    }

    private void displayData() {
        if(contactAdapter == null) {
            contactAdapter = new ContactAdapter(this, contacts);
            listView.setAdapter(contactAdapter);
        }
    }

    private void prepareData() {
        if (contacts == null) {
            contacts = new ArrayList<>();
            contacts.add(new Contact("hoseein mazinani", "09124578963", R.drawable.profile1));
            contacts.add(new Contact("batol mazinani", "09122436234", R.drawable.profile2));
            contacts.add(new Contact("morteza mazinani", "091224587223", R.drawable.profile3));
            addFakeContact(5);
            contacts.add(new Contact("marzi mazinani", "0912365634", R.drawable.profile4));
            contacts.add(new Contact("azam mazinani", "0912567457", R.drawable.profile5));
            contacts.add(new Contact("mostafa mazinani", "0912509823", R.drawable.profile6));
            addFakeContact(8);
            contacts.add(new Contact("mohammad rezvani", "0912364234", R.drawable.profile7));
            contacts.add(new Contact("mahmod rezvani", "09124308149", R.drawable.profile8));
            contacts.add(new Contact("amir masoud mazinani", "09124369936", R.drawable.profile9));
            contacts.add(new Contact("amin mazinani", "09124840280", R.drawable.profile10));
            addFakeContact(9);
            contacts.add(new Contact("ali sohrabi", "09125874693", R.drawable.profile11));
            contacts.add(new Contact("hamed naeimi", "09125469873", R.drawable.profile12));
            contacts.add(new Contact("milad kalhor", "09114477825", R.drawable.profile13));
            addFakeContact(5);
            contacts.add(new Contact("fati mazinani", "09154871256", R.drawable.profile14));
            contacts.add(new Contact("ati mazinani", "09134679852", R.drawable.profile15));
        }
    }

    private void addFakeContact(int n) {
        for(int i=0; i<n ; i++) {
            contacts.add(new Contact("Fake Contact","091256897"+i,R.drawable.profile8));
        }
    }
}
