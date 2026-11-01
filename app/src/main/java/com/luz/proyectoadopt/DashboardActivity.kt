package com.luz.proyectoadopt

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material.icons.outlined.MoreHoriz
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.Pets
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Storefront
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.luz.proyectoadopt.components.Boton
import com.luz.proyectoadopt.components.PillCard
import com.luz.proyectoadopt.screens.mascotas.MascotasActivity
import com.luz.proyectoadopt.screens.refugios.RefugiosActivity
import com.luz.proyectoadopt.ui.theme.AppTheme
import com.luz.proyectoadopt.ui.theme.ProyectoAdoptTheme

sealed interface AppRoute{
    data object Inicio: AppRoute
    data object Mascotas: AppRoute
    data object Refugios: AppRoute
    data object MisSolicitudes: AppRoute
    data object Tienda : AppRoute
    data object Donacion: AppRoute
    data object Carrito: AppRoute
    data object Mas: AppRoute
    data object  Voluntariado: AppRoute
}

data class DashboardModule(
    val route: com.luz.proyectoadopt.AppRoute,
    val icon: ImageVector,
    val titleRes: Int,
)

data class BottomNavItem(
    val route: com.luz.proyectoadopt.AppRoute,
    val labelRes: Int,
    val icon: ImageVector
)

private val bottomNavItems = listOf(
    BottomNavItem(com.luz.proyectoadopt.AppRoute.Inicio, R.string.bottom_nav_home, Icons.Filled.Home),
    BottomNavItem(com.luz.proyectoadopt.AppRoute.Tienda, R.string.bottom_nav_store, Icons.Outlined.Storefront),
    BottomNavItem(com.luz.proyectoadopt.AppRoute.Mascotas, R.string.bottom_nav_pet, Icons.Outlined.Pets),
    BottomNavItem(com.luz.proyectoadopt.AppRoute.Carrito, R.string.bottom_nav_cart, Icons.Outlined.ShoppingCart),
    BottomNavItem(com.luz.proyectoadopt.AppRoute.Mas, R.string.bottom_nav_more, Icons.Outlined.MoreHoriz)
)

private val dashboardModules = listOf(
    DashboardModule(
        AppRoute.Mascotas,
        Icons.Filled.Pets,
        R.string.dashboard_item_pets_title
    ),
    DashboardModule(
        AppRoute.Refugios,
        Icons.Outlined.People,
        R.string.dashboard_item_refugio_title
    ),
    DashboardModule(
        AppRoute.MisSolicitudes,
        Icons.Filled.Receipt,
        R.string.dashboard_item_solicitudes_title
    ),
    DashboardModule(
        AppRoute.Tienda,
        Icons.Filled.Storefront,
        R.string.dashboard_item_store_title
    ),
    DashboardModule(
        AppRoute.Donacion,
        Icons.Filled.Coffee,
        R.string.dashboard_item_donacion_title
    ),
    DashboardModule(
        AppRoute.Voluntariado,
        Icons.Filled.Coffee,
        R.string.dashboard_title_voluntariado
    ),
)

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoAdoptTheme {
                DashboardScreen(
                    onNavigate = { route ->
                        when (route) {
                            AppRoute.Inicio -> {}
                            AppRoute.Mascotas -> {
                                startActivity(Intent(this, MascotasActivity::class.java))
                            }
                            AppRoute.Refugios -> {
                                startActivity(Intent(this, RefugiosActivity::class.java))
                            }
                            AppRoute.Tienda -> {}
                            AppRoute.MisSolicitudes -> {}
                            AppRoute.Donacion -> {}
                            AppRoute.Carrito -> {}
                            AppRoute.Mas -> {}
                            AppRoute.Voluntariado -> {
                            }
                        }

                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    onNavigate: (AppRoute) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.primary,
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.regular)
                        ) {
                        Box(modifier = Modifier.height(AppTheme.sizes.iconContainerMedium)
                            .clip(CircleShape)
                        ) {
                            Image(
                                painterResource(R.drawable.profilepic),
                                contentDescription = null
                            )
                        }
                        Column() {
                            Text(
                                text = stringResource(R.string.dashboard_greeting),
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.background,
                                modifier = Modifier.padding(bottom = 3.dp)
                            )
                            Text(
                                text = stringResource(R.string.dashboard_welcome_back),
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.background.copy(alpha = 0.7f)
                            )
                        }
                    }
                },
                actions = {
                    Row() {
                        FilledTonalIconButton(
                            onClick = {},
                            modifier = Modifier.padding(end = AppTheme.spacing.small)
                                .size(AppTheme.sizes.iconContainerMedium),
                            colors = IconButtonDefaults.filledIconButtonColors(
                                containerColor = Color.White,
                                contentColor = MaterialTheme.colorScheme.background.copy(0.4f)
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.NotificationsNone,
                                contentDescription = null,
                                modifier = Modifier.size(AppTheme.sizes.iconMedium)
                            )
                        }
                        FilledTonalIconButton(
                            onClick = {},
                            modifier = Modifier.padding(end = AppTheme.spacing.regular)
                                .size(AppTheme.sizes.iconContainerMedium),
                            colors = IconButtonDefaults.filledIconButtonColors(
                                containerColor = Color.White,
                                contentColor = MaterialTheme.colorScheme.background.copy(0.4f)
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.ShoppingCart,
                                contentDescription = null,
                                modifier = Modifier.size(AppTheme.sizes.iconMedium)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )

        },
        bottomBar = {
            DashboardBottomNavigation(onNavigate = onNavigate)
        }
        ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)
            .padding(horizontal = AppTheme.spacing.regular)
        ) {
            Spacer(modifier = Modifier.height(AppTheme.spacing.medium))
            DashboardBanner()
            Spacer(modifier = Modifier.height(AppTheme.spacing.medium))
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = stringResource(R.string.dashboard_pregunta),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold
                )
                TextButton(
                    onClick = {}
                ) {
                    Text(
                        text = stringResource(R.string.dashboard_mostrar_mas),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }
            }
            Spacer(modifier = Modifier.height(AppTheme.spacing.medium))
            LazyVerticalGrid( columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.regular),
                verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.regular)
            ) {
                items( items = dashboardModules,
                    key = {it.titleRes}
                ) {
                    module ->
                    PillCard(
                        module = module,
                        onNavigate = { onNavigate(module.route) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(AppTheme.spacing.medium))
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = stringResource(R.string.dashboard_mascotas_disp),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold
                )
                TextButton(
                    onClick = {}
                ) {
                    Text(
                        text = stringResource(R.string.dashboard_mostrar_mas),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }
            }
            Spacer(modifier = Modifier.height(AppTheme.spacing.medium))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.regular)
            ) {
                item {
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Box(modifier = Modifier.fillMaxWidth()
                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(12.dp))
                            ) {
                                Image(
                                    painterResource(R.drawable.dog_dashboard),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Spacer(modifier = Modifier.height(AppTheme.spacing.small))
                            Text(
                                text = stringResource(R.string.dashboard_card1_titulo),
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.background
                            )
                            Text(
                                text = stringResource(R.string.dashboard_edad1),
                                color = MaterialTheme.colorScheme.background.copy(0.5f)
                            )
                        }
                    }
                }
                item {
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Box(modifier = Modifier.fillMaxWidth()
                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(12.dp))
                            ) {
                                Image(
                                    painterResource(R.drawable.cat_dashboard),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Spacer(modifier = Modifier.height(AppTheme.spacing.small))
                            Text(
                                text = stringResource(R.string.dashboard_card2_titulo),
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.background
                            )
                            Text(
                                text = stringResource(R.string.dashboard_edad2),
                                color = MaterialTheme.colorScheme.background.copy(0.5f)
                            )
                        }
                    }
                }
            }

        }
    }
}

