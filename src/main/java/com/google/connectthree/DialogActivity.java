package com.google.connectthree;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

    }

    public void showProgresDialog(View view) {
        final ProgressDialog pdialog = new ProgressDialog(this);
        pdialog.setCancelable(false);
        pdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pdialog.setTitle("Checking your information...");
        pdialog.setMessage("Please waiting...");
        pdialog.setProgress(0);
        pdialog.show();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (pdialog.getProgress() < pdialog.getMax())
                    pdialog.incrementProgressBy(1);
                else
                    pdialog.dismiss();
            }
        }, 0, 200);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if(pdialog.getMax() > pdialog.getSecondaryProgress()) {
                    pdialog.incrementSecondaryProgressBy(1);
                }
            }
        }, 0, 140);
    }

    public void showAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
    //dialog type 1
//        builder.setTitle("Delete File")
//                .setCancelable(false)
//                .setMessage("Are you sure to Delete this File")
//                .setIcon(android.R.drawable.alert_dark_frame)
//                .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                })
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(DialogActivity.this, "File Deleted", Toast.LENGTH_SHORT).show();
//                    }
//                });


//        dialog type2
        builder.setCancelable(false)
                .setSingleChoiceItems(new String[]{"A","B","C","D","E"}, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this, "Item "+i+" is Selected", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Ok", null);
        builder.show();
    }


    public void showDialog(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_connect_three_activitiy);
        dialog.show();
    }
}