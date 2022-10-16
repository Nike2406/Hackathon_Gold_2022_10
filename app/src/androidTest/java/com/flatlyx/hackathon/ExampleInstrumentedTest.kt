package com.flatlyx.hackathon

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.flatlyx.hackathon.network.ApiRouter
import kotlinx.coroutines.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testApi() = runBlocking {
        val job = GlobalScope.launch {
            val result = ApiRouter.driver(1)
            val author = result.body()?.name
            Log.d("TEST: ", author.toString())
            assertEquals("Michael Jordan", author)
        }
        job.join()
    }
}