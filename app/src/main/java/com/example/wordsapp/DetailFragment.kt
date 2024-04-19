package com.example.wordsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.databinding.FragmentDetailBinding
import com.example.wordsapp.databinding.FragmentMainBinding


class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)

        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val params = arguments?.getString("PARAMS")
        var wordList = arrayListOf<String>()
        when(params) {
            Wordlist.A.char -> {
                wordList = Wordlist.A.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.A}"

            }
            Wordlist.B.char -> {wordList = Wordlist.B.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.B}"
            }
            Wordlist.C.char -> {wordList = Wordlist.C.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.C}"
            }
            Wordlist.D.char -> {wordList = Wordlist.D.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.D}"
            }
            Wordlist.E.char -> {wordList = Wordlist.E.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.E}"
            }
            Wordlist.F.char -> {wordList = Wordlist.F.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.F}"
            }
            Wordlist.G.char -> {wordList = Wordlist.G.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.G}"
            }
            Wordlist.H.char -> {wordList = Wordlist.H.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.H}"
            }
            Wordlist.I.char -> {wordList = Wordlist.I.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.I}"
            }
            Wordlist.J.char -> {wordList = Wordlist.J.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.J}"
            }
            Wordlist.K.char -> {wordList = Wordlist.K.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.K}"
            }
            Wordlist.L.char -> {wordList = Wordlist.L.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.L}"
            }
            Wordlist.M.char -> {wordList = Wordlist.M.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.M}"
            }
            Wordlist.N.char -> {wordList = Wordlist.N.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.N}"
            }
            Wordlist.O.char -> {wordList = Wordlist.O.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.O}"
            }
            Wordlist.P.char -> {wordList = Wordlist.P.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.P}"
            }
            Wordlist.Q.char -> {wordList = Wordlist.Q.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.Q}"
            }
            Wordlist.R.char -> {wordList = Wordlist.R.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.R}"
            }
            Wordlist.S.char -> {wordList = Wordlist.S.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.S}"
            }
            Wordlist.T.char -> {wordList = Wordlist.T.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.T}"
            }
            Wordlist.U.char -> {wordList = Wordlist.U.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.U}"
            }
            Wordlist.V.char -> {wordList = Wordlist.V.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.V}"
            }
            Wordlist.W.char -> {wordList = Wordlist.W.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.W}"
            }
            Wordlist.X.char -> {wordList = Wordlist.X.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.X}"
            }
            Wordlist.Y.char -> {wordList = Wordlist.Y.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.Y}"
            }
            Wordlist.Z.char -> {wordList = Wordlist.Z.words
                binding.mainToolbar.topAppBar.title = "Words That Start With ${Wordlist.Z}"
            }

        }

        val adapter = WordsAdapter {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData((Uri.parse("https://www.google.com/search?q={it}")) )
            activity?.startActivity(intent)

        }
        adapter.submitData(wordList)
        binding.rvDetail.adapter =adapter
        binding.rvDetail.layoutManager = LinearLayoutManager(activity)
        binding.mainToolbar.topAppBar.setOnMenuItemClickListener{
            when(it.itemId){
                R.id.grid_view -> {
                    binding.rvDetail.layoutManager= GridLayoutManager(activity, 2)
                }
                R.id.list_view -> {
                    binding.rvDetail.layoutManager = LinearLayoutManager(activity)
                }
            }
            false
        }
    }

}