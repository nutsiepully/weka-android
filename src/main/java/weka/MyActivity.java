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

        System.out.println("In Weka Activity. Started. yaay!");
    }
}
