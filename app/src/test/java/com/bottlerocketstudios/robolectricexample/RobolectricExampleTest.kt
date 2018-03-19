package com.bottlerocketstudios.robolectricexample

import android.content.Context
import android.os.Build.VERSION_CODES.*
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * Created by nathan.oneal on 3/18/18.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = intArrayOf(JELLY_BEAN, JELLY_BEAN_MR1))
class ExampleRobolectricTest {

    fun getName(context: Context): String {
        return context.getString(R.string.app_name)
    }

    @Test
    fun testGetName() {
        // pass Context to getName and return application name
        assertThat(getName(RuntimeEnvironment.application)).isEqualTo("RobolectricExample")
    }

    @Test
    @Config(qualifiers="es")
    fun testGetNameSpanish() {
        assertThat(getName(RuntimeEnvironment.application)).isEqualTo("RobolectricExampleSpanish")
    }

    @Test
    @Config(sdk = intArrayOf(KITKAT))
    fun testKitKat() {
        // will run on KITKAT
    }

    @Test
    @Config(minSdk = LOLLIPOP)
    fun testLollipop() {
        // will run on LOLLIPOP, M, etc.
    }
}