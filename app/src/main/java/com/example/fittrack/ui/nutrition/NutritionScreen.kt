package com.example.fittrack.ui.nutrition

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fittrack.R
import com.example.fittrack.ui.theme.CarbsColor
import com.example.fittrack.ui.theme.FatColor
import com.example.fittrack.ui.theme.ProteinColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NutritionScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.nav_nutrition))
                },
                actions = {
                    IconButton(onClick = { /* Open barcode scanner */ }) {
                        Icon(
                            imageVector = Icons.Filled.QrCodeScanner,
                            contentDescription = stringResource(id = R.string.scan_barcode)
                        )
                    }
                    
                    IconButton(onClick = { /* Open food search */ }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = stringResource(id = R.string.search_food)
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Open add food screen */ }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = stringResource(id = R.string.add_food)
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            // Daily calorie summary
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.total_calories),
                        style = MaterialTheme.typography.titleMedium
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.size(140.dp)
                    ) {
                        CircularProgressIndicator(
                            progress = 0.65f,
                            modifier = Modifier.size(140.dp),
                            strokeWidth = 12.dp,
                            color = MaterialTheme.colorScheme.primary
                        )
                        
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.LocalFireDepartment,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(24.dp)
                                )
                                
                                Spacer(modifier = Modifier.width(4.dp))
                                
                                Text(
                                    text = "1,430",
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            
                            Text(
                                text = "/ 2,200",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Macronutrients
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        MacronutrientProgress(
                            name = stringResource(id = R.string.protein),
                            value = 65,
                            goal = 120,
                            color = ProteinColor
                        )
                        
                        MacronutrientProgress(
                            name = stringResource(id = R.string.carbs),
                            value = 180,
                            goal = 275,
                            color = CarbsColor
                        )
                        
                        MacronutrientProgress(
                            name = stringResource(id = R.string.fat),
                            value = 45,
                            goal = 73,
                            color = FatColor
                        )
                    }
                }
            }
            
            // Meals section
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    MealSection(
                        mealName = stringResource(id = R.string.breakfast),
                        calories = 420,
                        items = listOf(
                            "Oatmeal with berries" to 320,
                            "Coffee with milk" to 100
                        )
                    )
                    
                    MealSection(
                        mealName = stringResource(id = R.string.lunch),
                        calories = 650,
                        items = listOf(
                            "Grilled chicken salad" to 450,
                            "Whole grain bread" to 120,
                            "Apple" to 80
                        )
                    )
                    
                    MealSection(
                        mealName = stringResource(id = R.string.dinner),
                        calories = 580,
                        items = listOf(
                            "Salmon fillet" to 350,
                            "Steamed vegetables" to 120,
                            "Quinoa" to 110
                        )
                    )
                    
                    MealSection(
                        mealName = stringResource(id = R.string.snacks),
                        calories = 200,
                        items = listOf(
                            "Greek yogurt" to 120,
                            "Almonds" to 80
                        )
                    )
                }
            }
            
            // Water intake
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Filled.WaterDrop,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                        
                        Spacer(modifier = Modifier.width(8.dp))
                        
                        Text(
                            text = stringResource(id = R.string.water_intake),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        
                        Spacer(modifier = Modifier.weight(1f))
                        
                        Text(
                            text = "1.2L / 2.5L",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    LinearProgressIndicator(
                        progress = 0.48f,
                        modifier = Modifier.fillMaxWidth(),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun MacronutrientProgress(
    name: String,
    value: Int,
    goal: Int,
    color: Color,
    modifier: Modifier = Modifier
) {
    val progress = (value.toFloat() / goal).coerceIn(0f, 1f)
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = 4.dp)
                .size(12.dp)
                .clip(CircleShape)
                .background(color)
        )
        
        Text(
            text = name,
            style = MaterialTheme.typography.bodySmall
        )
        
        Text(
            text = "$value/$goal g",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(4.dp))
        
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier
                .height(4.dp)
                .width(60.dp)
                .clip(RoundedCornerShape(2.dp)),
            color = color,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    }
}

@Composable
fun MealSection(
    mealName: String,
    calories: Int,
    items: List<Pair<String, Int>>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = mealName,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            
            Text(
                text = "$calories cal",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        items.forEach { (name, cal) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "• $name",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.weight(1f)
                )
                
                Text(
                    text = "$cal cal",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        
        Spacer(modifier = Modifier.height(4.dp))
        
        if (items.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
            )
        }
    }
}