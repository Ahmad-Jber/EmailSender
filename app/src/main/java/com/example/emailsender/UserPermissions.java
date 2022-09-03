package com.example.emailsender;
import static android.Manifest.permission;
import static android.Manifest.permission.ACCESS_NETWORK_STATE;
import static android.Manifest.permission.ACCESS_WIFI_STATE;
import static android.Manifest.permission.INTERNET;
import static android.Manifest.permission.WRITE_VOICEMAIL;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class UserPermissions {
    public static final int PERMISSION_ID=200;
    private static final String [] PERMISSIONS= new String[]{WRITE_VOICEMAIL, ACCESS_NETWORK_STATE, ACCESS_WIFI_STATE, INTERNET};
    public static boolean checkPermissions(Context context){
        return ContextCompat.checkSelfPermission(context, PERMISSIONS[0]) == PERMISSION_GRANTED&&ContextCompat.checkSelfPermission(context, PERMISSIONS[1]) == PERMISSION_GRANTED&&ContextCompat.checkSelfPermission(context, PERMISSIONS[2]) == PERMISSION_GRANTED&&ContextCompat.checkSelfPermission(context, PERMISSIONS[3]) == PERMISSION_GRANTED;
    }
    public static void requestPermissions(Activity activity){
        ActivityCompat.requestPermissions(activity,PERMISSIONS,PERMISSION_ID);
    }

    public static String[] getPERMISSIONS() {
        return PERMISSIONS;
    }
    public static boolean hasAllPermissionsGranted(@NonNull int[] grantResults) {
        return grantResults[0] == PERMISSION_GRANTED && grantResults[1] == PERMISSION_GRANTED && grantResults[2] == PERMISSION_GRANTED && grantResults[3] == PERMISSION_GRANTED;
    }
}