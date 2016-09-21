package br.org.eldorado.workshop2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {
    TextView textViewLightSensor;
    TextView textViewGyroSensor;
    TextView textViewAccelerometerSensor;

    SensorManager sensorManager;
    Sensor lightSensor;
    Sensor gyroSensor;
    Sensor accelerometerSensor;

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch (event.sensor.getType()) {
            case Sensor.TYPE_LIGHT:
                textViewLightSensor.setText("LIGHT: " + event.values[0]);
                break;
            case Sensor.TYPE_GYROSCOPE:
                textViewGyroSensor.setText(String.format("GYRO: (%2.2f, %2.2f, %2.2f)", event.values[0], event.values[1], event.values[2]));
                break;
            case Sensor.TYPE_ACCELEROMETER:
                textViewAccelerometerSensor.setText(String.format("ACCELEROMETER: (%2.2f, %2.2f, %2.2f)", event.values[0], event.values[1], event.values[2]));
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        textViewLightSensor = (TextView) findViewById(R.id.textViewLightSensor);
        textViewGyroSensor = (TextView) findViewById(R.id.textViewGyroSensor);
        textViewAccelerometerSensor = (TextView) findViewById(R.id.textViewAccelerometerSensor);
    }

    @Override
    protected void onResume() {
        super.onResume();

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        gyroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (lightSensor != null) {
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (gyroSensor != null) {
            sensorManager.registerListener(this, gyroSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (accelerometerSensor != null) {
            sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
