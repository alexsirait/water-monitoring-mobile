package com.example.visuda.components

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.visuda.R
import com.example.visuda.navigation.NavigationItem
import com.example.visuda.navigation.Routes
import com.example.visuda.ui.theme.biru


@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val selectedItemColor = Color(0xFF1C1B1B)
    val unselectedItemColor = Color(0xFFDDD9D9)

    NavigationBar(
        modifier = modifier,
        containerColor = biru
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.beranda),
                icon = Icons.Default.Home,
                screen = Routes.Beranda
            ),
            NavigationItem(
                title = stringResource(id = R.string.riwayat),
                icon = Icons.Default.History,
                screen = Routes.Riwayat
            ),
            NavigationItem(
                title = stringResource(id = R.string.profil),
                icon = Icons.Default.AccountCircle,
                screen = Routes.Profile
            ),
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = if (currentRoute == item.screen.route) selectedItemColor else unselectedItemColor
                    )
                },
                label = {Text(text = item.title, color = if (currentRoute == item.screen.route) unselectedItemColor else selectedItemColor)},
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.White
                ),
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun preview(modifier: Modifier = Modifier,
                    navController: NavHostController = rememberNavController()
){
    BottomBar(navController =navController , modifier = Modifier.background(biru))
}
