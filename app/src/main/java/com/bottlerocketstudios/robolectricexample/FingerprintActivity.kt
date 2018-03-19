package com.bottlerocketstudios.robolectricexample

import android.content.Context
import android.content.Intent
import android.hardware.fingerprint.FingerprintManager
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class FingerprintActivity : AppCompatActivity() {

    companion object {
        val INTENT_USE_FINGERPRINT = "useFingerprint"

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, FingerprintActivity::class.java)

            var useFingerprint = false

            // Fingerprint support only available on API 23 and higher
            if (Build.VERSION.SDK_INT >=  Build.VERSION_CODES.M) {
                val fingerprintManager = context.getSystemService(Context.FINGERPRINT_SERVICE) as FingerprintManager

                //true if fingerprint hardware is available and there are enrolled fingerprints
                useFingerprint = if (!fingerprintManager.isHardwareDetected) {
                    false
                } else fingerprintManager.hasEnrolledFingerprints()
            }

            intent.putExtra(INTENT_USE_FINGERPRINT, useFingerprint)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_activity)
        setSupportActionBar(toolbar)
    }

    //Use fingerprint support for something awesome...
}
