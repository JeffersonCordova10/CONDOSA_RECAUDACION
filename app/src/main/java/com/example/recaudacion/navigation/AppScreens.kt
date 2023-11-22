package com.example.recaudacion.navigation

// sealed: jerarquia limitada
sealed class AppScreens(val route:String){
    object LoginPageScreen: AppScreens("login_page_screen")
    object MainMenuScreen: AppScreens("main_menu_page_screen")
    object RegisterCollectionScreen: AppScreens("register_collection_screen")
}
