package ru.alexmikh.summary;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public abstract class AppActivity extends Activity {

    private static final String LOG_TAG = "Summary";

    private final String className;
    final Person data = new Person();

    public AppActivity() {
        super();
        this.className = this.getClass().getName();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        debugEvent("onCreate");
    }

    @Override
    protected void onStart() {
        debugEvent("onStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        debugEvent("onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        debugEvent("onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        debugEvent("onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        debugEvent("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        debugEvent("onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        debugEvent("onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        debugEvent("onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        debugEvent("onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean isFinishing() {
        debugEvent("isFinishing");
        return super.isFinishing();
    }

    @Override
    public void finish() {
        debugEvent("finish");
        super.finish();
    }

    @Override
    public void onLowMemory() {
        debugEvent("onLowMemory");
        super.onLowMemory();
    }

    //
    // logging helper
    //
    private void debugEvent(String method) {
        Log.d(LOG_TAG, " -> " + method + " " + className);
    }
}
