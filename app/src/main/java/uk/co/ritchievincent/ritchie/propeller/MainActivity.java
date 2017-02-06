package uk.co.ritchievincent.ritchie.propeller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements GetJsonData.OnDataAvailable {
    private static final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: starts");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        GetRawData getRawData = new GetRawData(this);
//        getRawData.execute("http://proppages.dev/profiles/all");

        Log.d(TAG, "onCreate: ends");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: starts");
        super.onResume();
        GetJsonData getJsonData = new GetJsonData(this, "http://proppages.dev/profiles/all");
//        getJsonData.executeOnSameThread("");
        Log.d(TAG, "onResume: ends");
    }

    @Override
    public void onDataAvailable(List<Person> data, DownloadStatus status) {
        if (status == DownloadStatus.OK) {
            Log.d(TAG, "onDataAvailable: data is " + data);
        } else {
            Log.e(TAG, "onDataAvailable: failed with status" + status);
        }
    }

}
