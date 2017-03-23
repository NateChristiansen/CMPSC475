package cmpsc475.lab1;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] words = {
                "Project 1",
                "What is the greatest video game series of all time?",
                "What are the 2 best games in this series?",
                "Who is the best boss in this series?", // one of 6 choices, calls new activity that sends selection and either says what is wrong or shows correct, keep track of tries, 3 tries or fail
                "Question 4",
                "Question 5"
        };
        setListAdapter(new ArrayAdapter<>(this, R.layout.activity_main, R.id.desc, words));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position) {
            case 1:
                startActivity(new Intent(this, Question.class));
                break;
            case 2:
                startActivity(new Intent(this, MoreInfo.class));
                break;
            case 3:
                startActivity(new Intent(this, BestBoss.class));
        }
    }
}
