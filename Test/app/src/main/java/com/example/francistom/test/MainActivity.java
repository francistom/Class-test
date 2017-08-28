package com.example.francistom.test;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;

import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    public void sendMessage(View view)
    {
        Intent intent = new Intent(MainActivity.this, ToActivity.class);
        startActivity(intent);
    }
    private int on = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }

    @Override
    protected void onResume() {
        super.onResume();
        if(on==1) return;
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if(sensorManager != null && sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);
        }
        else {
            Toast.makeText(getApplicationContext(), "Accelerometer Error", Toast.LENGTH_LONG).show();
            System.exit(1);
        }
        if(sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) != null) {
            Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);
        }
        else {
            Toast.makeText(getApplicationContext(), "Gyroscope Error", Toast.LENGTH_LONG).show();
            System.exit(1);
        }
        if(sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null) {
            Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);
        }
        else {
            Toast.makeText(getApplicationContext(), "Magnetometer Error", Toast.LENGTH_LONG).show();
            System.exit(1);
        }

        if(sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null) {
            Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);
        }
        else {
            Toast.makeText(getApplicationContext(), "Light sensor error Error", Toast.LENGTH_LONG).show();
            System.exit(1);
        }

    }

    @Override
    protected void onPause() {
        if(on==1) {
            super.onPause();
            return;
        }
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if(sensorManager != null && sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.unregisterListener(this, sensor);
        }
        else {
            Toast.makeText(getApplicationContext(), "Accelerometer Error", Toast.LENGTH_LONG).show();
            System.exit(1);
        }
        if(sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) != null) {
            Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
            sensorManager.unregisterListener(this, sensor);
        }
        else {
            Toast.makeText(getApplicationContext(), "Gyroscope Error", Toast.LENGTH_LONG).show();
            System.exit(1);
        }
        if(sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null) {
            Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
            sensorManager.unregisterListener(this, sensor);
        }
        else {
            Toast.makeText(getApplicationContext(), "Magnetometer Error", Toast.LENGTH_LONG).show();
            System.exit(1);
        }
        if(sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null) {
            Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            sensorManager.unregisterListener(this, sensor);
        }
        else {
            Toast.makeText(getApplicationContext(), "Light sensor Error", Toast.LENGTH_LONG).show();
            System.exit(1);
        }

        super.onPause();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent==null) return;
        if(sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
            TextView xtv = (TextView) findViewById(R.id.ax);
            TextView ytv = (TextView) findViewById(R.id.ay);
            TextView ztv = (TextView) findViewById(R.id.az);
            xtv.setText(String.format(Locale.getDefault(), "%.9f", x));
            ytv.setText(String.format(Locale.getDefault(), "%.9f", y));
            ztv.setText(String.format(Locale.getDefault(), "%.9f", z));
        }
        if(sensorEvent.sensor.getType()==Sensor.TYPE_GYROSCOPE) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
            TextView xtv = (TextView) findViewById(R.id.gx);
            TextView ytv = (TextView) findViewById(R.id.gy);
            TextView ztv = (TextView) findViewById(R.id.gz);
            xtv.setText(String.format(Locale.getDefault(), "%.9f", x));
            ytv.setText(String.format(Locale.getDefault(), "%.9f", y));
            ztv.setText(String.format(Locale.getDefault(), "%.9f", z));
        }
        if(sensorEvent.sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
            TextView xtv = (TextView) findViewById(R.id.mx);
            TextView ytv = (TextView) findViewById(R.id.my);
            TextView ztv = (TextView) findViewById(R.id.mz);
            xtv.setText(String.format(Locale.getDefault(), "%.9f", x));
            ytv.setText(String.format(Locale.getDefault(), "%.9f", y));
            ztv.setText(String.format(Locale.getDefault(), "%.9f", z));
        }

        if(sensorEvent.sensor.getType()==Sensor.TYPE_LIGHT) {
            float x = sensorEvent.values[0];


            TextView lx = (TextView) findViewById(R.id.lx);

            lx.setText(String.format(Locale.getDefault(), "%.9f", x));

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}

