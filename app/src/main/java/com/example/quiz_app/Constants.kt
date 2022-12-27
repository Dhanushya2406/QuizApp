package com.example.quiz_app

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val q1 = Question(1,"When contentProvider would be activated?",
            "using Intent", "using SQLite",
            "using ContentResolver", "none of the above",
            3)

        questionsList.add(q1)

        //2
        val q2 = Question(2,"Parent class of Activity is",
            "object", "context",
            "activityGroup", "contextTheme Wrapper",
            4)

        questionsList.add(q2)

        //3
        val q3 = Question(3,"Once installed on a device, each Android application lives in ?",
            "device memory", "external memory",
            "security sandbox", "none of the above",
            3)

        questionsList.add(q3)

        //4
        val q4 = Question(4,"What are the Direct subclasses of Activity?",
            "ListActivity", "ActivityGroup",
            "FragmentActivity", "all the above",
            4)

        questionsList.add(q4)

        //5
        val q5 = Question(5,"Which are the screen densities in Android?",
            "low density", "medium density",
            "extra high density", "all of the above",
            4)

        questionsList.add(q5)

        //6
        val q6 = Question(6,"Which one is NOT related to fragment class?",
            "dialogFragment", "listFragment",
            "preferenceFragment", "cursorFragment",
            4)

        questionsList.add(q6)

        //7
        val q7 = Question(7,"Which of the following is Layouts in android?",
            "Frame Layout", "Linear Layout",
            "C. Relative", "All of the above",
            4)

        questionsList.add(q7)

        //8
        val q8 = Question(8,"If you want share the data across the all applications ,you should go for?",
            "Shared Preferences", "Content provider",
            "Internal Storage", "SQLite Databases",
            2)

        questionsList.add(q8)

        //9
        val q9 = Question(9,"When the activity is not in focus, but still visible on the screen it is in?",
            "running state", "stopped state",
            "paused state", "destroyed state",
            3)

        questionsList.add(q9)

        //10
        val q10 = Question(10,"What is the name of the program that converts Java byte code into Dalvik byte code?",
            "Android Interpretive Compiler (AIC)", "Dalvik Converter",
            "Dex compiler", "Mobile Interpretive Compiler (MIC)",
            3)

        questionsList.add(q10)

        //11
        val q11 = Question(11,"The Emulator is identical to running a real phone EXCEPT when emulating/simulating what? ",
            "Telephony", "Applications",
            "Sensors", "The emulator can emulate/simulate all aspects of a smart phone.",
            3)

        questionsList.add(q11)

        //12
        val q12 = Question(12,"Which of these are not one of the three main components of the APK?",
            "Dalvik Executable", "Resources",
            "Native Libraries", "Webkit",
            4)

        questionsList.add(q12)

        //13
        val q13 = Question(13,"While developing Android applications, developers can test their apps on",
            "Emulator included in Android SDK", "Physical Android phone",
            "Third-party Emulators", "All the above",
            4)

        questionsList.add(q13)

        //14
        val q14 = Question(14,"Which piece of code used in Android is not open source?",
            "Keypad driver", "WiFi driver",
            "Audio driver", "Power management",
            2)

        questionsList.add(q14)

        //15
        val q15 = Question(15,"What is the driving force behind an Android application and that ultimately gets converted into a Dalvik executable?",
            "Java source code", "R-file.",
            "The emulator", "The SDK",
            1)

        questionsList.add(q15)

        return questionsList
    }
}