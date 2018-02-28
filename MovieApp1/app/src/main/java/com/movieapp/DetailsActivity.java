package com.movieapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.HashMap;
import java.util.List;

public class DetailsActivity extends Activity {

    TextView txttitle,txttime,txtmsg,txtsource,overview;
            RatingBar ratingBar ;
            ImageView imgposter ;

            Globals globals;

    ImageLoaderConfiguration config;
    ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        inItViews();
    }

    private void inItViews() {
        globals = (Globals) getApplicationContext();
        String pos = getIntent().getStringExtra("position");
        int postion = Integer.parseInt(pos);
        txttitle =  findViewById(R.id.txttitle);
        txttime= findViewById(R.id.txttime);
        txtmsg= findViewById(R.id.txtmsg);
        imgposter= findViewById(R.id.imgposter);
        ratingBar= findViewById(R.id.ratingBar);
        txtsource =  findViewById(R.id.txtsource);
        overview =  findViewById(R.id.overview);


        List<HashMap<String,String>> list = globals.getMovieList();
        if(list!=null) {
            String title = list.get(postion).get("title");
            String time = list.get(postion).get("theater");
            String message = list.get(postion).get("synopsis");
            String source = list.get(postion).get("source");
            String overvi = list.get(postion).get("overview");


            txttitle.setText(title);
            txttime.setText(time);
            txtmsg.setText(message);
            txtsource.setText(source);
            overview.setText(overvi);
        }


        config = new ImageLoaderConfiguration.Builder(DetailsActivity.this).build();
        ImageLoader.getInstance().init(config);
        imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(list.get(postion).get("img_url"), imgposter);


        int r = Integer.parseInt(list.get(postion).get("audience_score"));
        Log.e("rating", r + "");

        float d = (float) ((r * 5) / 100);

        if (r < 20) {
            ratingBar.setRating(d);
        }
        if (r < 40) {
            ratingBar.setRating(d);
        }
        if (r < 60) {
            ratingBar.setRating(d);
        }
        if (r < 80) {
            ratingBar.setRating(d);
        }
        if (r < 100) {
            ratingBar.setRating(d);
        }
        if (r == 100) {
            ratingBar.setRating(d);
        }



    }
}
