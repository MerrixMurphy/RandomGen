package game.one.randomgen.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import game.one.randomgen.R
import java.util.concurrent.ThreadLocalRandom

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val maxval: TextView = root.findViewById(R.id.maxval)
        val minval: TextView = root.findViewById(R.id.minval)
        val results: TextView = root.findViewById(R.id.results)
        val random: Button = root.findViewById(R.id.random)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            random.setOnClickListener(){
                val x = minval.text.toString()
                val y = maxval.text.toString()
                if (x != "" && y != "") {
                    val min = Integer.parseInt(x)
                    val max = Integer.parseInt(y)
                    if (max >= min) {
                        val randomNum: Int = ThreadLocalRandom.current().nextInt(min, max + 1)
                        results.text = ("$randomNum")
                    }
                }
            }
        })
        return root
    }
}