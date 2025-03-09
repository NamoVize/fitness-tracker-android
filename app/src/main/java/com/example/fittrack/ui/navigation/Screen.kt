package com.example.fittrack.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material.icons.outlined.DirectionsRun
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.ShowChart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.fittrack.R

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    object Home : Screen(
        route = "home",
        resourceId = R.string.nav_home,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    )

    object Workouts : Screen(
        route = "workouts",
        resourceId = R.string.nav_workouts,
        selectedIcon = Icons.Filled.DirectionsRun,
        unselectedIcon = Icons.Outlined.DirectionsRun
    )

    object Nutrition : Screen(
        route = "nutrition",
        resourceId = R.string.nav_nutrition,
        selectedIcon = Icons.Filled.Restaurant,
        unselectedIcon = Icons.Outlined.Restaurant
    )

    object Progress : Screen(
        route = "progress",
        resourceId = R.string.nav_progress,
        selectedIcon = Icons.Filled.ShowChart,
        unselectedIcon = Icons.Outlined.ShowChart
    )

    object Profile : Screen(
        route = "profile",
        resourceId = R.string.nav_profile,
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person
    )
}