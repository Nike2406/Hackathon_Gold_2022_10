package com.flatlyx.hackathon

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.flatlyx.hackathon.model.Driver
import com.flatlyx.hackathon.network.ApiRouter
import kotlinx.coroutines.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.await
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
        val error = MutableLiveData<String>()
        val driver = MutableLiveData<Driver>()
        val loading = MutableLiveData<Boolean>()

        // launching a new coroutine
        var job: Job? = CoroutineScope(Dispatchers.IO).launch {
            val response = ApiRouter.driver(1)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    driver.postValue(response.body())
                    loading.value = false
                    Log.d("TEST: ", driver.toString())
                    assertEquals("Michael Jordan", driver)
                } else {
                    error.value = response.message()
                    loading.value = false
                    Log.d("ERROR: ", error.toString())
                    assertEquals("Michael Jordan", error)
                }
            }
        }
        job?.start()
        sleep(3000)
    }
}