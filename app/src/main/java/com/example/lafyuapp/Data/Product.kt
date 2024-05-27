package com.example.lafyuapp.Data

import android.os.Parcel
import android.os.Parcelable

data class Product(
    val name: String,
    val price: String,
    val imageResId: Int,
    val sizes: List<String>,
    val colors: List<Int>,
    val reviews: List<Review>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.createStringArrayList() ?: emptyList(),
        mutableListOf<Int>().apply {
            parcel.readList(this, Int::class.java.classLoader)
        },
        mutableListOf<Review>().apply {
            parcel.readList(this, Review::class.java.classLoader)
        }
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(price)
        parcel.writeInt(imageResId)
        parcel.writeStringList(sizes)
        parcel.writeList(colors)
        parcel.writeList(reviews)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}

data class Review(
    val username: String,
    val rating: Float,
    val reviewText: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readFloat(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeFloat(rating)
        parcel.writeString(reviewText)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Review> {
        override fun createFromParcel(parcel: Parcel): Review {
            return Review(parcel)
        }

        override fun newArray(size: Int): Array<Review?> {
            return arrayOfNulls(size)
        }
    }
}
