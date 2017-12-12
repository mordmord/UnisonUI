package com.one20.unisonui;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.one20.one20ui.activity.BaseActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by ryanmord on 12/12/17.
 */
@RunWith(AndroidJUnit4.class)
public class TestButtons extends AbstractTest {


    @Rule
    public ActivityTestRule<BaseActivity> mActivityRule = new ActivityTestRule(BaseActivity.class);


    @Test
    public void testClickButtons() {

        ViewInteraction unisonButton = onView(
                allOf(withText("Raised Enabled"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                0)));
        unisonButton.perform(scrollTo(), click());


        ViewInteraction unisonButton2 = onView(
                allOf(withText("Flat Enabled"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                2)));
        unisonButton2.perform(scrollTo(), click());


        ViewInteraction unisonButton3 = onView(
                allOf(withText("Raised Enabled"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0)));
        unisonButton3.perform(scrollTo(), click());


        ViewInteraction unisonButton4 = onView(
                allOf(withText("Flat Enabled"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                2)));
        unisonButton4.perform(scrollTo(), click());

    }
}
