// Paquete donde se encuentra el ViewModel del saludo
package app.application.saludo.ui.viewmodel

// ViewModel para manejar la lógica de la app
import androidx.lifecycle.ViewModel

// Flujos de estado reactivos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

// ViewModel que controla nombre, edad, carrera y saludo
class SaludoViewModel : ViewModel() {

    // ===============================
    // Estados privados mutables
    // ===============================

    // Guarda el nombre ingresado
    private val _nombre = MutableStateFlow("")

    // Guarda la edad ingresada
    private val _edad = MutableStateFlow("")

    // Guarda la carrera ingresada
    private val _carrera = MutableStateFlow("")

    // Guarda el mensaje de saludo
    private val _saludo = MutableStateFlow("")

    // ===============================
    // Estados públicos inmutables
    // ===============================

    // Estado observable del nombre
    val nombre: StateFlow<String> = _nombre

    // Estado observable de la edad
    val edad: StateFlow<String> = _edad

    // Estado observable de la carrera
    val carrera: StateFlow<String> = _carrera

    // Estado observable del saludo
    val saludo: StateFlow<String> = _saludo

    // ===============================
    // Funciones para actualizar datos
    // ===============================

    // Actualiza el nombre cuando el usuario escribe
    fun onNombreChange(nuevoNombre: String) {
        _nombre.value = nuevoNombre
    }

    // Actualiza la edad cuando el usuario escribe
    fun onEdadChange(nuevaEdad: String) {
        _edad.value = nuevaEdad
    }

    // Actualiza la carrera cuando el usuario escribe
    fun onCarreraChange(nuevaCarrera: String) {
        _carrera.value = nuevaCarrera
    }

    // ===============================
    // Acción del botón CONTINUAR
    // ===============================

    fun onContinuar() {

        // Obtiene los valores actuales
        val nombreTexto = _nombre.value
        val edadTexto = _edad.value
        val carreraTexto = _carrera.value

        // Intenta convertir la edad a número
        val edadNumero = edadTexto.toIntOrNull()

        // Valida los datos ingresados
        _saludo.value = if (
            nombreTexto.isBlank() ||
            edadNumero == null ||
            carreraTexto.isBlank()
        ) {

            // Mensaje de error si hay datos inválidos
            "Por favor ingresa nombre, edad y carrera"

        } else {

            // Determina la categoría según la edad
            val categoria = when {
                edadNumero <= 12 -> "un niño"
                edadNumero <= 17 -> "un joven"
                edadNumero <= 59 -> "un adulto"
                else -> "un adulto mayor"
            }

            // Mensaje final de saludo
            "Hola $nombreTexto, tienes $edadNumero años, estudias $carreraTexto y eres $categoria"
        }
    }
}
