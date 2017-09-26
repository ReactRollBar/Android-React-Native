package rollbar.com.example;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rollbar.RollbarReactNative;
import com.rollbar.android.Rollbar;
import com.rollbar.android.RollbarExceptionHandler;
import com.rollbar.android.RollbarThread;

public class MainActivity extends AppCompatActivity {
    private Button crashButton;
    private Context context;
    //
    private String ACCESS_TOKEN="084353b783e84e78a14647932b859000";
    private String ACCESS_MODE="production";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
      /*  Rollbar.init(this, "084353b783e84e78a14647932b859000", "production");
     //   Rollbar.init(this, "0cd4844355b64b6baec0d5aa65d960bb", "production");
        Rollbar.reportMessage("A test message", "debug");*/
        //React Native Class
        RollbarReactNative.start(context,ACCESS_TOKEN,ACCESS_MODE);
        crashButton = (Button) findViewById(R.id.crashButton);
        crashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    throw new RuntimeException("This is a crash");
            }
        });



    }
}
