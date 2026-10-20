package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

// A small shared base for language selection and safe system-bar spacing.
abstract class FruitActivity : Activity() {
    private var displayedLanguage = ""

    override fun attachBaseContext(base: Context) {
        val language = base.getSharedPreferences("settings", Context.MODE_PRIVATE)
            .getString("language", "").orEmpty()
        if (language.isEmpty()) {
            super.attachBaseContext(base)
        } else {
            val config = Configuration(base.resources.configuration)
            config.setLocale(Locale.forLanguageTag(language))
            super.attachBaseContext(base.createConfigurationContext(config))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        displayedLanguage = savedLanguage()
    }

    override fun onResume() {
        super.onResume()
        // Refresh the list when returning from a detail page in a new language.
        if (displayedLanguage != savedLanguage()) recreate()
    }

    private fun savedLanguage() = getSharedPreferences("settings", MODE_PRIVATE)
        .getString("language", "").orEmpty()

    protected fun configurePage(rootId: Int) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = true
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightNavigationBars = true
        val root = findViewById<View>(rootId)
        val padding = resources.getDimensionPixelSize(R.dimen.screen_padding)
        ViewCompat.setOnApplyWindowInsetsListener(root) { view, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())
            view.setPadding(bars.left + padding, bars.top + padding,
                bars.right + padding, bars.bottom + padding)
            insets
        }
        ViewCompat.requestApplyInsets(root)
        findViewById<Button>(R.id.language_button).setOnClickListener {
            val current = resources.configuration.locales[0].language
            val next = if (current == "zh") "en" else "zh-CN"
            getSharedPreferences("settings", MODE_PRIVATE).edit().putString("language", next).apply()
            recreate()
        }
    }
}
