package com.example.goaltrack.core.tools

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.goaltrack.R
import com.example.goaltrack.core.data.League

class LeagueAdapter(
    private val leagues: List<League>,
    private val onItemClick: (League) -> Unit
) : RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_league, parent, false)
        return LeagueViewHolder(view)
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bind(leagues[position], onItemClick)
    }

    override fun getItemCount() = leagues.size

    class LeagueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val leagueName: TextView = itemView.findViewById(R.id.leagueName)
        private val countryName: TextView = itemView.findViewById(R.id.countryName)
        private val leagueLogo: ImageView = itemView.findViewById(R.id.leagueLogo) // Añadido ImageView

        fun bind(league: League, onItemClick: (League) -> Unit) = with(itemView) {
            leagueName.text = league.name
            countryName.text = league.country
            leagueLogo.setImageResource(R.drawable.ic_league_placeholder) // Establecer una imagen de marcador de posición

            // Usar Glide para cargar la imagen desde la URL de la liga
            Glide.with(itemView.context)
                .load(league.imageUrl) // La URL de la imagen
                .placeholder(R.drawable.ic_league_placeholder) // Imagen mientras se carga
                .error(R.drawable.ic_error) // Imagen en caso de error
                .into(leagueLogo) // Cargar la imagen en el ImageView

            setOnClickListener { onItemClick(league) }
        }
    }
}
