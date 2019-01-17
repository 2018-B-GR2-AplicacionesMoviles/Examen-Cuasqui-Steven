package com.example.usrdel.evaluationapp

import android.os.Parcel
import android.os.Parcelable

class Usuario(var id:String?, var nombre_usuario:String?, var apellido:String?):Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(nombre_usuario)
        parcel.writeString(apellido)
    }

    override fun describeContents(): Int {
        return 0
    }
    override fun toString(): String {

        return "${nombre_usuario}"

    }

    companion object CREATOR : Parcelable.Creator<Usuario> {
        override fun createFromParcel(parcel: Parcel): Usuario {
            return Usuario(parcel)
        }

        override fun newArray(size: Int): Array<Usuario?> {
            return arrayOfNulls(size)
        }
    }


}