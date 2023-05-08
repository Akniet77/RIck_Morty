package com.example.rick_morty.App

import android.app.Application
import com.example.rick_morty.data.service.ApiService

class App : Application() {

    companion object {
        lateinit var service: ApiService
    }
}
