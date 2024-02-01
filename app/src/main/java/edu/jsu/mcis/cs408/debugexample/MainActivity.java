package edu.jsu.mcis.cs408.debugexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import edu.jsu.mcis.cs408.debugexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;

    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        counter = 1;

        binding.incButton.setOnClickListener(this);
        binding.decButton.setOnClickListener(this);

        updateCounter();

        Log.d(TAG, "This is a DEBUG message at the end of onCreate()");

    }

    @Override
    public void onClick(View view) {

        Log.i(TAG, "Button Clicked!");

        String buttonTag = view.getTag().toString();

        if (buttonTag.equals("incButton")) {
            Log.i(TAG, "Counter Incremented!");
            counter++;
        }
        else if (buttonTag.equals("decButton")) {
            Log.i(TAG, "Counter Decremented!");
            counter--;
        }

        updateCounter();

    }

    private void updateCounter() {
        binding.output.setText(String.valueOf(counter));
    }

}