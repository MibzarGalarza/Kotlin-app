package com.example.goaltrack.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.goaltrack.core.tools.LeagueAdapter
import com.example.goaltrack.R
import com.example.goaltrack.core.data.League

class LeaguesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var leagueAdapter: LeagueAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_leagues, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewLeagues)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Lista de ligas de ejemplo
        val leagues = listOf(
            League("La Liga", "España", "https://assets.laliga.com/assets/logos/LL_RGB_h_color/LL_RGB_h_color.png"),
            League("Premier League", "Inglaterra", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS6Y3JwQaZzyvV9mAlnraLasCGXEn-TVXPAjA&s"),
            League("Serie A", "Italia", "https://a4.espncdn.com/combiner/i?img=%2Fi%2Fleaguelogos%2Fsoccer%2F500%2F12.png"),
            League("Bundesliga", "Alemania", "https://upload.wikimedia.org/wikipedia/en/thumb/d/df/Bundesliga_logo_%282017%29.svg/1200px-Bundesliga_logo_%282017%29.svg.png"),
            League("Ligue 1", "Francia", "https://static.wikia.nocookie.net/universecwsports/images/1/12/Ligue1_Logo.png/revision/latest?cb=20201126145431&path-prefix=es"),
            League("Primeira Liga", "Portugal", "https://www.tiendadeljugador.com/cdn/shop/collections/Portuguese-Primeira-Liga-logo-1.jpg?v=1720116404"),
            League("Eredivisie", "Países Bajos", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/Eredivisie_nieuw_logo_2017-.svg/800px-Eredivisie_nieuw_logo_2017-.svg.png"),
            League("Liga MX", "México", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f8/MX_logo.png/640px-MX_logo.png")
        )

        // Configurar el adaptador
        leagueAdapter = LeagueAdapter(leagues) { league ->
            // Navegar a los detalles de la liga seleccionada con la lista completa y el índice
            val bundle = Bundle().apply {
                putParcelableArrayList("leagueList", ArrayList(leagues)) // Pasar la lista completa
                putInt("currentIndex", leagues.indexOf(league)) // Pasar el índice actual
            }

            val leagueDetailsFragment = LeagueDetailsFragment().apply {
                arguments = bundle
            }

            // Realizar la transacción para navegar al fragmento de detalles
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, leagueDetailsFragment) // Cambiar el contenedor de fragmentos
                .addToBackStack(null) // Permite volver al fragmento anterior
                .commit()
        }

        recyclerView.adapter = leagueAdapter
        return view
    }

}
