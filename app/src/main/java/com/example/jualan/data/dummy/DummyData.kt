package com.example.jualan.data.dummy

import com.example.jualan.data.model.Category
import com.example.jualan.data.model.Product

object DummyData {
    val categories = listOf(
        Category(1, "Makanan", "Berbagai makanan khas daerah", 5),
        Category(2, "Minuman", "Minuman segar dan khas", 3),
        Category(3, "Souvenir", "Cinderamata lokal", 4)
    )

    val products = listOf(
        Product(1, "Mendoan", "Rp 5.000", "Tempe goreng khas Banyumas", 1, "dummy_product"),
        Product(2, "Nopia", "Rp 4.000", "Kue khas Purbalingga", 1, "dummy_product"),
        Product(3, "Es Dawet", "Rp 6.000", "Minuman segar dengan santan", 2, "dummy_product"),
        Product(4, "Wedang Uwuh", "Rp 7.000", "Teh herbal khas Jawa", 2, "dummy_product"),
        Product(5, "Sapu Glagah", "Rp 25.000", "Souvenir tradisional", 3, "dummy_product"),
        Product(6, "Kipas Batik", "Rp 30.000", "Souvenir batik daerah", 3, "dummy_product")
    )
}
