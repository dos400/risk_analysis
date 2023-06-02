package uz.hamroev.riskanalysis.app

import android.app.Application
import uz.hamroev.riskanalysis.cache.Cache
import uz.hamroev.riskanalysis.database.ResultDatabase

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Cache.init(this)
        ResultDatabase.getInstance(this)
    }
}