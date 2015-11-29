package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;
import android.util.Log;

import com.example.daykm.myapplication.backend.myApi.MyApi;
import com.example.daykm.myapplication.backend.myApi.model.MyBean;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest extends InstrumentationTestCase {
    @Mock
    MyApi api;
    @Mock
    MyApi.GetJoke getJoke;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAsyncTask() throws Throwable {
        MyBean bean = new MyBean();
        bean.setJoke("TestJoke");
        Mockito.when(getJoke.execute()).thenReturn(bean);
        Mockito.when(api.getJoke()).thenReturn(getJoke);
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                JokesTask task = new JokesTask(api) {
                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        Assert.assertEquals("TestJoke", s);
                        Log.i("JUNIT TEST", "I RAN");
                    }
                };
                task.execute(getInstrumentation().getContext());
            }
        });
    }
}