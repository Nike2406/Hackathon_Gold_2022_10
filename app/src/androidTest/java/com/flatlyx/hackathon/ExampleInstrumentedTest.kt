package com.flatlyx.hackathon

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.flatlyx.hackathon.network.ApiBuilder
import com.flatlyx.hackathon.network.ApiService
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
    fun testApi() {
        val quotesApi = ApiBuilder.getInstance().create(ApiService::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val result = quotesApi.getQuotes()
            val author = result.body()?.results?.get(0)?.author
            Log.d("TEST: ", author.toString())
            assertEquals("Michael Jordan", author)
        }
        sleep(2000)
    }
}