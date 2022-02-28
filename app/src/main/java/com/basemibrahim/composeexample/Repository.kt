package com.basemibrahim.composeexample

import android.content.Context
import android.util.Log
import com.basemibrahim.composeexample.data.Person
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Repository {
    fun getData(context: Context) : List<Person>
    {
        val jsonFileString = getJsonDataFromAsset(context, "bezkoder.json")
        if (jsonFileString != null) {
            Log.i("data", jsonFileString)
        }
        val gson = Gson()
        val listPersonType = object : TypeToken<List<Person>>() {}.type
        var persons: List<Person> = gson.fromJson(jsonFileString, listPersonType)
        persons.forEachIndexed { idx, person -> Log.i("data", "> Item $idx:\n$person") }
        return persons
    }
}