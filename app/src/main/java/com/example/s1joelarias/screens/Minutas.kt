package com.example.s1joelarias.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

@Composable
fun Minuta() {
    var selectedDay by remember { mutableStateOf(0) }

    //  data classes
    data class Receta(
        val tipoComida: String,
        val nombre: String,
        val calorias: String,
        val infoNutricional: String
    )

    data class MenuDiario(
        val dia: String,
        val comidas: List<Receta>
    )

// menú semanal lista
    val menuSemanal = listOf(
        MenuDiario(
            dia = "Lunes",
            comidas = listOf(
                Receta(
                    tipoComida = "Desayuno",
                    nombre = "Avena con frutas y yogur",
                    calorias = "290 cal",
                    infoNutricional = "Proteínas: 8g, Carbos: 45g"
                ),
                Receta(
                    tipoComida = "Almuerzo",
                    nombre = "Pollo al horno con ensalada mixta",
                    calorias = "450 cal",
                    infoNutricional = "Proteínas: 35g, Carbos: 20g"
                ),
                Receta(
                    tipoComida = "Cena",
                    nombre = "Sopa de verduras con quinoa",
                    calorias = "280 cal",
                    infoNutricional = "Proteínas: 12g, Carbos: 35g"
                )
            )
        ),
        MenuDiario(
            dia = "Martes",
            comidas = listOf(
                Receta(
                    tipoComida = "Desayuno",
                    nombre = "Tostadas integrales con huevo revuelto",
                    calorias = "320 cal",
                    infoNutricional = "Proteínas: 15g, Carbos: 30g"
                ),
                Receta(
                    tipoComida = "Almuerzo",
                    nombre = "Pescado a la plancha con puré de papas",
                    calorias = "380 cal",
                    infoNutricional = "Proteínas: 40g, Carbos: 15g"
                ),
                Receta(
                    tipoComida = "Cena",
                    nombre = "Ensalada César con pollo",
                    calorias = "300 cal",
                    infoNutricional = "Proteínas: 20g, Carbos: 25g"
                )
            )
        ),
        MenuDiario(
            dia = "Miércoles",
            comidas = listOf(
                Receta(
                    tipoComida = "Desayuno",
                    nombre = "Batido de proteínas con plátano",
                    calorias = "310 cal",
                    infoNutricional = "Proteínas: 25g, Carbos: 40g"
                ),
                Receta(
                    tipoComida = "Almuerzo",
                    nombre = "Pasta integral con salsa de tomate",
                    calorias = "420 cal",
                    infoNutricional = "Proteínas: 15g, Carbos: 65g"
                ),
                Receta(
                    tipoComida = "Cena",
                    nombre = "Tortilla de verduras",
                    calorias = "290 cal",
                    infoNutricional = "Proteínas: 18g, Carbos: 25g"
                )
            )
        ),
        MenuDiario(
            dia = "Jueves",
            comidas = listOf(
                Receta(
                    tipoComida = "Desayuno",
                    nombre = "Pancakes de avena con miel",
                    calorias = "340 cal",
                    infoNutricional = "Proteínas: 10g, Carbos: 55g"
                ),
                Receta(
                    tipoComida = "Almuerzo",
                    nombre = "Ensalada de atún con aguacate",
                    calorias = "380 cal",
                    infoNutricional = "Proteínas: 30g, Carbos: 20g"
                ),
                Receta(
                    tipoComida = "Cena",
                    nombre = "Wrap de pavo con vegetales",
                    calorias = "320 cal",
                    infoNutricional = "Proteínas: 25g, Carbos: 30g"
                )
            )
        ),
        MenuDiario(
            dia = "Viernes",
            comidas = listOf(
                Receta(
                    tipoComida = "Desayuno",
                    nombre = "Bowl de frutas con granola",
                    calorias = "280 cal",
                    infoNutricional = "Proteínas: 8g, Carbos: 50g"
                ),
                Receta(
                    tipoComida = "Almuerzo",
                    nombre = "Arroz integral con pollo y vegetales",
                    calorias = "440 cal",
                    infoNutricional = "Proteínas: 32g, Carbos: 55g"
                ),
                Receta(
                    tipoComida = "Cena",
                    nombre = "Salmón al horno con espárragos",
                    calorias = "350 cal",
                    infoNutricional = "Proteínas: 35g, Carbos: 15g"
                )
            )
        )
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Minuta Semanal",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Selector de días
        ScrollableTabRow(
            selectedTabIndex = selectedDay,
            modifier = Modifier.fillMaxWidth()
        ) {
            menuSemanal.forEachIndexed { index, menu ->
                Tab(
                    selected = selectedDay == index,
                    onClick = { selectedDay = index },
                    text = { Text(menu.dia) }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar menú del día seleccionado
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(menuSemanal[selectedDay].comidas) { receta ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = receta.tipoComida,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.secondary
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = receta.nombre,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "${receta.calorias} - ${receta.infoNutricional}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}