package com.example.usrdel.evaluationapp

import android.os.Parcel
import android.os.Parcelable

class Perro(var nombre:String,var raza:String,var tamano:String,var fertilidad:String,var sexo:String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(raza)
        parcel.writeString(tamano)
        parcel.writeString(fertilidad)
        parcel.writeString(sexo)
    }
    override fun toString(): String {
        return "${nombre}"
    }
    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Perro> {
        override fun createFromParcel(parcel: Parcel): Perro {
            return Perro(parcel)
        }

        override fun newArray(size: Int): Array<Perro?> {
            return arrayOfNulls(size)
        }
    }


}