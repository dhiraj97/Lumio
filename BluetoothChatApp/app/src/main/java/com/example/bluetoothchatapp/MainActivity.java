package com.example.bluetoothchatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;
    //provides functionalities like switching BT, getting paired devices and more
    private BluetoothAdapter bluetoothAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        //Initializing bluetooth adapter
        initBluetooth();
    }

    private void initBluetooth() {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        //Checking if bluetooth exists in device
        if(bluetoothAdapter == null)
        {
            Toast.makeText(context, "No Bluetooth Found",Toast.LENGTH_SHORT).show();
        }
    }

    private void enableBluetooth() {
        if(bluetoothAdapter.isEnabled()) {
            Toast.makeText(context,"Bluetooth Already Enabled", Toast.LENGTH_SHORT).show();
        } else {
            bluetoothAdapter.enable();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_search_devices:
                Toast.makeText(context, "Search Devices", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_enable_bt:
                enableBluetooth();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}