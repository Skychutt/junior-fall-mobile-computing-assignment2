# Fruit Learning · 水果识字

Student ID / 学号：24107737 · Mobile Computing Assignment 2

Kotlin + XML Views app with six fruits, clickable ListView rows, explicit Intent navigation, large initials, English/Simplified Chinese localization, offline bilingual pronunciation, American IPA and Mandarin pinyin. Separate phone, landscape and sw600dp tablet layouts and drawable density variants are included.

使用 Kotlin + XML Views，提供六种水果、图片列表、显式 Intent 跳转、大写首字母、中英文切换、离线发音、音标与拼音。使用资源限定符适配手机、横屏和平板。

## Run / 运行

Open this folder in Android Studio and sync Gradle. Minimum API 24; compile/target SDK 37. Android Studio generates local.properties for the SDK path.

```sh
./gradlew :app:assembleDebug
./gradlew :app:lintDebug
```

## Files / 文件

- app/: Kotlin source, XML layouts and required image/audio resources.
- gradle/ and Gradle scripts: build configuration and wrapper.
- artwork/: original generated images, retained for asset provenance and future resizing.
- assignemnt2/: original coursework requirements.
- report_video.mov: student-recorded demonstration, unchanged.

The uncompressed submission folder is Assignment2_24107737 in the mobile computing coursework workspace. Its README records remaining video checks. GitHub backup is separate from course-platform submission.

未压缩提交目录为课程工作区中的 Assignment2_24107737；视频待确认事项见该目录说明。GitHub 备份不等于课程平台提交。

## Assets / 素材

Images and textbook cover were generated with ImageGen. Pronunciation files were synthesized with macOS Samantha (English) and Tingting (Mandarin). These are application assets rather than student narration. English IPA reference: https://www.oxfordlearnersdictionaries.com/us/about/pronunciation_american_english
