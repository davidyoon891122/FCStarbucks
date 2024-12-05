package com.example.fcstarbucks

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.fcstarbucks.databinding.FragmentHomeBinding

class HomeFragment: Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        val homeData = context?.readData() ?: return
        Log.e("HomeFragment", homeData.appbarImage)
        binding.appBarTitleTextView.text = getString(R.string.appbar_title_text, homeData.user.nickname)
        binding.starCountTextView.text = getString(R.string.appbar_star_title, homeData.user.starCount, homeData.user.totalCount)

        binding.appBarProgressBar.max = homeData.user.totalCount
        binding.appBarProgressBar.progress = homeData.user.starCount

        Glide.with(binding.appBarImageView)
            .load(homeData.appbarImage)
            .into(binding.appBarImageView)



        binding.recommendMenuList.menuLayout.addView(
            MenuView(requireContext()).apply {
                setTitle("아이스 카페 라떼")
                setImageUrl("https://picsum.photos/200/100")
            }
        )
    }

}