package demo.xiaxl.com.activity_options;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

public class CActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //
        ActivityCompat.finishAfterTransition(this);
    }
}
