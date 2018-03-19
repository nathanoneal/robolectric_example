package com.bottlerocketstudios.robolectricexample

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class FingerprintActivityTest {

    @Test
    fun newIntent_sdk23AndHardwareAvailable_useFingerprintShouldBeTrue() {
        // get intent
        val intent = FingerprintActivity.newIntent(RuntimeEnvironment.application)

        // useFingerprint should be true
        assertThat(intent.extras.getBoolean(FingerprintActivity.INTENT_USE_FINGERPRINT)).isTrue()
    }
}