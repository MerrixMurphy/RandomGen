package game.one.randomgen.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import game.one.randomgen.R

class SlideshowFragment : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        val list: EditText = root.findViewById(R.id.list)
        val results3: TextView = root.findViewById(R.id.results3)
        val listof:ArrayList<String> = arrayListOf()
        val values: TextView = root.findViewById(R.id.listofvalues)
        val randomthree: Button = root.findViewById(R.id.random3)
        val add: Button = root.findViewById(R.id.add)
        val clearlist: Button = root.findViewById(R.id.clearlist)
        val x = ""

        randomthree.setOnClickListener(){
            if(listof.isNotEmpty()) {
                val randomNum = listof.random()
                results3.text = (randomNum)
            }
        }

        add.setOnClickListener(){
            val tryit = list.text
            listof.add(tryit.toString())
            list.text.clear()
            values.text = listof.toString()
        }

        clearlist.setOnClickListener(){
            listof.clear()
            list.text.clear()
            results3.text = x
            values.text = listof.toString()

        }

        slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
        })
        return root
    }
}