package id.ac.unja.si.siitscanner.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import id.ac.unja.si.siitscanner.R;
import id.ac.unja.si.siitscanner.common.Url;

public class ItemActivity extends AppCompatActivity {
    TextView loc_name_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        loc_name_text = findViewById(R.id.loc_name_text);

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

    private void showData(String id, String loc_name, String sci_name, String family) {
        loc_name_text.setText(Url.ITEM_URL + id + loc_name + sci_name + family);
    }
}
