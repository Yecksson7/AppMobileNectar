package com.example.nectarapplication.data

import com.example.nectarapplication.R
import com.example.nectarapplication.ui.themes.softBlue
import com.example.nectarapplication.ui.themes.softGreen
import com.example.nectarapplication.ui.themes.softOrange
import com.example.nectarapplication.ui.themes.softPink
import com.example.nectarapplication.ui.themes.softPurple
import com.example.nectarapplication.ui.themes.softYellow


val ExploreItems = listOf(
    Products(1, R.drawable.frutas, "Fresh fruit & vegetables", borderColor = softGreen, backgroundColor = softGreen.copy(0.3f)),
    Products(2, R.drawable.oliva, "Cooking oil & Ghee", borderColor = softOrange, backgroundColor = softOrange.copy(alpha = 0.3f)),
    Products(3, R.drawable.carnes, "Meat & Fish", borderColor = softPink, backgroundColor = softPink.copy(alpha = 0.3f)),
    Products(4, R.drawable.pan, "Bakery & snacks",  borderColor = softPurple, backgroundColor = softPurple.copy(alpha = 0.3f)),
    Products(5, R.drawable.lacteos, "Dairy & eggs",  borderColor = softYellow, backgroundColor = softYellow.copy(alpha = 0.3f)),
    Products(6, R.drawable.gaseosas, "Beverages",  borderColor = softBlue, backgroundColor = softBlue.copy(alpha = 0.3f)),
)

val MyCartItems = listOf(
    CartProducts(id = 1, R.drawable.morrones, title = "Bell Pepper Red", porcion = "1Kg, Price", precio = 4.99),
    CartProducts(id = 2, R.drawable.huevos, title = "Egg Chicken Red", porcion = "4pcs, Price", precio = 1.99),
    CartProducts(id = 1, R.drawable.banana, title = "Organic Bannanas", porcion = "12Kg, Price", precio = 3.00),
    CartProducts(id = 1, R.drawable.jengibre, title = "Ginger", porcion = "250gm, Price", precio = 2.99),
    )