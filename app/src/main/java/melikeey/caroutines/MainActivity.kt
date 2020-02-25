package melikeey.caroutines

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var teamPagerAdapter: TeamPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      setTabs();
    }

    private fun setTabs() {

        tabLayout.addTab(tabLayout.newTab().setText(resources.getString(R.string.fb_name)))
        tabLayout.addTab(tabLayout.newTab().setText(resources.getString(R.string.gs_name)))
        tabLayout.addTab(tabLayout.newTab().setText(resources.getString(R.string.bjk_name)))

        teamPagerAdapter = TeamPagerAdapter(getTeamData(), supportFragmentManager)
        viewPager.adapter = teamPagerAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

    private fun getTeamData(): List<Team> {

        val teamList = arrayListOf<Team>()
        teamList.add(Team(resources.getString(R.string.fb_name),resources.getString(R.string.fb_code), resources.getString(R.string.fb_detail), resources.getString(R.string.fb_president),resources.getString(R.string.fb_image)))
        teamList.add(Team(resources.getString(R.string.gs_name), resources.getString(R.string.gs_code), resources.getString(R.string.gs_detail), resources.getString(R.string.gs_president),resources.getString(R.string.gs_image)))
        teamList.add(Team(resources.getString(R.string.bjk_name), resources.getString(R.string.bjk_code), resources.getString(R.string.bjk_detail), resources.getString(R.string.bjk_president),resources.getString(R.string.bjk_image)))

        return teamList
    }
}