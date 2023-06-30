package com.unity3d.player

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.util.Log
import android.view.InputDevice
import android.view.MotionEvent
import android.widget.FrameLayout
import com.unity3d.player.UnityPlayerForActivityOrService
import com.xraph.plugin.flutter_unity_widget.UnityPlayerUtils

@SuppressLint("NewApi")
internal class CustomUnityFrameLayout(context: Context, player: UnityPlayerForActivityOrService) : com.unity3d.player.t(context, player) {

    companion object {
        internal const val LOG_TAG = "CustomUnityPlayer"
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        Log.i(LOG_TAG, "ORIENTATION CHANGED")
        super.onConfigurationChanged(newConfig)
    }

    override fun onAttachedToWindow() {
        Log.i(LOG_TAG, "onAttachedToWindow")
        super.onAttachedToWindow()
        UnityPlayerUtils.resume()
        UnityPlayerUtils.pause()
        UnityPlayerUtils.resume()
    }

    override fun onDetachedFromWindow() {
        Log.i(LOG_TAG, "onDetachedFromWindow")
        // todo: fix more than one unity view, don't add to background.
//        UnityPlayerUtils.addUnityViewToBackground()
        super.onDetachedFromWindow()
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        ev.source = InputDevice.SOURCE_TOUCHSCREEN
        return super.dispatchTouchEvent(ev)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean{
        if (event == null) return false

        event.source = InputDevice.SOURCE_TOUCHSCREEN
        return super.onTouchEvent(event)
    }

}