package com.kevicsalazar.dagger.presentation.main


import com.kevicsalazar.dagger.R
import com.kevicsalazar.dagger.presentation.PerActivity
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@PerActivity
class MainPresenter @Inject constructor(val view: View) {

    var idSelected = -1

    fun prepareToShow(itemId: Int): Boolean {
        if (idSelected != itemId) {
            when (itemId) {
                R.id.action_page_1 -> {
                    view.showFragmentView("1")
                    view.setupColor(R.drawable.bg_tab_1)
                    view.startColorTransition(R.color.page_1)
                }
                R.id.action_page_2 -> {
                    view.showFragmentView("2")
                    view.setupColor(R.drawable.bg_tab_2)
                    view.startColorTransition(R.color.page_2)
                }
                R.id.action_page_3 -> {
                    view.showFragmentView("3")
                    view.setupColor(R.drawable.bg_tab_3)
                    view.startColorTransition(R.color.page_3)
                }
            }
            idSelected = itemId
        }
        return true
    }

    interface View {

        fun showFragmentView(type: String)

        fun setupColor(drawableResId: Int)

        fun startColorTransition(colorResId: Int)

    }

}