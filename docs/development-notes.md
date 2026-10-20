> Historical development notes. For the current submission state, see README.md: the student has not recorded the final video. Old demo references below refer only to archive/early-demo/.

# Fruit Learning — Assignment 2

A children’s fruit-learning Android app written in Kotlin with XML Views.

## Features

- Six fruits: apple, banana, orange, grape, strawberry and watermelon.
- Clickable illustrated ListView rows, implemented with a custom ArrayAdapter.
- An explicit Intent passes a stable fruit ID to a shared detail Activity.
- Detail: fruit picture, localized name, large English initial, and short description.
- English and Simplified Chinese resources. The language button on either screen changes the app language and saves the choice locally; without a saved choice, device language is used.
- Phone layouts in `res/layout`, separate tablet layouts in `res/layout-sw600dp`.
- Phone: vertical list/details. Tablet: introduction/list columns and image/text detail columns.
- Different image dimensions in `drawable-mdpi` (320 px) and `drawable-xhdpi` (640 px); tablet dimensions also enlarge the displayed images.
- Safe system-bar spacing, scrolling detail content and image accessibility labels.
- Offline use; no account, network connection or permissions are needed.

## Open / run

Open this project folder in Android Studio, sync Gradle, then run `app` on a phone or tablet emulator. Keep the project’s installed SDK/toolchain settings; Gradle wrapper and dependency versions are included. `local.properties` is intentionally omitted from the submission archive because it contains a machine-specific SDK path; Android Studio creates it on the destination machine.

Build: `./gradlew :app:assembleDebug`
Lint: `./gradlew :app:lintDebug`

## Code guide

- `MainActivity.kt`: custom list rows and click-to-detail navigation.
- `Fruit.kt`: stable ID, localized name resource, image, letter and description for each fruit.
- `FruitDetailActivity.kt`: look up the selected fruit and display it; invalid IDs safely close details.
- `FruitActivity.kt`: app-language configuration, saved preference, page refresh and system insets.
- `res/layout/item_fruit.xml`: each clickable picture row.
- `res/layout/` and `res/layout-sw600dp/`: phone and tablet screen structures.
- `res/values/strings.xml` and `res/values-zh/strings.xml`: English and Chinese text.
- `res/values-sw600dp/dimens.xml`: larger tablet image dimensions and spacing.

## Validation

Debug build and Android Lint pass (lint has non-blocking warnings, including available dependency updates). Verified on Medium Phone (1080×2400, 420dpi) and a temporary Medium Tablet emulator (2560×1600, 320dpi): all six fruit details, names/images/letters, return navigation, English/Chinese main and detail screens, language refresh on return, and language persistence after restarting the app.

## Submission

`deliverables/` contains the source ZIP, debug APK, screenshots and an actual emulator demonstration MP4. The recording uses English captions plus a short explanation of the Kotlin/XML code flow. Review the recording and practise explaining the implementation before your live demonstration. This repository contains the project source; coursework submission is handled separately.

The provided documents disagree on recording length (1–2 minutes vs a 1-minute limit). The two documents disagree on length; prepare an approximately one-minute tour and follow any updated teacher/Moodle instructions. Confirm any more recent Moodle instructions before submission.

## Image provenance

Apple, banana and orange illustrations were generated using the built-in ImageGen tool for this assignment. Full-size transparent PNGs are in `artwork/`. Shared prompt: one recognizable whole fruit, centered on a square canvas, cheerful children’s educational illustration, bright natural colors, softly shaded volume, transparent background, no labels, letters, faces or watermark. Subject variants: a red apple with a green leaf; one ripe yellow banana; one orange with a green leaf. Density variants are resized copies of these generated originals.

## Visual style

Simple rectangular list cards, square letter tiles and rectangular buttons; neutral backgrounds with blue/yellow accents. Decorative marketing slogans removed. Fruit illustrations and functionality are preserved.

## Pronunciation

The detail page has a pronunciation button. MediaPlayer plays bundled WAV files from `res/raw` in the current app language. These files were synthesized locally with macOS Samantha (English) and Tingting (Mandarin) voices. Playback does not require Internet access or an installed Android TTS engine. Repeated taps replace the current sound; leaving the screen releases the player. Generated fruit images are saved in `artwork/` and density variants in drawable folders.

## Updated assignment version

Six-fruit version includes Grape/G, Strawberry/S and Watermelon/W, plus English/Mandarin pronunciation. See `deliverables/平板测试说明.md` for the persistent Tablet_pad AVD. The existing demonstration MP4 was recorded before this six-fruit/audio update; record a new submission tour with this version.

## Textbook cover and layout refinement

The home page and launcher now use a textbook cover with six fruit symbols. The cover was generated with the built-in ImageGen tool: blue elementary-school textbook, simple cream panel, six fruit markers in a rectangular grid, no lettering, transparent background. Original: `artwork/textbook_cover.png`. Compact phone cover, larger tablet cover and separate phone landscape layouts keep the list accessible. Speech playback uses MEDIA/SPEECH audio attributes.

Recording checklist: `deliverables/录屏脚本与检查清单.md`. The textbook cover and launcher icon are generated using the built-in ImageGen tool and saved in `artwork/textbook_cover.png`; optimized variants are included in resources.


### Pronunciation guides
Fruit detail screens show American IPA in English and tone-marked Mandarin pinyin in Chinese. English pronunciation reference: https://www.oxfordlearnersdictionaries.com/us/about/pronunciation_american_english
