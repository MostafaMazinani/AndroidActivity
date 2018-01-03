package com.google.connectthree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu subMenuMedia = menu.addSubMenu("Media");
        subMenuMedia.add("Image");
        subMenuMedia.add("Connect-3")
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem m) {
                        startActivity(new Intent(MainActivity.this, ConnectThreeActivitiy.class));
                        return false;
                    }
                });

        subMenuMedia.add("Video")
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        startActivity(new Intent(MainActivity.this, VideoView.class));
                        return false;
                    }
                });
        subMenuMedia.add("Audio")
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        startActivity(
                                new Intent(MainActivity.this, AudioActivity.class)
                        );

                        return false;
                    }
                });
        menu.add("Dialog").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(MainActivity.this, DialogActivity.class));
                return false;
            }
        });
        SubMenu listMenu = menu.addSubMenu("Item List");
        listMenu.add("Simple").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(MainActivity.this, SimpleMenuActivity.class));
                return false;
            }
        });
        listMenu.add("Custom").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(MainActivity.this, CustomListActivity.class));
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