@Composable
fun DashboardBanner(
    modifier: Modifier = Modifier
) {
    Box(modifier = Modifier.fillMaxWidth()
        .height(190.dp)
        .clip(RoundedCornerShape(AppTheme.sizes.cardCornerRadius))
        .background(MaterialTheme.colorScheme.tertiary)
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Column(modifier = Modifier.fillMaxHeight()
                .fillMaxWidth(0.6f)
                .padding(AppTheme.spacing.regular)
                .padding(vertical = AppTheme.spacing.regular),
                verticalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = stringResource(R.string.dashboard_welcome_kicker),
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = stringResource(R.string.dashboard_subtitle),
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(AppTheme.spacing.regular))
                Boton(
                    click = {},
                    bgColor = Color.White,
                    texto = "Adopta ahora",
                    frColor = MaterialTheme.colorScheme.background
                )
            }
            Column(
                modifier = Modifier.height(250.dp)) {
                Image(painterResource(R.drawable.dash_banner_img),
                    contentDescription = null)
                }
        }
    }
}



@Composable
fun DashboardBottomNavigation(
    modifier: Modifier = Modifier,
    selectedRoute: AppRoute = AppRoute.Inicio,
    onNavigate: (AppRoute) -> Unit
) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
        ) {
        NavigationBar(
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color.Transparent,
            tonalElevation = AppTheme.spacing.none,
            windowInsets = WindowInsets(0, 0, 0, 0)) {
            bottomNavItems.forEach { item ->
                NavigationBarItem(
                    selected = item.route == selectedRoute,
                    onClick = { onNavigate(item.route) },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = null,
                            modifier = Modifier.size(AppTheme.sizes.iconLarge)
                        )
                    },
                    label = {
                        Text(stringResource(item.labelRes),
                            style = MaterialTheme.typography.labelLarge)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.tertiary,
                        selectedTextColor = MaterialTheme.colorScheme.tertiary,
                        indicatorColor = Color.Transparent,
                        unselectedIconColor = MaterialTheme.colorScheme.background.copy(0.4f),
                        unselectedTextColor = MaterialTheme.colorScheme.background.copy(0.4f)
                    )
                )
            }
        }
    }
}
