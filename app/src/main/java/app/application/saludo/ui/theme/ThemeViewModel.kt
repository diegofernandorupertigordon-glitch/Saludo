// Paquete donde se maneja el tema de la aplicación
package app.application.saludo.ui.theme

// Permite manejar estados observables en Compose
import androidx.compose.runtime.mutableStateOf

// Clase base para ViewModel
import androidx.lifecycle.ViewModel

// ViewModel encargado del tema claro / oscuro
class ThemeViewModel : ViewModel() {

    // Estado que indica si el tema oscuro está activo
    // mutableStateOf permite que Compose reaccione a los cambios
    var isDark = mutableStateOf(false)
        // Evita que se modifique directamente desde fuera
        private set

    // Cambia entre tema claro y oscuro
    fun toggleTheme() {
        // Invierte el valor actual
        isDark.value = !isDark.value
    }
}
