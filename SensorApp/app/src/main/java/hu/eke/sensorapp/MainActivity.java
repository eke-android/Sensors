package hu.eke.sensorapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView xTV;
    private TextView yTV;
    private TextView zTV;

    private ListView sensorList;
    private ArrayAdapter<Sensor> adapter;
    private List<Sensor> deviceSensors;

    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        xTV = (TextView) findViewById(R.id.x);
        yTV = (TextView) findViewById(R.id.y);
        zTV = (TextView) findViewById(R.id.z);

        sensorList = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<Sensor>(this, android.R.layout.simple_list_item_1, deviceSensors);
        sensorList.setAdapter(adapter);
    }
}

