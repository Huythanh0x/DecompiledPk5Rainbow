# Decompiled Chinese Game: Petkingdom 5 - RainBow
### Project Overview
Welcome to the PetKing5 Android project! This project is an Android application that manages the lifecycle and state of a custom canvas and MIDlet. It includes various features such as memory management, full-screen mode, and background process termination.

### Project Structure
The project is organized as follows:

### Key Directories and Files
`app/src/main/java`: Contains the main source code for the application.

`javax.microedition.lcdui.CwaActivity.java`: Manages the lifecycle and state of a custom canvas and MIDlet.

`dm.Ms.java`: Implements various utility methods and manages key events.

`javax.microedition.rms.RecordStore.java`: Manages record storage using SQLite.

`javax.microedition.midlet.MIDlet.java`: Abstract class for managing the lifecycle of a MIDlet application.

`main.GameRun.java and main.GameRun_F.java`: Contains game logic and rendering methods.

`app/src/main/res/layout`: Contains the layout XML files for the Android UI.

`main.xml`: Defines the main layout of the application.

`build.gradle`: The main build configuration file for the project.

`app/build.gradle`: Build configuration specific to the app module.

### Dependencies
The project uses the following dependencies:

`com.android.tools.build:gradle:4.2.2`

`gradle.plugin.com.tencent.android.tpns:tpnsplugin:0.0.5`

`libs/uc_payment_sdk.jar`

### Build and Run
To build and run the project, follow these steps:

Clone the repository:
```shell
git clone <repository-url>
cd <repository-directory>
```

Build the project:
```shell
./gradlew build
```
Run the project:
```shell
./gradlew installDebug
```

### Architecture
The project follows a modular architecture with the following key components:

`Activity`: CwaActivity manages the lifecycle and state of the custom canvas and MIDlet.

`MIDlet`: MIDlet is an abstract class that provides methods to manage the lifecycle of a MIDlet application.

`RecordStore`: RecordStore manages record storage using SQLite.

`Utility Classes`: Various utility methods are implemented in classes like Ms.

### App Flow
`Initialization`: The application starts with CwaActivity, which initializes the custom canvas and MIDlet.

`Lifecycle Management`: CwaActivity manages the lifecycle events such as onCreate, onPause, and onDestroy.

`Record Management`: RecordStore handles the storage and retrieval of records.

`Game Logic`: GameRun and GameRun_F contain the main game logic and rendering methods.

### Contributing
Contributions are welcome! Please follow these steps to contribute:

### Fork the repository.
1. Create a new branch (git checkout -b feature-branch).
2. Make your changes and commit them (git commit -am 'Add new feature').
3. Push to the branch (git push origin feature-branch).
4. Create a new Pull Request.

### License
This project is licensed under the MIT License.

Feel free to explore the code and contribute to the project. If you have any questions, please open an issue or contact the maintainers.
