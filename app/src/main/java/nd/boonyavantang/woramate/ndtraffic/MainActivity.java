package nd.boonyavantang.woramate.ndtraffic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    // explicit or variable ประกาศตัวแปล
    private ListView trafficListView;
    private Button aboutMeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //this statement
        setContentView(R.layout.activity_main);
        // bind widget
        trafficListView= (ListView) findViewById(R.id.listView);
        aboutMeButton= (Button) findViewById(R.id.button);

        // get event from click button
        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sound effect
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.phonton2);
                mediaPlayer.start();

                //intent to WebView



            }   //on click
        });

    }   //main method
}   //main class
