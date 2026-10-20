# Fruit Learning · 水果识字

Junior Fall Mobile Computing — Assignment 2  
大三秋季学期《移动计算》第二次作业

A bilingual fruit-learning Android app for children, built with **Kotlin and XML Views**. Explore six illustrated fruits, learn their English initials and names, and listen to English or Mandarin pronunciation offline.

一款使用 **Kotlin + XML Views** 开发的儿童水果学习 Android 应用。通过六种水果的插画、名称、英文首字母和离线发音，帮助儿童学习基础中英文词汇。

## English

### Features

- **Six fruits:** apple, banana, orange, grape, strawberry and watermelon.
- **Browse and learn:** illustrated ListView rows open a detail screen with a larger picture, fruit name, English initial and a short fact.
- **Two languages:** switch between English and Simplified Chinese on either screen; the app remembers the selected language.
- **Pronunciation guides:** American IPA on English detail pages and Mandarin pinyin with tone marks on Chinese pages.
- **Offline audio:** bundled English and Mandarin recordings play through MediaPlayer, without a network connection or an installed TTS engine.
- **Responsive XML layouts:** separate phone portrait, phone landscape and tablet layouts, including multi-column tablet screens.
- **Textbook-inspired artwork:** a fruit-covered book on the home screen and launcher icon, with rectangular cards, square letter tiles and simple buttons.
- **Basic accessibility:** image descriptions, readable text, scrollable content and spacing around system bars.

### Implementation

The main screen uses a custom `ArrayAdapter` and `ListView`. Selecting a fruit sends its stable ID through an explicit `Intent` to a shared detail Activity. Localized string resources supply names and descriptions. A shared Activity handles language preferences and system insets, while MediaPlayer resources are released when leaving the detail screen.

### Build and run

1. Clone this repository and open it in Android Studio.
2. Install the SDK and toolchain requested by the project, then sync Gradle. The project currently uses compile/target SDK 37 and supports Android API 24 or later.
3. Run the `app` configuration on an Android phone or tablet emulator.

```sh
./gradlew :app:assembleDebug
./gradlew :app:lintDebug
```

Android Studio generates `local.properties` for your local SDK path. Machine-specific configuration, build outputs and caches are excluded from Git.

### Validation and demo

Debug build and Android Lint passed during development. Phone and tablet emulator checks covered fruit details, return navigation, language switching and persistence, offline audio, and the new phonetic text. Lint may still report non-blocking warnings.

The MP4 in `deliverables/` is an **earlier three-fruit demonstration** and does not show all current features. Record a new video for final submission. The folder also contains the debug APK, screenshots, source archive and Chinese recording notes. See [development notes](docs/development-notes.md) for the original implementation and recording guidance.

## 中文

### 应用功能

- **六种水果：**苹果、香蕉、橙子、葡萄、草莓和西瓜。
- **列表与详情：**点击列表中的水果，查看大图、名称、英文首字母及简单知识介绍。
- **中英文切换：**首页和详情页均可切换语言，重新打开应用后保留选择。
- **注音辅助：**英文详情显示美式音标，中文详情显示带声调的拼音。
- **离线发音：**点击按钮播放对应语言的水果名称，无须联网或安装系统语音引擎。
- **手机和平板适配：**分别提供手机竖屏、横屏和平板 XML 布局；平板使用分栏展示。
- **教科书风格：**水果课本封面与桌面图标，搭配方形字母格和矩形按钮。
- **基础无障碍支持：**提供图片说明、可滚动内容及系统栏安全间距。

### 实现思路

首页通过自定义 `ArrayAdapter` 显示 `ListView`。点击后，使用显式 `Intent` 传递水果的稳定 ID，由统一的详情 Activity 读取并展示。文字通过资源文件实现本地化，共用 Activity 负责语言偏好和系统栏处理，`MediaPlayer` 负责播放音频，并在离开详情页时释放资源。

### 运行与提交

使用 Android Studio 打开项目，安装项目要求的 SDK 和工具链，完成 Gradle 同步后运行 `app`。最低支持 Android API 24，当前编译和目标 SDK 为 37。命令行构建和 Lint 检查见上方命令。

`deliverables/` 中包含调试 APK、截图、源码压缩包和录屏说明。**现有 MP4 为早期三种水果版本**，正式提交时应重新录制，展示当前六种水果、双语发音及注音功能。仓库上传不等于课程平台提交。

## Source guide · 代码导航

- `MainActivity.kt` — fruit list and navigation / 水果列表与跳转。
- `Fruit.kt` — fruit IDs and resource references / 水果数据与资源索引。
- `FruitDetailActivity.kt` — details, IPA/pinyin and audio / 详情、注音与发音。
- `FruitActivity.kt` — language preferences and system insets / 语言偏好与系统栏处理。
- `res/layout`, `res/layout-land`, `res/layout-sw600dp` — phone and tablet layouts / 手机、横屏和平板布局。
- `res/values`, `res/values-zh` — localized text and phonetic guides / 双语文字与注音资源。
- `res/raw` — bundled pronunciation audio / 离线发音文件。
- `artwork/` — original generated artwork / 生成插画原稿。

## Asset notes · 素材说明

Fruit illustrations and the textbook cover were generated with ImageGen. Audio was synthesized locally with macOS Samantha (English) and Tingting (Mandarin) voices. Density-specific images are derived from the original artwork. Pronunciation notation reference: [Oxford Learner’s Dictionaries](https://www.oxfordlearnersdictionaries.com/us/about/pronunciation_american_english).

水果插画和课本封面使用 ImageGen 生成；英文与普通话音频分别由 macOS Samantha 和 Tingting 语音合成，多密度图片由原图缩放生成。
