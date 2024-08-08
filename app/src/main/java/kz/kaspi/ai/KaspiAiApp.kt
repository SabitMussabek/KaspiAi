package kz.kaspi.ai

import android.app.Application
import kz.kaspi.ai.di.modulesList
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class KaspiAiApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            println("Init koin")
            startKoin {
                androidLogger(Level.ERROR)
                androidContext(this@KaspiAiApp)
                modules(modulesList)
            }
        }
    }
}