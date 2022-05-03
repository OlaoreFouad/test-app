package dev.olaore.ifytestapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.olaore.ifytestapp.databinding.ItemStopBinding

class StopListAdapter(
    private val onRemoveItem: (Int) -> Unit
) : ListAdapter<Stop, StopListAdapter.StopViewHolder>(
    DiffUtilCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StopViewHolder {
        return StopViewHolder(
            ItemStopBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onRemoveItem
        )
    }

    override fun onBindViewHolder(holder: StopViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount() = currentList.size

    class StopViewHolder(
        private val binding: ItemStopBinding,
        private val onRemoveItem: (Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(stop: Stop) {
            binding.apply {
                mainText.text = stop.text
                removeText.setOnClickListener {
                    onRemoveItem.invoke(adapterPosition)
                }
            }
        }

    }

}

object DiffUtilCallback : DiffUtil.ItemCallback<Stop>() {

    override fun areContentsTheSame(oldItem: Stop, newItem: Stop) =
        oldItem.text == newItem.text

    override fun areItemsTheSame(oldItem: Stop, newItem: Stop) = oldItem == newItem

}