// Paquete donde se encuentra esta pantalla
package app.application.saludo.ui

// Importaciones para animaciones en Compose
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically

// Importaciones para animaciones continuas
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween

// Componentes de diseño y layout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions

// Componentes Material 3
import androidx.compose.material3.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Permite usar ViewModel en Compose
import androidx.lifecycle.viewmodel.compose.viewModel

// Tema de la app
import app.application.saludo.ui.theme.SaludoTheme

// ViewModel del saludo
import app.application.saludo.ui.viewmodel.SaludoViewModel

// Composable principal de la aplicación
@Composable
fun AppScreen(
    // Se obtiene el ViewModel automáticamente
    saludoViewModel: SaludoViewModel = viewModel()
) {
    // Observa el nombre desde el ViewModel
    val nombre by saludoViewModel.nombre.collectAsState()

    // Observa la edad desde el ViewModel
    val edad by saludoViewModel.edad.collectAsState()

    // Observa la carrera desde el ViewModel
    val carrera by saludoViewModel.carrera.collectAsState()

    // Observa el saludo generado
    val saludo by saludoViewModel.saludo.collectAsState()

    // Estado para mostrar u ocultar el resultado animado
    var showResult by remember { mutableStateOf(false) }

    // Animación infinita tipo brillo (glow)
    val infiniteTransition = rememberInfiniteTransition(label = "glow")

    // Valor animado que va de 0.6 a 1
    val glowAlpha by infiniteTransition.animateFloat(
        initialValue = 0.6f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            tween(1400, easing = EaseInOut),
            RepeatMode.Reverse
        ),
        label = "glowAlpha"
    )

    // Contenedor principal de toda la pantalla
    Box(
        modifier = Modifier
            .fillMaxSize()
            // Fondo degradado vertical
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF0A0F1F),
                        Color(0xFF101A2F),
                        Color(0xFF0A0F1F)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        // Tarjeta principal
        Card(
            modifier = Modifier.fillMaxWidth(0.9f),
            shape = RoundedCornerShape(26.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF111827)
            ),
            elevation = CardDefaults.cardElevation(16.dp)
        ) {

            // Columna para organizar los elementos
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {

                // Título de la app
                Text(
                    text = "SALUDO",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color(0xFF64FFDA).copy(alpha = glowAlpha)
                )

                // Campo de texto para el nombre
                OutlinedTextField(
                    value = nombre,
                    onValueChange = saludoViewModel::onNombreChange,
                    label = { Text("Nombre", color = Color(0xFF9CA3AF)) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedBorderColor = Color(0xFF64FFDA),
                        unfocusedBorderColor = Color(0xFF374151)
                    )
                )

                // Campo de texto para la edad
                OutlinedTextField(
                    value = edad,
                    onValueChange = saludoViewModel::onEdadChange,
                    label = { Text("Edad", color = Color(0xFF9CA3AF)) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedBorderColor = Color(0xFF64FFDA),
                        unfocusedBorderColor = Color(0xFF374151)
                    )
                )

                // Campo de texto para la carrera
                OutlinedTextField(
                    value = carrera,
                    onValueChange = saludoViewModel::onCarreraChange,
                    label = { Text("Carrera", color = Color(0xFF9CA3AF)) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedBorderColor = Color(0xFF64FFDA),
                        unfocusedBorderColor = Color(0xFF374151)
                    )
                )

                // Botón para continuar
                Button(
                    onClick = {
                        saludoViewModel.onContinuar()
                        showResult = true
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp)
                        .scale(glowAlpha),
                    shape = RoundedCornerShape(18.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF64FFDA),
                        contentColor = Color.Black
                    )
                ) {
                    Text("CONTINUAR")
                }

                // Resultado con animación
                AnimatedVisibility(
                    visible = showResult && saludo.isNotBlank(),
                    enter = slideInVertically { it } + fadeIn(),
                    exit = slideOutVertically { it } + fadeOut()
                ) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF1F2937)
                        )
                    ) {
                        // 🔽 AQUÍ SE USA EL COMPOSABLE REUTILIZABLE
                        UserInfoText(
                            nombre = nombre,
                            edad = edad,
                            carrera = carrera
                        )
                    }
                }
            }
        }
    }
}

/* =========================================================
   COMPOSABLE REUTILIZABLE
   Muestra nombre, edad y carrera
   ========================================================= */
@Composable
fun UserInfoText(
    nombre: String,
    edad: String,
    carrera: String
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(
            text = "Nombre: $nombre",
            color = Color(0xFFE5E7EB)
        )
        Text(
            text = "Edad: $edad",
            color = Color(0xFFE5E7EB)
        )
        Text(
            text = "Carrera: $carrera",
            color = Color(0xFFE5E7EB)
        )
    }
}

// Vista previa en Android Studio
@Preview(showBackground = true)
@Composable
fun AppScreenPreview() {
    SaludoTheme {
        AppScreen()
    }
}
