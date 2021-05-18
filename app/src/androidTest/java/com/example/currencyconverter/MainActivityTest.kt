package com.example.currencyconverter

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
class MainActivityUITest {
    @Rule
    @JvmField
    var activityActivityTestRule: ActivityTestRule<MainActivity> =
        object : ActivityTestRule<MainActivity>(MainActivity::class.java) {

        }


    @Test
    @Throws(Exception::class)
    fun journeyFLow() {
        Thread.sleep(1000)
        onView(withId(R.id.spinner)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        Thread.sleep(1000)

    }




}