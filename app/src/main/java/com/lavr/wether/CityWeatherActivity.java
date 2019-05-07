package com.lavr.wether;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CityWeatherActivity extends AppCompatActivity {

    private TextView show_city_name, show_switchCompat_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_weather);
        show_city_name = findViewById(R.id.show_city_name);
        show_city_name.setText(getIntent().getStringExtra("city"));
        show_switchCompat_date = findViewById(R.id.show_switchCompat_date);
        show_switchCompat_date.setText(DateWeather.getTemperature());
        getDate();
    }

    public void getDate() {
        boolean [] showMoreDate;
        try {
            showMoreDate = getIntent().getExtras().getBooleanArray("date");
        }catch (Exception e) {
            e.printStackTrace();
            showMoreDate = null;
        }

        if (showMoreDate != null) {
            for (int i = 0; i < showMoreDate.length; i++) {
                if (showMoreDate[i] && i == 0) {
                    show_switchCompat_date.append("\n " + DateWeather.getWind() + ", " +
                            DateWeather.getWindDirection());
                }
                if (showMoreDate[i] && i == 1) {
                    show_switchCompat_date.append("\n " + DateWeather.getHumidity());
                }
                if (showMoreDate[i] && i == 2) {
                    show_switchCompat_date.append("\n " + DateWeather.getPressure());
                }
            }
        }
    }
}
