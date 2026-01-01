# 📱 Proyecto Saludo - Android Jetpack Compose

## 📌 Descripción

**Proyecto Saludo** es una aplicación Android desarrollada con **Jetpack Compose** y el patrón de arquitectura **MVVM**. La aplicación permite al usuario ingresar su **nombre**, **edad** y **carrera**, y luego muestra un mensaje personalizado con animaciones modernas.

Este proyecto fue creado con fines **académicos**, aplicando buenas prácticas de desarrollo Android y una correcta separación entre lógica y vista.

---

## 🚀 Funcionalidades

* ✅ Pantalla Splash animada
* ✅ Ingreso de nombre, edad y carrera
* ✅ Validación de datos de entrada
* ✅ Mensaje personalizado según la edad
* ✅ Animaciones con Jetpack Compose
* ✅ Tema claro / oscuro
* ✅ Composable reutilizable

---

## 🧠 Arquitectura

La aplicación utiliza el patrón **MVVM (Model - View - ViewModel)**:

* **View**: Jetpack Compose (`AppScreen`, `SplashScreen`)
* **ViewModel**: Manejo del estado y lógica (`SaludoViewModel`)
* **Model**: Representación de datos

Esto permite:

* Mejor mantenimiento del código
* Separación clara de responsabilidades
* Escalabilidad del proyecto

---

## 🛠️ Tecnologías utilizadas

* **Kotlin**
* **Jetpack Compose**
* **Material 3**
* **StateFlow**
* **ViewModel**
* **Android Studio**

---

## 📂 Estructura del proyecto

```
app.application.saludo
│
├── ui
│   ├── AppScreen.kt
│   ├── SplashScreen.kt
│   └── theme
│
├── ui.viewmodel
│   └── SaludoViewModel.kt
│
├── model
│   └── Operacion.kt
│
└── MainActivity.kt
```

---

## ♻️ Composable Reutilizable

Se implementó un **Composable reutilizable** llamado `UserInfoText`, encargado de mostrar:

* Nombre
* Edad
* Carrera

Este composable recibe los datos por parámetros y se puede reutilizar en diferentes pantallas sin duplicar código.

---

## 📷 Capturas de pantalla

<img width="350" height="777" alt="image" src="https://github.com/user-attachments/assets/223ba044-6960-4217-8e68-289db2698ba0" />

---

## ▶️ Cómo ejecutar el proyecto

1. Clona el repositorio:

```bash
[git clone https://github.com/tu-usuario/nombre-del-repo.git
](https://github.com/diegofernandorupertigordon-glitch/Saludo.git)```

2. Ábrelo en **Android Studio**
3. Sincroniza Gradle
4. Ejecuta en un emulador o dispositivo físico

---

## 👨‍🎓 Autor

**Diego Ruperti**
Estudiante de desarrollo de software



⭐ Si este proyecto te resulta útil, no olvides darle una estrella en GitHub ⭐
