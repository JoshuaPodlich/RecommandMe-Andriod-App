package com.example.androidreccomendme;

import com.example.androidreccomendme.MainMenu;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.AllOf.allOf;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.*;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withTagKey;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.StringEndsWith.endsWith;
// Mock the RequestServerForService class
@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest   // large execution time
public class AdminTesting {

    private static final int SIMULATED_DELAY_MS = 500;

    @Rule   // needed to launch the activity
    public ActivityScenarioRule<LoginPage> activityRule = new ActivityScenarioRule<LoginPage>(LoginPage.class);

    /**
     * Start the server and run this test
     */

    @Test
    public void AdminUserListTest(){

        onView(withId(R.id.usernameText)).perform(replaceText("CaelanH"));
        onView(withId(R.id.passwordText)).perform(replaceText("herzberg99"));
        onView(withId(R.id.loginBtn)).perform(click());
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
        }
        onView(withId(R.id.btnProfileMenu)).perform(click());
        onView(withId(R.id.Admin)).perform(click());
        onView(withId(R.id.btnViewUsers)).perform(click());
        onView(withId(R.id.UserList)).check(matches(isDisplayed()));

    }

    @Test
    public void AdminBanAndUnbanTest(){

        onView(withId(R.id.usernameText)).perform(replaceText("CaelanH"));
        onView(withId(R.id.passwordText)).perform(replaceText("herzberg99"));
        onView(withId(R.id.loginBtn)).perform(click());
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
        }
        onView(withId(R.id.btnProfileMenu)).perform(click());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        onView(withId(R.id.Admin)).perform(click());
        onView(withId(R.id.btnViewUsers)).perform(click());
        onView(withId(R.id.UserList)).check(matches(isDisplayed()));
        onData(allOf()).inAdapterView(withId(R.id.UserList)).atPosition(7).onChildView(withId(R.id.buttonToggleBanned)).perform(click());
        onView(withId(R.id.EditTextReasons)).perform(replaceText("Bad Behavior"));
        onView(withId(R.id.btnReasons)).perform(click());
        onView(withId(R.id.btnViewBanned)).perform(click());
        onData(allOf()).inAdapterView(withId(R.id.UserList)).atPosition(2).onChildView(withId(R.id.textIsAdmin)).check(matches(withText("Reasons: \nBad Behavior")));
        onData(allOf()).inAdapterView(withId(R.id.UserList)).atPosition(2).onChildView(withId(R.id.buttonToggleBanned)).perform(click());

    }



}

