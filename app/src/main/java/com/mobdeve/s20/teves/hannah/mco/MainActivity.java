package com.mobdeve.s20.teves.hannah.mco;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private List<HomeDailiesData> dailyTasks;
    private HomePageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dailyTasks = HomeDailiesData.getData();
        adapter = new HomePageAdapter(dailyTasks, this::showEditDialog, this::deleteTask);

        fab = findViewById(R.id.addFab);
        fab.setVisibility(View.VISIBLE); // Ensure fab is visible
        fab.setOnClickListener(fabView -> showAddDialog()); // Set click listener

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                selectedFragment = new HomeFragment(dailyTasks, adapter);
                fab.setVisibility(View.VISIBLE);
                fab.setOnClickListener(fabView -> showAddDialog()); // Set click listener
            } else {
                fab.setVisibility(View.GONE);
                if (itemId == R.id.nav_char) {
                    selectedFragment = new CharFragment();
                } else if (itemId == R.id.nav_weapon) {
                    selectedFragment = new WeaponFragment();
                } else if (itemId == R.id.nav_settings) {
                    selectedFragment = new SettingsFragment();
                }
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }

            return true;
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment(dailyTasks, adapter)).commit();
    }

    private void showAddDialog() {
        showDialog(null);
    }

    private void showEditDialog(HomeDailiesData data) {
        showDialog(data);
    }

    private void showDialog(HomeDailiesData data) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(data == null ? "Add Task" : "Edit Task");

        View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_add_task, null);
        builder.setView(dialogView);

        EditText taskNameInput = dialogView.findViewById(R.id.taskNameInput);
        TimePicker timePicker = dialogView.findViewById(R.id.timePicker);

        if (data != null) {
            taskNameInput.setText(data.task);
            String[] timeParts = data.time.split("[: ]");
            int hour = Integer.parseInt(timeParts[0]);
            int minute = Integer.parseInt(timeParts[1]);
            boolean isPM = "PM".equals(timeParts[2]);
            if (isPM && hour != 12) hour += 12;
            if (!isPM && hour == 12) hour = 0;
            timePicker.setHour(hour);
            timePicker.setMinute(minute);
        }

        builder.setPositiveButton(data == null ? "Add" : "Save", null);
        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v -> {
            String taskName = taskNameInput.getText().toString().trim();
            if (taskName.isEmpty()) {
                Toast.makeText(MainActivity.this, "Task name cannot be empty!", Toast.LENGTH_SHORT).show();
            } else {
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();
                String time = String.format("%02d:%02d %s", (hour % 12 == 0) ? 12 : hour % 12, minute, (hour >= 12) ? "PM" : "AM");

                if (data == null) {
                    HomeDailiesData.addTask(dailyTasks, time, taskName);
                } else {
                    data.time = time;
                    data.task = taskName;
                }

                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, data == null ? "Task added!" : "Task updated!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }

    private void deleteTask(int position) {
        new AlertDialog.Builder(this)
                .setTitle("Confirm Deletion")
                .setMessage("Are you sure you want to delete this task?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    adapter.removeItem(position);
                    Toast.makeText(MainActivity.this, "Task deleted!", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                .show();
    }
}