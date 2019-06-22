package login.social.com.intentexample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int PICK_IMAGE =100 ;

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

    public void getImage(View view) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.putExtra("return-data",true);
        startActivityForResult(intent,PICK_IMAGE);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==PICK_IMAGE && resultCode==Activity.RESULT_OK){

            Uri uri=data.getData();
            ((ImageView)findViewById(R.id.image)).setImageURI(uri);

        }
    }

    public void shareApp(View view) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("image/*");
        startActivity(intent);
       

    }
}
