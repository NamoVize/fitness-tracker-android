package com.example.fittrack.ui.workouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Pool
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fittrack.R
import com.example.fittrack.ui.components.ActivityCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.nav_workouts))
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Navigate to workout creation screen */ }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = stringResource(id = R.string.start_workout)
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Workout categories
            Text(
                text = "Categories",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(workoutCategories) { category ->
                    WorkoutCategoryItem(
                        icon = category.first,
                        name = category.second
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Recent workouts
            Text(
                text = stringResource(id = R.string.workout_history),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(workoutHistory) { workout ->
                    ActivityCard(
                        title = workout.first,
                        time = workout.second,
                        details = workout.third,
                        icon = when (workout.first) {
                            "Running" -> Icons.Filled.DirectionsRun
                            "Swimming" -> Icons.Filled.Pool
                            "Yoga" -> Icons.Filled.SelfImprovement
                            else -> Icons.Filled.FitnessCenter
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun WorkoutCategoryItem(
    icon: ImageVector,
    name: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = name,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = name,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

// Sample data
private val workoutCategories = listOf(
    Pair(Icons.Filled.DirectionsRun, stringResource(R.string.running)),
    Pair(Icons.Filled.FitnessCenter, stringResource(R.string.weight_training)),
    Pair(Icons.Filled.SelfImprovement, stringResource(R.string.yoga)),
    Pair(Icons.Filled.Pool, stringResource(R.string.swimming))
)

private val workoutHistory = listOf(
    Triple("Running", "Today, 7:30 AM", "5.2 km in 30 min"),
    Triple("Weight Training", "Yesterday, 6:15 PM", "Upper Body • 45 min"),
    Triple("Yoga", "Mar 7, 8:00 AM", "Morning Flow • 30 min"),
    Triple("Swimming", "Mar 5, 7:00 PM", "20 laps • 40 min")
)