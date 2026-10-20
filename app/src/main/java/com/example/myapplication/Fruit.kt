package com.example.myapplication

// Stable IDs and bundled audio do not depend on the displayed language.
data class Fruit(
    val id: String, val nameRes: Int, val letter: String,
    val imageRes: Int, val factRes: Int, val englishAudio: Int, val chineseAudio: Int, val ipaRes: Int, val pinyinRes: Int
)

object Fruits {
    val all = listOf(
        Fruit("apple", R.string.apple, "A", R.drawable.apple, R.string.apple_fact, R.raw.apple_en, R.raw.apple_zh, R.string.apple_ipa, R.string.apple_pinyin),
        Fruit("banana", R.string.banana, "B", R.drawable.banana, R.string.banana_fact, R.raw.banana_en, R.raw.banana_zh, R.string.banana_ipa, R.string.banana_pinyin),
        Fruit("orange", R.string.orange, "O", R.drawable.orange, R.string.orange_fact, R.raw.orange_en, R.raw.orange_zh, R.string.orange_ipa, R.string.orange_pinyin),
        Fruit("grape", R.string.grape, "G", R.drawable.grape, R.string.grape_fact, R.raw.grape_en, R.raw.grape_zh, R.string.grape_ipa, R.string.grape_pinyin),
        Fruit("strawberry", R.string.strawberry, "S", R.drawable.strawberry, R.string.strawberry_fact, R.raw.strawberry_en, R.raw.strawberry_zh, R.string.strawberry_ipa, R.string.strawberry_pinyin),
        Fruit("watermelon", R.string.watermelon, "W", R.drawable.watermelon, R.string.watermelon_fact, R.raw.watermelon_en, R.raw.watermelon_zh, R.string.watermelon_ipa, R.string.watermelon_pinyin),
    )
}
