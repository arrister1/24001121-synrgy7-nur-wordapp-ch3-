package com.example.wordsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root


    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.list_view -> {
//                binding.rvMain.layoutManager = LinearLayoutManager(activity)
//            }
//            R.id.grid_view -> {
//                binding.rvMain.layoutManager = GridLayoutManager(activity, 2)
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //data dibawah bisa langsung pake listOf("A", dst)
        //tp di adapternya kudu diganti list<String>, bukan pake <Words>

        val adapter = WordsAdapter{
            val bundle = Bundle()
            bundle.putString("PARAMS", it)
            findNavController().navigate(R.id.detailFragment, bundle )
        }
        adapter.submitData(alphabetsData)

        //hubungin rv dg adapter
        binding.rvMain.adapter = adapter
        binding.rvMain.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.mainToolbar.topAppBar.setNavigationIcon(null)
        binding.mainToolbar.topAppBar.setOnMenuItemClickListener{
            when(it.itemId){
                R.id.grid_view -> {
                    binding.rvMain.layoutManager=GridLayoutManager(activity, 2)
                }
                R.id.list_view -> {
                    binding.rvMain.layoutManager = LinearLayoutManager(activity)
                }
            }
            false
        }

    }

}