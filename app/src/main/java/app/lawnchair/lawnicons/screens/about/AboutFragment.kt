package app.lawnchair.lawnicons.screens.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import app.lawnchair.lawnicons.Data
import app.lawnchair.lawnicons.databinding.AboutFragmentBinding
import com.google.android.material.transition.MaterialSharedAxis

class AboutFragment : Fragment() {

    private lateinit var binding: AboutFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)
        exitTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AboutFragmentBinding.inflate(inflater, container, false)

        val contributorRecView = binding.conRecView
        val adapter = ContributorsRecViewAdapter(context)
        adapter.setContributors(Data.getContributors())
        contributorRecView.adapter = adapter
        contributorRecView.layoutManager =
            LinearLayoutManager(context)

        return binding.root
    }

}