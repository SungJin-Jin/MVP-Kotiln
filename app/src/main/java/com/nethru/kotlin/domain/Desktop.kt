package com.nethru.howltalk.domain

import android.os.Parcel
import android.os.Parcelable

data class Desktop(var id: Long,
                   var name: String,
                   var os: String,
                   var memory: Long,
                   var cpuName: List<String>,
                   var cpuCore: Int,
                   var cpuProcess: Int,
                   var gpuName: List<String>) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readString(),
            parcel.readLong(),
            parcel.createStringArrayList(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.createStringArrayList())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeString(os)
        parcel.writeLong(memory)
        parcel.writeStringList(cpuName)
        parcel.writeInt(cpuCore)
        parcel.writeInt(cpuProcess)
        parcel.writeStringList(gpuName)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "Desktop(id=$id, name='$name', os='$os', memory=$memory, cpuName=$cpuName, cpuCore=$cpuCore, cpuProcess=$cpuProcess, gpuName=$gpuName)"
    }

    companion object CREATOR : Parcelable.Creator<Desktop> {
        override fun createFromParcel(parcel: Parcel) = Desktop(parcel)

        override fun newArray(size: Int): Array<Desktop?> = arrayOfNulls(size = size)
    }
}