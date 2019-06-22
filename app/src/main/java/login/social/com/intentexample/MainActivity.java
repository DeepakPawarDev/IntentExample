package login.social.com.intentexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListeners();
    }

    private void setListeners() {
        ((Button) findViewById(R.id.button_view_url)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("https://simfi.in");
                intent.setData(uri);
                startActivity(intent);
                /*if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {

                    Log.i(TAG, "no activity");
                }*/
            }
        });


    }

    public void viewURL(View view) {


        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https//simfi.in"));
        startActivity(intent);


    }
}
