package com.example.goaltrack.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.goaltrack.R
import com.example.goaltrack.core.data.League

class LeagueDetailsFragment : Fragment() {

    private lateinit var leagueNameTextView: TextView
    private lateinit var leagueCountryTextView: TextView
    private lateinit var leagueLogoImageView: ImageView
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button

    private var leagueList: List<League> = listOf()
    private var currentIndex: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_league_details, container, false)

        // Inicializa las vistas
        leagueNameTextView = view.findViewById(R.id.tvLeagueName)
        leagueCountryTextView = view.findViewById(R.id.tvLeagueCountry)
        leagueLogoImageView = view.findViewById(R.id.ivLeagueLogo)
        previousButton = view.findViewById(R.id.previousButton)
        nextButton = view.findViewById(R.id.nextButton)

        // Obtén los datos del argumento (Bundle)
        arguments?.let { bundle ->
            leagueList = bundle.getParcelableArrayList("leagueList") ?: listOf()
            currentIndex = bundle.getInt("currentIndex", 0)
        }

        // Muestra los datos iniciales
        updateLeagueDetails()

        // Configurar botones de navegación
        previousButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                updateLeagueDetails()
            }
        }

        nextButton.setOnClickListener {
            if (currentIndex < leagueList.size - 1) {
                currentIndex++
                updateLeagueDetails()
            }
        }

        return view
    }

    private fun updateLeagueDetails() {
        val league = leagueList[currentIndex]
        leagueNameTextView.text = league.name
        leagueCountryTextView.text = league.country
        Glide.with(this)
            .load(league.imageUrl)
            .into(leagueLogoImageView)

        // Habilitar/deshabilitar botones según el índice actual
        previousButton.isEnabled = currentIndex > 0
        nextButton.isEnabled = currentIndex < leagueList.size - 1
    }
}
