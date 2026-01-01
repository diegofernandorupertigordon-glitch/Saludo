// Paquete donde se encuentra la pantalla Splash
package app.application.saludo.ui

// Importaciones para animaciones en Jetpack Compose
import androidx.compose.animation.*
import androidx.compose.animation.core.*

// Importaciones para diseño y layout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

// Componentes Material
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

// Manejo de estados y efectos
import androidx.compose.runtime.*

// Alineación y modificadores de UI
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

// Colores y fondos
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Tipografía
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Corrutinas para el delay
import kotlinx.coroutines.delay

// Composable de la pantalla Splash
@Composable
fun SplashScreen(
    // Función que se ejecuta cuando termina el Splash
    onFinish: () -> Unit
) {
    // Controla la visibilidad del texto
    var visible by remember { mutableStateOf(false) }

    // Se ejecuta una sola vez al entrar a la pantalla
    LaunchedEffect(Unit) {
        // Activa la animación
        visible = true

        // Espera 2 segundos
        delay(2000)

        // Notifica que el Splash terminó
        onFinish()
    }

    // Contenedor principal de la pantalla
    Box(
        modifier = Modifier
            .fillMaxSize()
            // Fondo con degradado vertical
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF0A0F1F),
                        Color(0xFF101A2F),
                        Color(0xFF0A0F1F)
                    )
                )
            ),
        // Centra el contenido
        contentAlignment = Alignment.Center
    ) {

        // Animación de aparición y desaparición
        AnimatedVisibility(
            visible = visible,
            enter =
                // Aparece con desvanecido
                fadeIn(animationSpec = tween(1200)) +
                        // Aparece escalando desde más pequeño
                        scaleIn(initialScale = 0.8f),
            exit = fadeOut()
        ) {

            // Texto del Splash
            Text(
                text = "SALUDO",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF64FFDA)
            )
        }
    }
}
