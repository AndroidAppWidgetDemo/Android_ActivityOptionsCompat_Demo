package demo.xiaxl.com.activity_options;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.activity_main);
        //
        findViewById(R.id.makeCustomAnimation).setOnClickListener(this);
        findViewById(R.id.makeScaleUpAnimation).setOnClickListener(this);
        findViewById(R.id.makeThumbnailScaleUpAnimation).setOnClickListener(this);
        findViewById(R.id.makeSceneTransitionAnimation).setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.makeCustomAnimation:
                makeCustomAnimation();
                break;
            case R.id.makeScaleUpAnimation:
                makeScaleUpAnimation(v);
                break;
            case R.id.makeThumbnailScaleUpAnimation:
                makeThumbnailScaleUpAnimation(v);
                break;
            case R.id.makeSceneTransitionAnimation:
                makeSceneTransitionAnimation(v);
                break;
        }
    }

    public void makeCustomAnimation() {
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeCustomAnimation(this,
                R.anim.fade_in, R.anim.fade_out);
        ActivityCompat.startActivity(this,
                new Intent(this, BActivity.class), compat.toBundle());
    }


    private void makeScaleUpAnimation(View view) {
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeScaleUpAnimation(view,
                view.getWidth() / 2, view.getHeight() / 2, 0, 0);
        ActivityCompat.startActivity(this, new Intent(this, BActivity.class),
                compat.toBundle());
    }

    private void makeThumbnailScaleUpAnimation(View view) {
        //
        Bitmap thumbnail = BitmapFactory.decodeResource(view.getResources(), R.mipmap.ic_launcher);
        //
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeThumbnailScaleUpAnimation(view,
                thumbnail, 0, 0);
        ActivityCompat.startActivity(this, new Intent(this, CActivity.class),
                compat.toBundle());
    }


    private void makeSceneTransitionAnimation(View view) {
        ActivityOptionsCompat compat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                        view, "img");
        ActivityCompat.startActivity(this, new Intent(this,
                CActivity.class), compat.toBundle());
    }


}
