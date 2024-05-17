package com.l0122095.ulhaq.responsippab01.ui.dashboard

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.l0122095.ulhaq.responsippab01.DetailFilmActivity
import com.l0122095.ulhaq.responsippab01.Film
import com.l0122095.ulhaq.responsippab01.ListFilmAdapter
import com.l0122095.ulhaq.responsippab01.R
import com.l0122095.ulhaq.responsippab01.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private lateinit var rvFilms: RecyclerView
    private val list = ArrayList<Film>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root


        rvFilms = binding.rvFilms
        rvFilms.setHasFixedSize(true)

        list.addAll(getListFilms())
        showRecyclerList()

        val myButton1 = binding.btnSwitchToGridLayout
        myButton1.setOnClickListener {
            toggleLayoutGrid()
        }

        val myButton2 = binding.btnSwitchToListLayout
        myButton2.setOnClickListener {
            toggleLayoutList()
        }

        return root
    }

    @SuppressLint("Recycle")
    private fun getListFilms() : ArrayList<Film> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataYear = resources.getStringArray(R.array.data_year)
        val dataImg = resources.obtainTypedArray(R.array.data_img)
        val dataDuration = resources.getStringArray(R.array.data_duration)
        val dataDesc = resources.getStringArray(R.array.data_description)
        val dataLink = resources.getStringArray(R.array.data_link)
        val listHero = ArrayList<Film>()
        for (i in dataName.indices) {
            val hero = Film(dataName[i], dataYear[i], dataImg.getResourceId(i, -1), dataDuration[i], dataDesc[i], dataLink[i])
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvFilms.layoutManager = LinearLayoutManager(requireContext())
        val listFilmAdapter = ListFilmAdapter(list)
        rvFilms.adapter = listFilmAdapter

        listFilmAdapter.setOnItemClickCallback(object : ListFilmAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Film) {
                showSelectedFilm(data)
            }

        })
    }

    private fun showSelectedFilm(film: Film) {
        val profileIntent = Intent(requireContext(), DetailFilmActivity::class.java)
        profileIntent.putExtra(DetailFilmActivity.EXTRA_FILMNAME, film.name)
        profileIntent.putExtra(DetailFilmActivity.EXTRA_FILMIMG, film.img)
        profileIntent.putExtra(DetailFilmActivity.EXTRA_FILMYEAR, film.year)
        profileIntent.putExtra(DetailFilmActivity.EXTRA_FILMDURATION, film.duration)
        profileIntent.putExtra(DetailFilmActivity.EXTRA_FILMDESC, film.desc)
        profileIntent.putExtra(DetailFilmActivity.EXTRA_FILMLINK, film.link)
        startActivity(profileIntent)
    }

    private fun toggleLayoutGrid() {
        rvFilms.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun toggleLayoutList() {
        rvFilms.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}