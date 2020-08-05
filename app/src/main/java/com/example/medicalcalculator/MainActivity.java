package com.example.medicalcalculator;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private String[] drawerListViewItems;
    private ListView lView;
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

//        /get ListView from activity_main
//        lView = findViewById(R.id.left_drawer);/

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        //remove title from toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        ImageView logo = (ImageView) findViewById(R.id.imageView);

//        // get ListViewItems from string-array
//        drawerListViewItems = getResources().getStringArray(R.array.formulas);
//
//        //get ListView from activity_main
//        lView = findViewById(R.id.left_drawer);
//
//        // set adapter for the listView
//        lView.setAdapter(new ArrayAdapter<String>(this, R.layout.list_formulas, R.id.list, drawerListViewItems));

        //Button button = (Button) findViewById(R.id.button);
        //EditText height = (EditText) findViewById(R.id.heightIn);
        //EditText weight = (EditText) findViewById(R.id.weightIn);
        //applying the formula 1 -> TODO: move to a new class
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView resultView = findViewById(R.id.result);
                EditText heightIn = (EditText) findViewById(R.id.heightIn);
                EditText weightIn = (EditText) findViewById(R.id.weightIn);
                double height = Double.parseDouble(heightIn.getText().toString());
                double weight = Double.parseDouble(weightIn.getText().toString());
                double result = (height + weight - 60) / 100;
                String stringResult = new Double(result).toString();
                resultView.setText(stringResult);
            }
        });*/

    }

    //inflate an option menu for an activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drawer_view, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // The action bar home/up action should open or close the drawer.
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                mDrawer.openDrawer(GravityCompat.START);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    private void setupDrawerContent(NavigationView navigationView) {
//        navigationView.setNavigationItemSelectedListener(
//                new NavigationView.OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(MenuItem menuItem) {
//                        selectDrawerItem(menuItem);
//                        return true;
//                    }
//                });
//    }


    public boolean onOptionsItemSelected(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Intent intent = null;
        switch(menuItem.getItemId()) {
            case R.id.f1:
                intent = new Intent(this, Formula_1.class);
                startActivity(intent);
                break;
            case R.id.f2:
                intent = new Intent(this, Formula_2.class);
                startActivity(intent);
                break;
            case R.id.f3:
                intent = new Intent(this, Formula_3.class);
                startActivity(intent);
                break;
            case R.id.f4:
                intent = new Intent(this, Formula_4.class);
                startActivity(intent);
                break;
            case R.id.f5:
                intent = new Intent(this, Formula_5.class);
                startActivity(intent);
                break;
            case R.id.f6:
                intent = new Intent(this, Formula_6.class);
                startActivity(intent);
                break;
            case R.id.f7:
                intent = new Intent(this, Formula_7.class);
                startActivity(intent);
                break;
            case R.id.f8:
                intent = new Intent(this, Formula_8.class);
                startActivity(intent);
                break;
            case R.id.f9:
                intent = new Intent(this, Formula_9.class);
                startActivity(intent);
                break;
            case R.id.f10:
                intent = new Intent(this, Formula_10.class);
                startActivity(intent);
                break;
        }



//         //Insert the fragment by replacing any existing fragment
//        LayoutInflater inflater = getLayoutInflater();
//        LinearLayout container = (LinearLayout) findViewById(R.id.content_frame);
//        inflater.inflate(R.layout.activity_main, container);
//
//         //Highlight the selected item has been done by NavigationView
//        menuItem.setChecked(true);
//        // Set action bar title
//        setTitle(menuItem.getTitle());
//        // Close the navigation drawer
//        mDrawer.closeDrawers();
        return super.onOptionsItemSelected(menuItem);
    }

    // ...
}



//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        //to prevent current item select over and over
//        if (item.isChecked()){
//            mDrawer.closeDrawer(GravityCompat.START);
//            return false;
//        }
//
//        if (id == R.id.formula1) {
//            startActivity(new Intent(getApplicationContext(), Formula_1.class));
//        } else if (id == R.id.formula2) {
//            startActivity(new Intent(getApplicationContext(), Formula_2.class));
//
//        }
//        mDrawer.closeDrawer(GravityCompat.START);
//        return true;
//    }






