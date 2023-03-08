package controllers;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Models.timeSeriesData;

public class sensorDataRetreiver {

    private timeSeriesData tsData;
    private OnDataRetrievedListener listener;

    public sensorDataRetreiver(OnDataRetrievedListener listener) {
        this.listener = listener;
    }

    public void retrieveData() {
        new RetrieveDataTask().execute();
    }

    private class RetrieveDataTask extends AsyncTask<Void, Void, timeSeriesData> {

        private String errorMessage;

        @Override
        protected timeSeriesData doInBackground(Void... voids) {
            String inputLine = "";
            try {
                URL obj = new URL("http://192.168.2.22/getData");
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");
                int responseCode = con.getResponseCode();
                System.out.println("GET Response Code :: " + responseCode);
                if (responseCode == HttpURLConnection.HTTP_OK) { // success
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    // print result
                    Log.d("sensorDataRetriever", response.toString());
                    if (responseCode == 200) {
                        Gson gson = new Gson();
                        return gson.fromJson(response.toString(), timeSeriesData.class);
                    } else {
                        errorMessage = "GET request did not work.";
                    }

                } else {
                    errorMessage = "GET request did not work.";
                }

            } catch (Exception e) {
                errorMessage = "Error: " + e.getMessage();
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(timeSeriesData result) {
            if (result != null) {
                tsData = result;
                listener.onDataRetrieved(tsData);
            } else {
                Log.e("sensorDataRetriever", errorMessage);
            }
        }
    }

    public timeSeriesData getTsData() {
        return tsData;
    }

    public void setTsData(timeSeriesData tsData) {
        this.tsData = tsData;
    }

    public interface OnDataRetrievedListener {
        void onDataRetrieved(timeSeriesData data);
    }
}