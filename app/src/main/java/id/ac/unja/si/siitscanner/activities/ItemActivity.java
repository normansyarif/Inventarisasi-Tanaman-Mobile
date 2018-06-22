package id.ac.unja.si.siitscanner.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import id.ac.unja.si.siitscanner.R;
import id.ac.unja.si.siitscanner.common.QRCode;
import id.ac.unja.si.siitscanner.common.Url;

public class ItemActivity extends AppCompatActivity {
    TextView loc_name_text;
    TextView sci_name_text;
    TextView family_text;
    TextView loc_label;
    TextView sci_label;
    TextView family_label;
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
        loc_label = findViewById(R.id.loc_label);
        sci_label = findViewById(R.id.sci_label);
        family_label = findViewById(R.id.family_label);
        go_to_web_button = findViewById(R.id.go_to_web_button);

        helvetica = Typeface.createFromAsset(getAssets(), "fonts/helvetica.ttf");

        loc_label.setTypeface(helvetica);
        sci_label.setTypeface(helvetica);
        family_label.setTypeface(helvetica);

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

    private void showData(String jsonData) {

        String id = null;
        String loc_name = null;
        String sci_name = null;
        String family = null;

        try {
            JSONObject jObj = new JSONObject(jsonData);
            JSONObject itemObj = jObj.getJSONObject("item");
            id = itemObj.getString("id");
            loc_name = itemObj.getString("loc_name");
            sci_name = itemObj.getString("sci_name");
            family = itemObj.getString("family");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        loc_name_text.setText(loc_name);
        sci_name_text.setText(sci_name);
        family_text.setText(family);
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
}
