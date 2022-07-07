package com.example.jetpackcompose

//its just a class that only allow classes inside of this screen class
//to inherit from the screen or classes inside this file
sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")

    fun withArgs(vararg  args: String):String{
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}