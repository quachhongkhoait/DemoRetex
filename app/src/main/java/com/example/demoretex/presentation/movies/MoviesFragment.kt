package com.example.demoretex.presentation.movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.demoretex.R
import com.example.demoretex.databinding.FragmentMoviesBinding
import com.example.demoretex.presentation.movies.adapter.MovieAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding
    private val viewModel by viewModel<MoviesViewModel>()
    private val adapter: MovieAdapter by lazy {
        MovieAdapter {
            findNavController().navigate(
                MoviesFragmentDirections.actionMoviesFragmentToMovieDetailFragment(it)
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBindingVariables()
        initViews()
        initData()
        observes()
    }

    private fun initViews() {
        binding.rvMovie.adapter = adapter
    }

    private fun setupBindingVariables() {
        binding.lifecycleOwner = viewLifecycleOwner
    }

    private fun initData() {
        viewModel.getMovies()
    }

    private fun observes() {
        with(viewModel) {
            movies.observe(viewLifecycleOwner) {
                adapter.submitList(it)
                loading.value = false
            }
            error.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                loading.value = false
            }
            loading.observe(viewLifecycleOwner) {
                binding.pbLoading.isVisible = it
            }
        }
    }
}