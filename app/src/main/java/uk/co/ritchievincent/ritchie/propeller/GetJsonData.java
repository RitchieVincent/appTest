package uk.co.ritchievincent.ritchie.propeller;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ritchie on 17/01/2017.
 */

class GetJsonData extends AsyncTask<String, Void, List<Person>> implements GetRawData.OnDownloadComplete {
    private static final String TAG = "GetJsonData";

    private List<Person> mPersonList = null;

    private String mBaseURL;

    private final OnDataAvailable mCallBack;

    interface OnDataAvailable {
        void onDataAvailable(List<Person> data, DownloadStatus status);
    }

    public GetJsonData(OnDataAvailable callBack, String baseURL) {
        Log.d(TAG, "GetJsonData: Called");
        mCallBack = callBack;
        mBaseURL = baseURL;
    }

//    void executeOnSameThread(String searchCriteria) {
//        Log.d(TAG, "executeOnSameThread: Starts");
//
//        GetRawData getRawData = new GetRawData(this);
//        getRawData.execute(destinationUri);
//        Log.d(TAG, "executeOnSameThread: ends");
//    }

    @Override
    protected void onPostExecute(List<Person> persons) {
        super.onPostExecute(persons);
    }

    @Override
    protected List<Person> doInBackground(String... params) {
        return null;
    }

    @Override
    public void onDownloadComplete(String data, DownloadStatus status) {
        Log.d(TAG, "onDownloadComplete: starts. Status = " + status);

        if (status == DownloadStatus.OK) {
            mPersonList = new ArrayList<>();
            try {
                JSONArray itemsArray = new JSONArray(data);

                for (int i = 0; i < itemsArray.length(); i++) {
                    JSONObject jsonPerson = itemsArray.getJSONObject(i);
                    String id = jsonPerson.getString("id");
                    String firstName = jsonPerson.getString("name");
                    String lastName = jsonPerson.getString("lastname");
                    String team = jsonPerson.getString("team");
                    String email = jsonPerson.getString("email");
                    String ext = jsonPerson.getString("ext");
                    String position = jsonPerson.getString("position");
                    String image = jsonPerson.getString("image");
                    String office = jsonPerson.getString("office");
                    String film = jsonPerson.getString("film");
                    String song = jsonPerson.getString("song");
                    String holiday = jsonPerson.getString("holiday");

                    Person personObject = new Person(id, firstName, lastName, team, email, ext, position, image, office, film, song, holiday);
                    mPersonList.add(personObject);

                    Log.d(TAG, "onDownloadComplete" + personObject.toString());
                }
            } catch (JSONException jsone) {
                jsone.printStackTrace();
                Log.e(TAG, "onDownloadComplete: Error processing JSON data " + jsone.getMessage());
                status = DownloadStatus.FAILED_OR_EMPTY;
            }
        }

        if (mCallBack != null) {
            mCallBack.onDataAvailable(mPersonList, status);
        }

        Log.d(TAG, "onDownloadComplete: Ends");
    }
}
