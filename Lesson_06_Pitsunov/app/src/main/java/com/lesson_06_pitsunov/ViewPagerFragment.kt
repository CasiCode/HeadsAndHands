package com.lesson_06_pitsunov

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.lesson_06_pitsunov.com.lesson_06_pitsunov.ViewPagerAdapter
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator


class ViewPagerFragment : Fragment() {
    private val fragmentList: MutableList<Fragment> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentList.add(ImageFragment.newInstance("https://i.pinimg.com/originals/d6/0d/d5/d60dd57a8b899086004bbeec26b5838e.jpg"))
        fragmentList.add(ImageFragment.newInstance("https://ihavecat.com/wp-content/uploads/2014/01/cat-asking-for-help-option-2.jpg"))
        fragmentList.add(ImageFragment.newInstance("https://ihavecat.com/wp-content/uploads/2014/01/cat-asking-for-help-2.jpg"))

        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(fragmentList, parentFragmentManager, lifecycle)
        view.findViewById<DotsIndicator>(R.id.dotsIndicator).attachTo(viewPager)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ViewPagerFragment()
    }
}