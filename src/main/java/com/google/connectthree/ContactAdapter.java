package com.google.connectthree;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import model.Contact;


public class ContactAdapter extends ArrayAdapter<Contact> {
    List<Contact> contacts;

    public ContactAdapter(@NonNull Context context, @NonNull List<Contact> contacts) {
        super(context, R.layout.layout_contact, contacts);
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Contact contact;
        View view = null;
        contact = contacts.get(position);
        ViewHolder holder;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_contact, parent, false);
            holder = new ViewHolder();
            holder.imgProfile = convertView.findViewById(R.id.iv_profile);
            holder.tvName  = convertView.findViewById(R.id.tv_name);
            holder.tvPhone = convertView.findViewById(R.id.tv_phone);
            holder.imgCall = convertView.findViewById(R.id.iv_call);
            holder.imgSms  = convertView.findViewById(R.id.iv_sms);
            convertView.setTag(holder);
        } else {
            holder =(ViewHolder) convertView.getTag();
        }
        holder.fill(contact);
        return convertView;
    }

    public class ViewHolder {
        ImageView imgProfile;
        TextView tvName;
        TextView tvPhone;
        ImageView imgSms, imgCall;

        public void fill(Contact contact) {
            if (contact.getId() != 0) {
                imgProfile.setImageResource(contact.getId());
            }
            tvName.setText(contact.getName());
            tvPhone.setText(contact.getPhoneNumber());
            imgSms.setImageResource(R.drawable.sms);
            imgCall.setImageResource(R.drawable.call);
            imgSms.setTag(contact.getPhoneNumber());
            imgCall.setTag(contact.getPhoneNumber());
            imgSms.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("sms:"+view.getTag()));
                    getContext().startActivity(intent);
                }
            });
            imgCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("tel:"+view.getTag()));
                    getContext().startActivity(intent);
                }
            });

        }
    }
}


