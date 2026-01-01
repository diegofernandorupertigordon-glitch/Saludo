package app.application.saludo.viewmodel

import androidx.lifecycle.ViewModel
import app.application.saludo.model.Operacion
import app.application.saludo.repository.SaludoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class AppViewModel : ViewModel() {

    // Repositorio
    private val repository = SaludoRepository()

    // Estado interno
    private val _uiState = MutableStateFlow(Operacion())

    // Estado observable
    val uiState: StateFlow<Operacion> = _uiState

    fun actualizarNombre(nombre: String) {
        _uiState.update {
            it.copy(nombre = nombre)
        }
    }

    fun actualizarEdad(edad: String) {
        _uiState.update {
            it.copy(edad = edad)
        }
    }

    fun mostrarResultado() {
        val saludo = repository.generarSaludo(
            _uiState.value.nombre,
            _uiState.value.edad
        )

        _uiState.update {
            it.copy(mensaje = saludo)
        }
    }
}
