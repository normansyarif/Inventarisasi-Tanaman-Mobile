package id.ac.unja.si.siitscanner.activities;

<<<<<<< HEAD
import android.annotation.SuppressLint;
=======
>>>>>>> 584291d28920092630ef15ee14d586fba8e541b2
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
<<<<<<< HEAD
import android.widget.Toast;
=======
>>>>>>> 584291d28920092630ef15ee14d586fba8e541b2

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import id.ac.unja.si.siitscanner.R;
import id.ac.unja.si.siitscanner.common.QRCode;
import id.ac.unja.si.siitscanner.common.Url;
<<<<<<< HEAD
import id.ac.unja.si.siitscanner.common.Time;

public class ItemActivity extends AppCompatActivity {
    TextView loc_name_text, sci_name_text, family_text, age_text,
            age_label, loc_label, sci_label, family_label;
=======

public class ItemActivity extends AppCompatActivity {
    TextView loc_name_text;
    TextView sci_name_text;
    TextView family_text;
    TextView loc_label;
    TextView sci_label;
    TextView family_label;
>>>>>>> 584291d28920092630ef15ee14d586fba8e541b2
    Button go_to_web_button;
    String link;
    Typeface helvetica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        loc_name_text = findViewById(R.id.loc_name_text);
        sci_name_text = findViewById(R.id.sci_name_text);
        family_text = findViewById(R.id.family_text);
<<<<<<< HEAD
        age_text = findViewById(R.id.age_text);
        age_label = findViewById(R.id.age_label);
=======
>>>>>>> 584291d28920092630ef15ee14d586fba8e541b2
        loc_label = findViewById(R.id.loc_label);
        sci_label = findViewById(R.id.sci_label);
        family_label = findViewById(R.id.family_label);
        go_to_web_button = findViewById(R.id.go_to_web_button);

        helvetica = Typeface.createFromAsset(getAssets(), "fonts/helvetica.ttf");

        loc_label.setTypeface(helvetica);
        sci_label.setTypeface(helvetica);
        family_label.setTypeface(helvetica);
<<<<<<< HEAD
        age_label.setTypeface(helvetica);
=======
>>>>>>> 584291d28920092630ef15ee14d586fba8e541b2

        getData();
    }

    private void getData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            showData(extras.getString("data"));
        }
    }

    public void OnGoToWebClicked(View v) {
        Intent intent = new Intent(ItemActivity.this, WebViewActivity.class);
        intent.putExtra("link", link);
        startActivity(intent);
    }

<<<<<<< HEAD
    @SuppressLint("SetTextI18n")
    private void showData(String jsonData) {

        int id = 0;
        String loc_name = "";
        String sci_name = "";
        String family = "";
        String planted_date = "";
=======
    private void showData(String jsonData) {

        int id = 0;
        String loc_name = null;
        String sci_name = null;
        String family = null;
>>>>>>> 584291d28920092630ef15ee14d586fba8e541b2

        try {
            JSONObject jObj = new JSONObject(jsonData);
            JSONObject itemObj = jObj.getJSONObject("item");
            id = itemObj.getInt("id");
<<<<<<< HEAD
            loc_name = itemObj.getString("ln"); // Local name
            sci_name = itemObj.getString("sn"); // Scientific name
            family = itemObj.getString("fm"); // Family
            planted_date = itemObj.getString("pd"); // Planted date
=======
            loc_name = itemObj.getString("nama_lokal");
            sci_name = itemObj.getString("spesies");
            family = itemObj.getString("famili");

>>>>>>> 584291d28920092630ef15ee14d586fba8e541b2
        } catch (JSONException e) {
            e.printStackTrace();
        }

        loc_name_text.setText(loc_name);
        sci_name_text.setText(sci_name);
        family_text.setText(family);
<<<<<<< HEAD

        if(planted_date.equals("null") || planted_date.equals("")) age_text.setText("-");
        else age_text.setText(Time.getPlantAge(planted_date) + " tahun");

=======
>>>>>>> 584291d28920092630ef15ee14d586fba8e541b2
        link = Url.getUrl() + id;
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
                showData(result.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
<<<<<<< HEAD


=======
>>>>>>> 584291d28920092630ef15ee14d586fba8e541b2
}
