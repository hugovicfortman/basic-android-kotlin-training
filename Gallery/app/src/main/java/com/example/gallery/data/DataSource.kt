package com.example.gallery.data

import com.example.gallery.R
import com.example.gallery.model.ImageFile
import java.util.Date

class DataSource {
    fun loadImageFiles(): List<ImageFile> {
        return listOf(
            ImageFile(R.string.filename1, R.drawable.image1, "jpg", 3072, Date()),
            ImageFile(R.string.filename2, R.drawable.image2, "jpg", 3586, Date()),
            ImageFile(R.string.filename3, R.drawable.image3, "jpg", 2560, Date()),
            ImageFile(R.string.filename4, R.drawable.image4, "jpg", 12024, Date()),
            ImageFile(R.string.filename5, R.drawable.image5, "jpg", 6024, Date()),
            ImageFile(R.string.filename6, R.drawable.image6, "jpg", 4020, Date()),
            ImageFile(R.string.filename7, R.drawable.image7, "jpg", 1928, Date()),
            ImageFile(R.string.filename8, R.drawable.image8, "jpg", 2226, Date()),
            ImageFile(R.string.filename9, R.drawable.image9, "jpg", 7323, Date()),
            ImageFile(R.string.filename10, R.drawable.image10, "jpg", 5628, Date()),
            ImageFile(R.string.filename11, R.drawable.image11, "jpg", 2648, Date())
        )
    }
}