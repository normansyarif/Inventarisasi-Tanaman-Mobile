package id.ac.unja.si.siitscanner.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
<<<<<<< HEAD
import android.widget.Toast;
=======
>>>>>>> 584291d28920092630ef15ee14d586fba8e541b2

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

<<<<<<< HEAD
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

=======
>>>>>>> 584291d28920092630ef15ee14d586fba8e541b2
import id.ac.unja.si.siitscanner.R;
import id.ac.unja.si.siitscanner.common.QRCode;
import id.ac.unja.si.siitscanner.common.ZXingOrientation;

<<<<<<< HEAD
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

=======
>>>>>>> 584291d28920092630ef15ee14d586fba8e541b2
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
<<<<<<< HEAD

=======
>>>>>>> 584291d28920092630ef15ee14d586fba8e541b2
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
<<<<<<< HEAD

=======
>>>>>>> 584291d28920092630ef15ee14d586fba8e541b2
}
