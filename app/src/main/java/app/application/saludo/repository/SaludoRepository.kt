package app.application.saludo.repository

// Lógica de negocio separada de la UI
class SaludoRepository {

    fun generarSaludo(nombre: String, edad: String): String {
        return "Hola $nombre, tienes $edad años"
    }
}
