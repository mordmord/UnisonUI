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
import com.one20.unisonui.AbstractTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TestBars extends AbstractTest {

    @Rule
    public ActivityTestRule<BaseActivity> mActivityTestRule = new ActivityTestRule<>(BaseActivity.class);

    @Test
    public void testBars() {
        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction navigationMenuItemView = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        6),
                        isDisplayed()));
        navigationMenuItemView.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withId(R.id.menu_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.search_nav),
                                        0),
                                0),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withId(R.id.search_mic),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withId(R.id.nav_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.search_nav),
                                        0),
                                2),
                        isDisplayed()));
        appCompatImageButton4.perform(click());


        ViewInteraction unisonBottomBarItem = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.bottom_bar),
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1)),
                        0),
                        isDisplayed()));
        unisonBottomBarItem.perform(click());

        ViewInteraction unisonBottomBarItem2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.bottom_bar),
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1)),
                        1),
                        isDisplayed()));
        unisonBottomBarItem2.perform(click());

        ViewInteraction unisonBottomBarItem3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.bottom_bar),
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1)),
                        2),
                        isDisplayed()));
        unisonBottomBarItem3.perform(click());

        ViewInteraction unisonBottomBarItem4 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.bottom_bar),
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1)),
                        3),
                        isDisplayed()));
        unisonBottomBarItem4.perform(click());

        ViewInteraction unisonBottomBarItem5 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.bottom_bar),
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1)),
                        4),
                        isDisplayed()));
        unisonBottomBarItem5.perform(click());

    }

}
