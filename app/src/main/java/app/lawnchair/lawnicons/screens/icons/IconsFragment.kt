package app.lawnchair.lawnicons.screens.icons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import app.lawnchair.lawnicons.databinding.IconsFragmentBinding
import com.google.android.material.transition.MaterialSharedAxis

class IconsFragment : Fragment() {

    private lateinit var binding: IconsFragmentBinding

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
        binding = IconsFragmentBinding.inflate(inflater, container, false)

        val iconsRecView = binding.iconsRecView
        val adapter = AllIconsViewAdapter(context)

        adapter.setIcons(GetIconInfo.getAllIcons())
        iconsRecView.adapter = adapter
        iconsRecView.layoutManager =
            GridLayoutManager(context, AllIconsViewAdapter.getColumns(context))

        return binding.root
    }
}