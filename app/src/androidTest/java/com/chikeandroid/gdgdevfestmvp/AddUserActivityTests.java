package com.chikeandroid.gdgdevfestmvp;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.chikeandroid.gdgdevfestmvp.adduser.AddUserActivity;
import com.chikeandroid.gdgdevfestmvp.utils.ActivityRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Chike on 11/25/2016.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class AddUserActivityTests {

    @Rule
    public final ActivityRule<AddUserActivity> rule = new ActivityRule<>(AddUserActivity.class);

    AddUserActivity mAddUserActivity;

    @Before
    public void init() {
        mAddUserActivity = rule.get();
    }

    @Test
    public void testShouldLaunchPostsActivityWhenShowPostsButtonIsClicked() {

        onView(withId(R.id.btn_users)).perform(click());

        onView(withId(R.id.todos_recycler_view)).check(matches(isDisplayed()));

    }

}
