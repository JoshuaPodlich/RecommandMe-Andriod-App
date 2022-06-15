package com.example.androidreccomendme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import static com.example.androidreccomendme.utils.URL_Processor.*;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * The VideoPage class creates and inflates the VideoPage activity in order to display an Item's video
 *
 * @author  Caelan Herzberg
 */
public class VideoPage extends AppCompatActivity {

    @Override
    /**
     * The onCreate method creates and inflates VideoPage activity. Uses a VideoView in order to display video.
     * @param Bundle
     * @author Caelan Herzberg
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        setContentView(R.layout.activity_video_page);
        WebView videoView = findViewById(R.id.webview);



        //VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        String videoURL = i.getStringExtra("URL");
        videoURL = Unpack(videoURL);
        Uri video = Uri.parse(videoURL);

        videoView.loadUrl(videoURL);

       // videoView.setMediaController(mediaController);
        //videoView.setVideoURI(video);
        //videoView.start();

        /*
        String url = i.getStringExtra("theVideo");
        videoView.setVideoPath(url);
        videoView.start();
        */

    }
}