package com.example.mycity.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycity.R
import com.example.mycity.data.LocalDataCategoryProvider


enum class MyCityScreens {
    Start,
    Category,
    Recommendations,
    Details
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityTopBar(
    appBarVisible: Boolean,
    title: String,
    shouldShowArrow: Boolean,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (appBarVisible) {
        TopAppBar(
            title = { Text(text = title) },
            navigationIcon = {
                if (shouldShowArrow) {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(id = R.string.navigate_back_arrow)
                        )
                    }
                }
            },
            modifier = modifier
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    val navController: NavHostController = rememberNavController()

    val viewModel: CategoryAndRecommendationsViewModel = viewModel()

    var appBarVisible by remember { mutableStateOf(true) }
    var title by remember { mutableStateOf(context.getString(R.string.app_name)) }

    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            appBarVisible = destination.route != MyCityScreens.Details.name
            if (destination.route == MyCityScreens.Start.name) {
                title = context.getString(R.string.app_name)
            } else if (destination.route == MyCityScreens.Category.name) {
                title = context.getString(R.string.categories_text)
            }
        }
    }

    Scaffold(
        topBar = {
            MyCityTopBar(
                appBarVisible = appBarVisible,
                title = title,
                shouldShowArrow = navController.previousBackStackEntry != null,
                onNavigateBack = { navController.navigateUp() }
            )
        },
        modifier = modifier
    ) { innerPadding ->

        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = MyCityScreens.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(MyCityScreens.Start.name) {
                StartScreen(onContinueButtonClicked = {
                    navController.navigate(MyCityScreens.Category.name)
                })
            }
            composable(MyCityScreens.Category.name) {
                CategoryScreen(
                    categories = LocalDataCategoryProvider.categories,
                    onCategoryClicked = { type ->
                        title = context.getString(type.title)
                        viewModel.updateRecommendationsList(type)
                        navController.navigate(MyCityScreens.Recommendations.name)
                    }
                )
            }
            composable(MyCityScreens.Recommendations.name) {
                RecommendationListScreen(
                    uiState = uiState,
                    onRecommendationItemClicked = { recommendation ->
                        appBarVisible = false
                        viewModel.updateRecommendation(recommendation)
                        navController.navigate(MyCityScreens.Details.name)
                    }
                )
            }
            composable(MyCityScreens.Details.name) {
                DetailsScreen(
                    uiState = uiState,
                    onBackClick = { navController.navigateUp() }
                )
            }
        }
    }
}