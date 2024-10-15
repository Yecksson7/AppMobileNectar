package com.example.nectarapplication.data

import com.example.nectarapplication.R
import com.example.nectarapplication.ui.themes.softBlue
import com.example.nectarapplication.ui.themes.softGreen
import com.example.nectarapplication.ui.themes.softOrange
import com.example.nectarapplication.ui.themes.softPink
import com.example.nectarapplication.ui.themes.softPurple
import com.example.nectarapplication.ui.themes.softYellow

val HomeProducts = listOf(
    CartProducts(id = 1, R.drawable.banana, title = "Organic Bananas", porcion = "7pcs, Priceg", precio = 4.99),
    CartProducts(id = 2, R.drawable.manzanas, title = "Red Apple", porcion = "1kg, Priceg", precio = 4.99),
    CartProducts(id = 3, R.drawable.morrones, title = "Bell Pepper Red", porcion = "1kg, Priceg", precio = 4.99),
    CartProducts(id = 4, R.drawable.jengibre, title = "Ginger", porcion = "250gm, Priceg", precio = 2.99),
)

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
    CartProducts(id = 3, R.drawable.banana, title = "Organic Bannanas", porcion = "12Kg, Price", precio = 3.00),
    CartProducts(id = 4, R.drawable.jengibre, title = "Ginger", porcion = "250gm, Price", precio = 2.99),
    )

val FavouritesItems = listOf(
    CartProducts(id = 1, R.drawable.sprite, title = "Sprite Can", porcion = "325ml, Price", precio = 1.50),
    CartProducts(id = 2, R.drawable.cokalight, title = "Diet Coke", porcion = "355ml, Price", precio = 1.99),
    CartProducts(id = 3, R.drawable.jugomanzana, title = "Apple & Grape Juice", porcion = "2L, Price", precio = 15.50),
    CartProducts(id = 4, R.drawable.cocacola, title = "Coca Cola Can", porcion = "352ml, Price", precio = 4.99),
    CartProducts(id = 5, R.drawable.pepsi, title = "Pepsi Can", porcion = "330ml, Price", precio = 4.99),
)

val DetailItems = listOf(
    DetailProducts(id = 1, R.drawable.banana, title = "Organic Bananas", porcion = "7pcs, Priceg", precio = 4.99, productDetail = "Bananas are a great source of essential nutrients. Rich in potassium, they can help regulate blood pressure and support heart health. Additionally, bananas provide dietary fiber, which may aid in digestion and promote feelings of fullness, potentially assisting in weight management."),
    DetailProducts(id = 2, R.drawable.manzanas, title = "Red Apple", porcion = "1kg, Priceg", precio = 4.99, productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet."),
    DetailProducts(id = 3, R.drawable.morrones, title = "Bell Pepper Red", porcion = "1kg, Priceg", precio = 4.99, productDetail = "Bell peppers, also known as sweet peppers or capsicum, are a fantastic addition to a healthy diet. They are low in calories and packed with vitamins and antioxidants, particularly vitamin C, which supports the immune system. Additionally, their high fiber content can promote good digestion and improve gut health."),
    DetailProducts(id = 4, R.drawable.jengibre, title = "Ginger", porcion = "250gm, Priceg", precio = 2.99, productDetail = "Ginger is a powerful root known for its numerous health benefits and culinary versatility. It is rich in antioxidants and has anti-inflammatory properties, making it effective for alleviating nausea, especially in pregnancy or after surgery. Ginger may also help with digestive issues and has been shown to support the immune system."),
)