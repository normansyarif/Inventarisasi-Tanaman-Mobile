package id.ac.unja.si.siitscanner.activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import id.ac.unja.si.siitscanner.R;
import id.ac.unja.si.siitscanner.common.Url;

public class ItemActivity extends AppCompatActivity {
    TextView loc_name_text;
    TextView sci_name_text;
    TextView family_text;
    Button go_to_web_button;
    String link;
    // Typeface helvetica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        loc_name_text = findViewById(R.id.loc_name_text);
        sci_name_text = findViewById(R.id.sci_name_text);
        family_text = findViewById(R.id.family_text);
        go_to_web_button = findViewById(R.id.go_to_web_button);

        // helvetica = Typeface.createFromAsset(getAssets(), "fonts/helvetica.ttf");

        getDataFromHome();
    }

    private void getDataFromHome() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                JSONObject jObj = new JSONObject(extras.getString("data"));
                JSONObject itemObj = jObj.getJSONObject("item");
                String id = itemObj.getString("id");
                String loc_name = itemObj.getString("loc_name");
                String sci_name = itemObj.getString("sci_name");
                String family = itemObj.getString("family");

                showData(id, loc_name, sci_name, family);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void OnGoToWebClicked(View v) {
        Toast.makeText(this, link, Toast.LENGTH_SHORT).show();
    }

    private void showData(String id, String loc_name, String sci_name, String family) {
        loc_name_text.setText(loc_name);
        sci_name_text.setText(sci_name);
        family_text.setText(family);
        link = Url.ITEM_URL + id;
    }
}
