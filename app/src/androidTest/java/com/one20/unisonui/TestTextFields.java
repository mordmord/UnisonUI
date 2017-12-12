package com.one20.unisonui;


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
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TestTextFields extends AbstractTest {

    @Rule
    public ActivityTestRule<BaseActivity> mActivityTestRule = new ActivityTestRule<>(BaseActivity.class);

    @Test
    public void testTextFields() {
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
                        3),
                        isDisplayed()));
        navigationMenuItemView.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.textInputEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.light_editText),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText.perform(click());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.textInputEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.light_editText),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("Test text"), closeSoftKeyboard());

        ViewInteraction unisonSwitch = onView(
                allOf(withId(R.id.switch_1),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1)));
        unisonSwitch.perform(scrollTo(), click());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.textInputEditText),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.one20.unisonui.widget.UnisonEditText")),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText3.perform(replaceText("Multi line text"), closeSoftKeyboard());

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.textInputEditText), withText("Multi line text"),
                        childAtPosition(
                                childAtPosition(
                                        withText("Multi line text"),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText4.perform(pressImeActionButton());

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.textInputEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.dark_editText),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText5.perform(replaceText("Test text"), closeSoftKeyboard());

        ViewInteraction unisonSwitch2 = onView(
                allOf(withId(R.id.switch_2),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                1)));
        unisonSwitch2.perform(scrollTo(), click());

        ViewInteraction unisonSwitch3 = onView(
                allOf(withId(R.id.switch_2),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                1)));
        unisonSwitch3.perform(scrollTo(), click());

        ViewInteraction unisonSwitch4 = onView(
                allOf(withId(R.id.switch_1),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1)));
        unisonSwitch4.perform(scrollTo(), click());

        pressBack();

        ViewInteraction textInputEditText6 = onView(
                allOf(withId(R.id.textInputEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.multilineLight),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText6.perform(replaceText("Multi line text"), closeSoftKeyboard());

        ViewInteraction textInputEditText7 = onView(
                allOf(withId(R.id.textInputEditText), withText("Multi line text"),
                        childAtPosition(
                                childAtPosition(
                                        allOf(withId(R.id.multilineLight), withText("Multi line text")),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText7.perform(pressImeActionButton());

    }

}
