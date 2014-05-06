package weka;

import android.app.Activity;
import android.os.Bundle;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StringBufferInputStream;

import aware.weka.R;
import weka.classifiers.bayes.NaiveBayesUpdateable;

public class MyActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        System.out.println("In here. yaay!");

        HttpClient httpClient = new DefaultHttpClient();
        String result;
        try {
            result = httpClient.execute(
                    new HttpGet("http://128.237.223.111:9979/ml_server/model/get"), new BasicResponseHandler());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new StringBufferInputStream(result));
            NaiveBayesUpdateable naiveBayesUpdateable = (NaiveBayesUpdateable)ois.readObject();
            System.out.println(naiveBayesUpdateable.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
