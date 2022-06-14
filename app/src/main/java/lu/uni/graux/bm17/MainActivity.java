package lu.uni.graux.bm17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.widget.TextView;

import lu.uni.graux.bm17.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private String imei;
    private String notImei;

    static private String staticImei;
    static private String staticNotImei;

    static {
        System.loadLibrary("bm17");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.notImei = "Hello";
        MainActivity.staticNotImei = "world!";

        this.imei = Settings.Secure.getString(this.getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        MainActivity.staticImei = Settings.Secure.getString(this.getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        this.fieldCopyUsingJNI();

        TextView tv = binding.sampleText;
        tv.setText(this.notImei + " " + MainActivity.staticNotImei);
    }

    public native void fieldCopyUsingJNI();
}