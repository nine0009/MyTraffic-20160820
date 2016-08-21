package nd.boonyavantang.woramate.ndtraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    // explicit or variable ประกาศตัวแปล
    private ListView trafficListView;
    private Button aboutMeButton;
    private static final String urlYouTube = "https://youtu.be/SqivSUNDfqI";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //this statement
        setContentView(R.layout.activity_main);
        // bind widget
        trafficListView = (ListView) findViewById(R.id.listView);
        aboutMeButton = (Button) findViewById(R.id.button);

        // get event from click button
        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sound effect
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.phonton2);
                mediaPlayer.start();

                //intent to WebView
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlYouTube));
                startActivity(intent);


            }   //on click
        });

        // create listview
        // 1.setup basic array
        final int[] iconInts = new int[20];
        iconInts[0] = R.drawable.traffic_01;
        iconInts[1] = R.drawable.traffic_02;
        iconInts[2] = R.drawable.traffic_03;
        iconInts[3] = R.drawable.traffic_04;
        iconInts[4] = R.drawable.traffic_05;
        iconInts[5] = R.drawable.traffic_06;
        iconInts[6] = R.drawable.traffic_07;
        iconInts[7] = R.drawable.traffic_08;
        iconInts[8] = R.drawable.traffic_09;
        iconInts[9] = R.drawable.traffic_10;
        iconInts[10] = R.drawable.traffic_11;
        iconInts[11] = R.drawable.traffic_12;
        iconInts[12] = R.drawable.traffic_13;
        iconInts[13] = R.drawable.traffic_14;
        iconInts[14] = R.drawable.traffic_15;
        iconInts[15] = R.drawable.traffic_16;
        iconInts[16] = R.drawable.traffic_17;
        iconInts[17] = R.drawable.traffic_18;
        iconInts[18] = R.drawable.traffic_19;
        iconInts[19] = R.drawable.traffic_20;

        // 2.setup array from other class
        MyData myData = new MyData();
        final String[] titleStrings = myData.getTitleStrings();

        // 3.setup array from other xml
        final String[] detailStrings=getResources().getStringArray(R.array.detail);
        int[] ints = myData.getInts();
        String[] stockStrings = new String[ints.length];
        String[] priceStrings = new String[ints.length];
        for (int i=0;i<ints.length;i+=1) {
            stockStrings[i] = "Stock =" + Integer.toString(ints[i]);
            priceStrings[i]=Integer.toString(ints[i])+" บาท";

        } //for



        // sub string
        String[] detailShortStrings = new String[detailStrings.length];
        for (int i=0; i<detailStrings.length; i+=1){
            detailShortStrings[i]=detailStrings[i].substring(0,40)+"...";

        } //for

        TrafficAdapter trafficAdapter = new TrafficAdapter(this, iconInts, titleStrings, detailShortStrings, stockStrings, priceStrings);
        trafficListView.setAdapter(trafficAdapter);

        //onClick ListView
        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Intent to Detail Activity
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("Title", titleStrings[i]);
                intent.putExtra("Icon", iconInts[i]);
                intent.putExtra("Detail", detailStrings[i]);
                startActivity(intent);



            } //onClick ListView
        });


    }   //main method
}   //main class
