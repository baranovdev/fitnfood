package by.baranovdev.fitnfood.activities.ui.home.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.baranovdev.fitnfood.database.entity.Program
import by.baranovdev.fitnfood.databinding.ItemProgramBinding

class ProgramAdapter(val programs : MutableList<Program>) : RecyclerView.Adapter<ProgramAdapter.ProgramViewHolder>(){

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(list: List<Program>) {
        programs.clear()
        programs.addAll(list)
        notifyDataSetChanged()
    }

    inner class ProgramViewHolder(val binding: ItemProgramBinding):RecyclerView.ViewHolder(binding.root){
        fun setData(itemView : View, position:Int){
            val program = programs[position]
            binding.programName.text = program.name
            binding.programDescription.text = program.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder {
        val itemBinding = ItemProgramBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProgramViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ProgramViewHolder, position: Int) {
        holder.setData(holder.binding.root, position)
    }

    override fun getItemCount(): Int {
        return programs.size
    }

}