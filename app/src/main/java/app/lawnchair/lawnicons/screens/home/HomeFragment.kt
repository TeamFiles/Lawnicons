package app.lawnchair.lawnicons.screens.home

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import app.lawnchair.lawnicons.Data
import app.lawnchair.lawnicons.R
import app.lawnchair.lawnicons.databinding.HomeFragmentBinding
import com.google.android.material.transition.MaterialSharedAxis

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
        exitTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)

        val iconsRecView = binding.latestIconsRecView
        val adapter = LatestIconsViewAdapter(context)

        binding.homeIconMR.setOnLongClickListener {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://telegram.me/fileschat"))
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context, R.string.install_browser, Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
            true
        }

        adapter.setIcons(Data.getLatestIcons())
        iconsRecView.adapter = adapter
        iconsRecView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        return binding.root
    }

}