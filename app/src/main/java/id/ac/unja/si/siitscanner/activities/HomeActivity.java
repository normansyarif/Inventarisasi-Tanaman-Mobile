package id.ac.unja.si.siitscanner.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import id.ac.unja.si.siitscanner.R;
import id.ac.unja.si.siitscanner.common.QRCode;
import id.ac.unja.si.siitscanner.common.ZXingOrientation;

public class HomeActivity extends AppCompatActivity {
    TextView welcomeText;
    TextView instructionText;
    Typeface helvetica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(id.ac.unja.si.siitscanner.R.layout.activity_home);
        welcomeText = findViewById(R.id.welcomeText);
        instructionText = findViewById(R.id.instructionText);

        helvetica = Typeface.createFromAsset(getAssets(), "fonts/helvetica.ttf");

        welcomeText.setTypeface(helvetica);
        instructionText.setTypeface(helvetica);
    }

    public void scanButtonClicked(View v) {
        QRCode qrCode = new QRCode(this);
        qrCode.integrator();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                Intent i = new Intent(HomeActivity.this, ItemActivity.class);
                i.putExtra("data", result.getContents());
                startActivity(i);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
