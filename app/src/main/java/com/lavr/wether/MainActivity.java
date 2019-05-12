package com.lavr.wether;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView title;
    private EditText write_city_name;
    private SwitchCompat [] switchCompat = new SwitchCompat[3];
    private boolean [] showMoreDate = new boolean[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        write_city_name = findViewById(R.id.write_city_name);
        switchCompat[0] = findViewById(R.id.switch_damp);
        switchCompat[1] = findViewById(R.id.switch_pressure);
        switchCompat[2] = findViewById(R.id.switch_wind);

    }
    public void onClickButtonShowCityWeather(View view) {
        Intent intent = new Intent(this, CityWeatherActivity.class);
        intent.putExtra("city", write_city_name.getText().toString());
        getDateFromSwitchCompat();
        intent.putExtra("date", showMoreDate);
        this.startActivity(intent);
    }

    public void getDateFromSwitchCompat() {
        for (int i = 0; i < showMoreDate.length; i++) {
            showMoreDate[i] = switchCompat[i].isChecked();
        }
    }
}
