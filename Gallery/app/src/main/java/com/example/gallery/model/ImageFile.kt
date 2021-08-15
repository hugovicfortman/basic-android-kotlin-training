package com.example.gallery.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.text.SimpleDateFormat
import java.util.*

data class ImageFile(@StringRes val fileNameResourceId: Int
                     , @DrawableRes val fileThumbnailResourceId: Int
                     , val fileType: String, private val fileByteSize: Long
                     , private val fileDateCreated: Date) {
    val fileSize: String = getFileSize(fileByteSize)
    val fileCreated: String = getFileCreated(fileDateCreated)

    /*
    * Gets the size of a file with the right data units
    * */
    private fun getFileSize(byteSize: Long): String {
        val values = mutableListOf(byteSize * 1.0)
        var order = 0
        while(values[order] >= 1 &&  order < 5) {
            values.add(values[order] / 1024.0)
            order++
        }
        values.removeLast()
        return when (order) {
            5 -> "%.2f TB".format(values.last())
            4 -> "%.2f GB".format(values.last())
            3 -> "%.2f MB".format(values.last())
            2 -> "%.2f KB".format(values.last())
            else -> "%.0f bytes".format(values.last())
        }
    }

    /*
    * Gets date created in friendly string
    * */
    private fun getFileCreated(dateCreated: Date): String {
        val formatter = SimpleDateFormat("d MMM", Locale.US)
        return formatter.format(dateCreated)
    }
}