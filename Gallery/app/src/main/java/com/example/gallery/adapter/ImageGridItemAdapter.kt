package com.example.gallery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.R
import com.example.gallery.model.ImageFile

/**
 * Adapter for the [RecyclerView] in [ MainActivity ]. Displays [ImageFile] data object.
 */
class ImageGridItemAdapter(private val context: Context, private val dataset: List<ImageFile>):
    RecyclerView.Adapter<ImageGridItemAdapter.ViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an [ImageFile] object.
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val fileThumbnailImage: ImageView = view.findViewById(R.id.file_thumbnail_image)
        val fileTypeIconImage: ImageView = view.findViewById(R.id.file_type_icon_image)
        val fileNameText: TextView = view.findViewById(R.id.file_name_text)
        val fileSizeText: TextView = view.findViewById(R.id.file_size_text)
        val fileCreatedDateText: TextView = view.findViewById(R.id.file_created_date_text)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grid, parent, false)
        return ViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of the current active view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fileImage = dataset[position]

        holder.fileNameText.text = context.getString(fileImage.fileNameResourceId)
        holder.fileSizeText.text = fileImage.fileSize
        holder.fileCreatedDateText.text = fileImage.fileCreated

        holder.fileThumbnailImage.setImageResource(fileImage.fileThumbnailResourceId)
        when(fileImage.fileType) {
            "jpg" -> {
                holder.fileTypeIconImage.setImageResource(R.drawable.ic_file_type_image)
                holder.fileTypeIconImage.contentDescription = context
                    .getString(R.string.file_type_description_photo)
            }
            else -> {
                holder.fileTypeIconImage.contentDescription = context
                    .getString(R.string.file_type_description_unknown)
            }
        }
    }


    /**
     * Return the size of the dataset (invoked by the layout manager)
     */
    override fun getItemCount(): Int = dataset.size

}