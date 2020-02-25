package melikeey.caroutines

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TeamPagerAdapter(private val teamList: List<Team> , fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return teamList.size
    }

    override fun getItem(position: Int): Fragment {

        return TeamFragment.newInstance(teamList[position])
    }
}