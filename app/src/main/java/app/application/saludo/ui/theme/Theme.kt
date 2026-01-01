// Paquete donde se define el tema de la aplicación
package app.application.saludo.ui.theme

// Permite verificar la versión de Android
import android.os.Build

// Detecta si el sistema está en modo oscuro
import androidx.compose.foundation.isSystemInDarkTheme

// Componentes de Material 3
import androidx.compose.material3.*

// Permite crear funciones Composable
import androidx.compose.runtime.Composable

// Accede al contexto de la aplicación
import androidx.compose.ui.platform.LocalContext

// ===============================
// Esquema de colores oscuro
// ===============================
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

// ===============================
// Esquema de colores claro
// ===============================
private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

// ===============================
// Tema principal de la app
// ===============================
@Composable
fun SaludoTheme(
    // Indica si se usa el tema oscuro
    darkTheme: Boolean = isSystemInDarkTheme(),

    // Permite usar colores dinámicos (Android 12+)
    dynamicColor: Boolean = true,

    // Contenido de la aplicación
    content: @Composable () -> Unit
) {

    // Selecciona el esquema de colores
    val colorScheme = when {

        // Usa colores dinámicos si el sistema lo soporta
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme)
                dynamicDarkColorScheme(context)
            else
                dynamicLightColorScheme(context)
        }

        // Tema oscuro manual
        darkTheme -> DarkColorScheme

        // Tema claro manual
        else -> LightColorScheme
    }

    // Aplica el tema a toda la app
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
