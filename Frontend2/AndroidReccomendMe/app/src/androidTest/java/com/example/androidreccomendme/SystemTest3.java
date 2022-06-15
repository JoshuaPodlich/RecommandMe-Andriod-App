package com.example.androidreccomendme;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.View;

import androidx.test.espresso.DataInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;



// Mock the RequestServerForService class
@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest   // large execution time
public class SystemTest3 {

    private static final int SIMULATED_DELAY_MS = 1500;

    @Rule   // needed to launch the activity
    public ActivityScenarioRule<LoginPage> activityRule = new ActivityScenarioRule<LoginPage>(LoginPage.class);

    /**
     * Start the server and run this test
     */

    @Test
    public void registerTest1()
    {
        onView(withId(R.id.registerBtn)).perform(click());
        onView(withId(R.id.registerUserbtn)).perform(click());
        onView(withId(R.id.registerInfoText)).check(matches(withText("Please make sure all information is filled out")));

        onView(withId(R.id.usernameTextInput)).perform(replaceText("testUser1"));
        onView(withId(R.id.passwordTextInput)).perform(replaceText("password123"));
        onView(withId(R.id.emailTextInput)).perform(replaceText("testing@gmail.com"));
        onView(withId(R.id.radioButtonMale)).perform(click());
        onView(withId(R.id.registerUserbtn)).perform(click());
        onView(withId(R.id.loginBtn)).perform(click());
        onView(withId(R.id.usernameText)).perform(replaceText("testUser1"));
        onView(withId(R.id.passwordText)).perform(replaceText("password123"));
        onView(withId(R.id.loginBtn)).perform(click());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        onView(withId(R.id.btnProfileMenu)).perform(click());

        onView(withId(R.id.textUsername)).check(matches(withText("testUser1")));
    }

    @Test
    public void loginTest1()
    {
        onView(withId(R.id.loginBtn)).perform(click());
        try {
            Thread.sleep(SIMULATED_DELAY_MS);
        } catch (InterruptedException e) {
        }
        onView(withId(R.id.loginBtn)).check(matches(withText("Login")));

        onView(withId(R.id.usernameText)).perform(replaceText("fakeUser"));
        onView(withId(R.id.passwordText)).perform(replaceText("noPassword"));
        onView(withId(R.id.loginBtn)).perform(click());
        try {
            Thread.sleep(SIMULATED_DELAY_MS);
        } catch (InterruptedException e) {
        }
        onView(withId(R.id.loginBtn)).check(matches(withText("Login")));

        onView(withId(R.id.usernameText)).perform(replaceText("testUser2"));
        onView(withId(R.id.passwordText)).perform(replaceText("password123"));
        onView(withId(R.id.loginBtn)).perform(click());
        try {
            Thread.sleep(SIMULATED_DELAY_MS);
        } catch (InterruptedException e) {
        }
        onView(withId(R.id.btnProfileMenu)).perform(click());
        try {
            Thread.sleep(SIMULATED_DELAY_MS);
        } catch (InterruptedException e) {
        }
        onView(withId(R.id.textUsername)).check(matches(withText("testUser2")));

        onView(withId(R.id.btnProfileHome)).perform(click());
        onView(withId(R.id.btnLog)).perform(click());
        onView(withId(R.id.loginBtn)).check(matches(withText("Login Out")));

        onView(withId(R.id.loginBtn)).perform(click());
        try {
            Thread.sleep(SIMULATED_DELAY_MS);
        } catch (InterruptedException e) {
        }
        onView(withId(R.id.loginBtn)).check(matches(withText("Login")));
    }

    @Test
    public void guestLoginTest1()
    {
        onView(withId(R.id.loginBtn)).perform(click());
        onView(withId(R.id.btnHome)).perform(click());
        onView(withId(R.id.btnProfileMenu)).perform(click());
        onView(withId(R.id.loginBtn)).check(matches(withText("Login")));
    }


    /*
    @Test
    public void commentListTest1() {
        onView(withId(R.id.loginBtn)).perform(click());
        onView(withId(R.id.usernameText)).perform(replaceText("testUser2"));
        onView(withId(R.id.passwordText)).perform(replaceText("password123"));
        onView(withId(R.id.loginBtn)).perform(click());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        onView(withId(R.id.btnResturaunt)).perform(click());
        try {
            Thread.sleep(SIMULATED_DELAY_MS);
        } catch (InterruptedException e) {
        }
        onView(withId(inAdapterView(withId(R.id.MovieList)).atPosition(0))).perform(click());
        try {
            Thread.sleep(SIMULATED_DELAY_MS);
        } catch (InterruptedException e) {
        }
        onView(withId(R.id.InfoBtn1)).perform(click());
        onView(withId(R.id.textName)).check(matches(withText("CornBred")));
    }
    */


}

