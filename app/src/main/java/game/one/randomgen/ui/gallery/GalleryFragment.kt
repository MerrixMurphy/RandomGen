package game.one.randomgen.ui.gallery

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
import java.util.concurrent.ThreadLocalRandom

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val firstval: EditText = root.findViewById(R.id.firstval)
        val lastval: EditText = root.findViewById(R.id.lastval)
        val results2: TextView = root.findViewById(R.id.results2)
        val random2: Button = root.findViewById(R.id.random2)
        val letterlist:ArrayList<String> = arrayListOf("A","B","C","D","E","F","G","H","I","J","K",
            "L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")

        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
        })
        random2.setOnClickListener() {
            val x = firstval.text.toString()
            val y = lastval.text.toString()
            if (x != "" && y != "") {
                val firstposition = letterlist.indexOf(x)
                val lastposition = letterlist.indexOf(y)
                if (lastposition >= firstposition) {
                    val randomNum: Int = ThreadLocalRandom.current().nextInt(firstposition, lastposition + 1)
                    val letter = letterlist[randomNum]
                    results2.text = (letter)
                }
            }
        }

        return root
    }
}