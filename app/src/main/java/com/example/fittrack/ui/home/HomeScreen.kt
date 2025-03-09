package com.example.fittrack.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fittrack.R
import com.example.fittrack.ui.components.ActivityCard
import com.example.fittrack.ui.components.MetricCard
import com.example.fittrack.ui.components.NutritionSummaryCard
import com.example.fittrack.ui.components.RecentWorkoutsCard
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val today = LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, MMMM d"))
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "FitTrack",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = today,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            // Daily summary section
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.today_activity),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Steps
                        MetricCard(
                            icon = Icons.Filled.DirectionsRun,
                            value = "8,543",
                            label = stringResource(id = R.string.steps),
                            modifier = Modifier.weight(1f)
                        )
                        
                        // Calories
                        MetricCard(
                            icon = Icons.Filled.LocalFireDepartment,
                            value = "845",
                            label = stringResource(id = R.string.calories),
                            modifier = Modifier.weight(1f)
                        )
                        
                        // Active Minutes
                        MetricCard(
                            icon = Icons.Filled.Timer,
                            value = "65",
                            label = stringResource(id = R.string.active_minutes),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
            
            // Recent workouts section
            RecentWorkoutsCard(
                workouts = listOf(
                    Triple("Running", "45 min", "350 cal"),
                    Triple("Strength Training", "30 min", "220 cal")
                ),
                onViewAllClick = { /* Navigate to workouts screen */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
            
            // Nutrition summary section
            NutritionSummaryCard(
                calories = 1850,
                calorieGoal = 2200,
                protein = 95,
                carbs = 210,
                fat = 65,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
            
            // Today's activity cards
            ActivityCard(
                title = "Morning Run",
                time = "7:30 AM",
                details = "5.2 km in 30 minutes",
                icon = Icons.Filled.DirectionsRun,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
            
            ActivityCard(
                title = "Heart Rate Zone Training",
                time = "6:15 PM",
                details = "Zone 3 for 25 minutes",
                icon = Icons.Filled.MonitorHeart,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}