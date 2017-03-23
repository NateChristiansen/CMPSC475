package cmpsc475.lab1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MoreInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
    }

    public void bloodbornewiki(View view) {
        //overridePendingTransition(R.animator.fadein, R.animator.fadeout);
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Bloodborne")));
        overridePendingTransition(R.animator.fadeout, R.animator.fadein);
    }

    public void darksoulswiki(View view) {
        //
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Dark_Souls")));
        overridePendingTransition(R.animator.fadeout, R.animator.fadein);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //overridePendingTransition(R.animator.fadein, R.animator.fadeout);
    }

    public void end(View view) {
        finish();
    }
}
