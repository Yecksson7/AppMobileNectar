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