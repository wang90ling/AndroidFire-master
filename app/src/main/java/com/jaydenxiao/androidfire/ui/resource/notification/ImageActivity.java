package com.jaydenxiao.androidfire.ui.resource.notification;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.jaydenxiao.androidfire.R;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        PhotoViewAttacher attacher = new PhotoViewAttacher(imageView);
    }
}
