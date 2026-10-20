package com.example.myapplication

import android.os.Bundle
import android.media.MediaPlayer
import android.media.AudioAttributes
import android.widget.Toast
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class FruitDetailActivity : FruitActivity() {
    private var pronunciationPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fruitId = intent.getStringExtra(EXTRA_FRUIT_ID)
        val fruit = Fruits.all.firstOrNull { it.id == fruitId }
        if (fruit == null) {
            finish()
            return
        }
        setContentView(R.layout.activity_fruit_detail)
        configurePage(R.id.fruit_detail)
        androidx.core.view.ViewCompat.setAccessibilityHeading(findViewById(R.id.fruit_name), true)

        findViewById<TextView>(R.id.fruit_letter).text = fruit.letter
        findViewById<TextView>(R.id.fruit_name).setText(fruit.nameRes)
        findViewById<TextView>(R.id.fruit_pronunciation).setText(
            if (resources.configuration.locales[0].language == "zh") fruit.pinyinRes else fruit.ipaRes
        )
        findViewById<TextView>(R.id.fruit_fact).setText(fruit.factRes)
        findViewById<TextView>(R.id.letter_caption).text = getString(R.string.letter_caption, fruit.letter)
        findViewById<ImageView>(R.id.fruit_image).apply {
            setImageResource(fruit.imageRes)
            contentDescription = getString(fruit.nameRes)
        }
        findViewById<Button>(R.id.listen_button).setOnClickListener {
            val chinese = resources.configuration.locales[0].language == "zh"
            playPronunciation(if (chinese) fruit.chineseAudio else fruit.englishAudio)
        }
        findViewById<Button>(R.id.back_button).setOnClickListener { finish() }
    }

    // Local recordings work offline, including on emulators without a TTS engine.
    private fun playPronunciation(audioResource: Int) {
        pronunciationPlayer?.release()
        pronunciationPlayer = null
        try {
            val speechAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build()
            val player = MediaPlayer.create(this, audioResource, speechAttributes, 0)
            if (player == null) {
                Toast.makeText(this, R.string.playback_error, Toast.LENGTH_SHORT).show()
                return
            }
            pronunciationPlayer = player
            player.setOnCompletionListener {
                it.release()
                if (pronunciationPlayer === it) pronunciationPlayer = null
            }
            player.setOnErrorListener { mediaPlayer, _, _ ->
                mediaPlayer.release()
                if (pronunciationPlayer === mediaPlayer) pronunciationPlayer = null
                Toast.makeText(this, R.string.playback_error, Toast.LENGTH_SHORT).show()
                true
            }
            player.start()
        } catch (_: RuntimeException) {
            pronunciationPlayer?.release()
            pronunciationPlayer = null
            Toast.makeText(this, R.string.playback_error, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        pronunciationPlayer?.release()
        pronunciationPlayer = null
        super.onStop()
    }

    companion object {
        const val EXTRA_FRUIT_ID = "fruit_id"
    }
}
