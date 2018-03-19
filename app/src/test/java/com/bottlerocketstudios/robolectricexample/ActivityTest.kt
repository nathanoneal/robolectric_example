package com.bottlerocketstudios.robolectricexample

import android.support.design.widget.FloatingActionButton
import android.widget.TextView
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

/**
 * Created by nathan.oneal on 3/18/18.
 */
@RunWith(RobolectricTestRunner::class)
class ActivityTest {

    lateinit var activity: MainActivity

    @Before
    fun setup() {
        activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
    }

    @Test
    fun testButtonClick() {
        //verify TextView starts with correct value
        assertThat(activity.findViewById<TextView>(R.id.label).text).isEqualTo("Hello World!")

        //get FAB from activity
        val fab = activity.findViewById<FloatingActionButton>(R.id.fab)

        //perform click action
        fab.performClick()

        //verify TextView value has changed
        assertThat(activity.findViewById<TextView>(R.id.label).text).isEqualTo("I'm new!")
    }
}