package com.cornez.renaissancepaintings;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MyActivity extends Activity {

    //CONTAINING PAINTINGS
    private LinearLayout mLinearList;
    private LinearLayout vertList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //REFERENCE THE SCROLLABLE LAYOUT STRUCTURE IN MAIN_SCREEN.XML
        mLinearList = (LinearLayout) findViewById(R.id.linearList);
        vertList = (LinearLayout) findViewById(R.id.vertList);

        //FILL THE SCROLLABLE LAYOUT STRUCTURE WITH PAINTINGS
        fillPaintingCarousel();

    }

    private void fillPaintingCarousel() {

        // POPULATE THE LINEAR LIST CAROUSEL WITH PAINTINGS AND DESCRIPTIONS
        ImageButton buttonItem, buttonItem2;

        for (int i = 0; i < RenaissanceDatabase.description.length; i++) {
            //STORE THE INDIVIDUAL PAINTINGS AS BUTTONS
            buttonItem = new ImageButton(this);
            buttonItem2 = new ImageButton(this);


            Painting painting = new Painting(RenaissanceDatabase.description[i], RenaissanceDatabase.id[i]);

            //USE THE CONTENT DESCRIPTION PROPERTY TO STORE
            //PAINTING DATA

            buttonItem.setContentDescription(painting.getDescription());
            buttonItem2.setContentDescription(painting.getDescription());

            //LOAD THE PAINTING USING ITS UNIQUE ID

            buttonItem.setImageDrawable(getResources().getDrawable(
                    painting.getId()));
            buttonItem2.setImageDrawable(getResources().getDrawable(
                    painting.getId()));

            //SET AN ONCLICK LISTENER FOR THE IMAGE BUTTON
            buttonItem.setOnClickListener(displayPaintingInformation);
            buttonItem2.setOnClickListener(displayPaintingInformation);

            //ADD THE IMAGE BUTTON TO THE SCROLLABLE LINEAR LIST
            mLinearList.addView(buttonItem);
            vertList.addView(buttonItem2);
        }
    }

    private View.OnClickListener displayPaintingInformation = new View.OnClickListener() {
        public void onClick(View btn) {
            // COLLECT THE INFORMATION STORED ABOUT THE PAINTING
            String paintingDescription = (String) btn.getContentDescription();

            // MAKE A METHOD CALL TO DISPLAY THE INFORMATION
            displayToast(paintingDescription);
        }
    };

    private void displayToast(String paintingDescription) {
        // SHOW THE INFORMATION ABOUT THE PAINTING AS
        // A TOAST WITH A SHORT DISPLAY LIFE
        Toast.makeText(this, paintingDescription, Toast.LENGTH_SHORT).show();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
