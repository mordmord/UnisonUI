package com.one20.unisonui;


import android.os.SystemClock;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.one20.one20ui.R;
import com.one20.one20ui.activity.BaseActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TestSnackbar extends AbstractTest {

    @Rule
    public ActivityTestRule<BaseActivity> mActivityTestRule = new ActivityTestRule<>(BaseActivity.class);

    @Test
    public void testSnackbar() {
        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        SystemClock.sleep(1000);
        appCompatImageButton.perform(click());

        ViewInteraction navigationMenuItemView = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        4),
                        isDisplayed()));
        SystemClock.sleep(1000);
        navigationMenuItemView.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.textInputEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.snackbar_text),
                                        0),
                                1),
                        isDisplayed()));
        SystemClock.sleep(1000);
        textInputEditText.perform(click());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.textInputEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.snackbar_text),
                                        0),
                                1),
                        isDisplayed()));
        SystemClock.sleep(1000);
        textInputEditText2.perform(replaceText("snackbar"), closeSoftKeyboard());

        ViewInteraction unisonButton = onView(
                allOf(withId(R.id.snackbar_button), withText("Show Snackbar"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragment_container),
                                        0),
                                1),
                        isDisplayed()));
        SystemClock.sleep(1000);
        unisonButton.perform(click());

        ViewInteraction unisonButton2 = onView(
                allOf(withId(R.id.snackbar_button_1), withText("Show With Action"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragment_container),
                                        0),
                                2),
                        isDisplayed()));
        SystemClock.sleep(1000);
        unisonButton2.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.snackbar_text), withText("snackbar"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        SystemClock.sleep(1000);
        textView.check(matches(withText("snackbar")));

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.snackbar_action), withText("CANCEL"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.Snackbar$SnackbarLayout")),
                                        0),
                                1),
                        isDisplayed()));
        SystemClock.sleep(1000);
        appCompatButton.perform(click());

    }

}
