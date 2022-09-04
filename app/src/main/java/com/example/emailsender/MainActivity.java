package com.example.emailsender;
import static android.Manifest.permission.WRITE_VOICEMAIL;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private AlertDialog alert;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alert = new AlertDialog.Builder(this)
                .setMessage("You need to allow access to both the permissions")
                .setPositiveButton("OK", (dialogInterface, i) -> UserPermissions.requestPermissions(this))
                .setNegativeButton("Cancel", (dialogInterface, i) -> finish())
                .create();
    }
//
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == UserPermissions.PERMISSION_ID) {
            if (grantResults.length > 0) {
                if (UserPermissions.checkPermissions(this)) {
                    Snackbar.make(findViewById(R.id.send), "Grant permissions", Snackbar.LENGTH_LONG).show();
                } else {
                    if (shouldShowRequestPermissionRationale(WRITE_VOICEMAIL)) {
                        alert.show();
                    }
                    Snackbar.make(findViewById(R.id.send), "Denied permissions", Snackbar.LENGTH_LONG).show();
                }
            }
        }
    }
    public void btnSendMessage(View view)
    {
        if(!UserPermissions.checkPermissions(this))
            UserPermissions.requestPermissions(this);
    }
}