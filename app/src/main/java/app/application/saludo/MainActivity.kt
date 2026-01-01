// Paquete donde se encuentra esta actividad
package app.application.saludo

// Importaciones básicas de Android
import android.os.Bundle

// Actividad base para usar Jetpack Compose
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

// Componentes de Material 3
import androidx.compose.material3.Surface

// Manejo de estados en Compose
import androidx.compose.runtime.*

// Herramienta para vista previa en Android Studio
import androidx.compose.ui.tooling.preview.Preview

// Permite usar ViewModel dentro de Compose
import androidx.lifecycle.viewmodel.compose.viewModel

// Pantalla principal de la app
import app.application.saludo.ui.AppScreen

// Pantalla de carga (Splash)
import app.application.saludo.ui.SplashScreen

// Tema personalizado de la app
import app.application.saludo.ui.theme.SaludoTheme

// ViewModel que controla el tema claro/oscuro
import app.application.saludo.ui.theme.ThemeViewModel

// Actividad principal de la aplicación
class MainActivity : ComponentActivity() {

    // Método que se ejecuta al iniciar la app
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define el contenido usando Jetpack Compose
        setContent {

            // Obtiene el ViewModel del tema
            val themeViewModel: ThemeViewModel = viewModel()

            // Observa si el tema es oscuro
            val isDark by themeViewModel.isDark

            // Aplica el tema claro u oscuro
            SaludoTheme(
                darkTheme = isDark
            ) {

                // Estado para controlar si se muestra el Splash
                var showSplash by remember { mutableStateOf(true) }

                // Contenedor principal de la interfaz
                Surface {

                    // Si showSplash es true, muestra el Splash
                    if (showSplash) {
                        SplashScreen {
                            // Cuando termina el Splash, pasa a la app
                            showSplash = false
                        }
                    } else {
                        // Muestra la pantalla principal
                        AppScreen()
                    }
                }
            }
        }
    }
}

// Vista previa para Android Studio
@Preview(
    showBackground = true,
    device = "spec:width=360dp,height=800dp,dpi=440"
)
@Composable
fun AppPreview() {
    // Aplica el tema en la vista previa
    SaludoTheme {
        // Muestra la pantalla principal en preview
        AppScreen()
    }
}
