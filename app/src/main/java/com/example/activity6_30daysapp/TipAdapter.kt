package com.example.activity6_30daysapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.button.MaterialButton
import com.bumptech.glide.Glide

class TipAdapter(
    private val tips: List<Tip>,
    private val onTipStatusChanged: (Int, Boolean) -> Unit
) : RecyclerView.Adapter<TipAdapter.TipViewHolder>() {

    class TipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: MaterialCardView = itemView.findViewById(R.id.tipCardView)
        val dayNumberTextView: TextView = itemView.findViewById(R.id.dayNumberTextView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        val tipImageView: ImageView = itemView.findViewById(R.id.tipImageView)
        val completionCheckmark: ImageView = itemView.findViewById(R.id.completionCheckmark)
        val timelineLineTop: View = itemView.findViewById(R.id.timelineLineTop)
        val timelineLineBottom: View = itemView.findViewById(R.id.timelineLineBottom)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_timeline_tip, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tips[position]
        holder.dayNumberTextView.text = (position + 1).toString()
        holder.titleTextView.text = tip.title
        holder.descriptionTextView.text = tip.description

        // Use Glide to load the image
        Glide.with(holder.itemView.context)
            .load(tip.imageResId)
            .into(holder.tipImageView)

        updateTipAppearance(holder, tip)

        // Handle the timeline for first and last items
        when (position) {
            0 -> {
                holder.timelineLineTop.visibility = View.INVISIBLE
                holder.timelineLineBottom.visibility = View.VISIBLE
            }
            itemCount - 1 -> {
                holder.timelineLineTop.visibility = View.VISIBLE
                holder.timelineLineBottom.visibility = View.INVISIBLE
            }
            else -> {
                holder.timelineLineTop.visibility = View.VISIBLE
                holder.timelineLineBottom.visibility = View.VISIBLE
            }
        }

        holder.cardView.setOnClickListener {
            tip.completed = !tip.completed
            updateTipAppearance(holder, tip)
            onTipStatusChanged(position, tip.completed)
        }
    }

    private fun updateTipAppearance(holder: TipViewHolder, tip: Tip) {
        if (tip.completed) {
            holder.completionCheckmark.visibility = View.VISIBLE
            holder.cardView.alpha = 0.7f
        } else {
            holder.completionCheckmark.visibility = View.GONE
            holder.cardView.alpha = 1f
        }
    }

    override fun getItemCount(): Int = tips.size
}
