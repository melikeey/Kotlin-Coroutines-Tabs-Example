package melikeey.caroutines

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_team.*
import kotlinx.coroutines.*
import java.net.URL

class TeamFragment : Fragment() {

    companion object {

        const val KEY = "TEAM"

        fun newInstance(team : Team) : TeamFragment {
            val fragmentHome = TeamFragment()
            val args = Bundle()
            args.putParcelable(KEY, team)
            fragmentHome.arguments = args
            return fragmentHome
        }
    }

    private val parentJ = Job()

    private val exceptionHandler : CoroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        coroutineScope.launch(Dispatchers.Main) {
            errorM.visibility = View.VISIBLE
            errorM.text = "ERROR"
        }

        GlobalScope.launch { println("Caught $throwable") }
    }

    private val coroutineScope  =  CoroutineScope(Dispatchers.Main + parentJ + exceptionHandler)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val team = arguments?.getParcelable<Team>(KEY)
        val view = inflater.inflate(R.layout.fragment_team, container, false)
        view.findViewById<TextView>(R.id.tv_title).text = team?.title
        view.findViewById<TextView>(R.id.tv_subtitle).text = team?.subTitle
        view.findViewById<TextView>(R.id.tv_details).text =  team?.detail
        view.findViewById<TextView>(R.id.tv_president).text = team?.president

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val team = arguments?.getParcelable<Team>(KEY)
        coroutineScope.launch(Dispatchers.Main) {
            val originalBitmap = getOriginalBitmapAsync(team!!)

            loadImage (originalBitmap)
        }
    }

    private suspend fun getOriginalBitmapAsync(team: Team): Bitmap =
        withContext(Dispatchers.IO) {
            URL(team.url).openStream().use {
                return@withContext BitmapFactory.decodeStream(it)
            }
        }

    private fun loadImage(bitmap : Bitmap) {

        iv_image?.setImageBitmap(bitmap)
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
    }
}
