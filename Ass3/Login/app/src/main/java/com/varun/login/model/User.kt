package com.varun.login.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class User(
    @PrimaryKey(autoGenerate = true)    val uid         :Int?,
    @ColumnInfo(name = "first_name")    val firstName   :String?,
    @ColumnInfo(name = "last_name")     val lastName    :String?,
    @ColumnInfo(name = "phone")         val phone       :String?,
    @ColumnInfo(name = "email")         val email       :String?,
    @ColumnInfo(name = "degree")        val degree      :String?,
    @ColumnInfo(name = "college")       val college     :String?,
    @ColumnInfo(name = "grad_year")     val gradYear    :Int?,
    @ColumnInfo(name = "branch")        val branch      :String?
): Parcelable