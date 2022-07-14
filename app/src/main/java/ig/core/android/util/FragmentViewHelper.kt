package ig.core.android.util

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ig.core.android.R
import ig.core.android.view.ui.activity.main.MainActivity

object FragmentViewHelper {
    private var oldView: Int = 0
    private var newView: Int = 0

    fun loadFragment(manager: FragmentManager, fragment: Fragment?, fragmentId: Int): Boolean {
        //switching fragment
        MainActivity.fragments.clear()
        MainActivity.fragments.push(fragment)

        val ft = manager.beginTransaction()
        if (newView > oldView) {
            ft.setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left)
        } else if (newView < oldView) {
            ft.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_right)
        }

        if (fragment != null) {
            ft
                .replace(fragmentId, fragment)
                .commitAllowingStateLoss()
            return true
        }
        return false
    }

    fun pushFragment(manager: FragmentManager, fragment: Fragment?, fragmentId: Int): Boolean {
        //switching fragment
        MainActivity.fragments.push(fragment)

        val ft = manager.beginTransaction()
        if (newView > oldView) {
            ft.setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left)
        } else if (newView < oldView) {
            ft.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_right)
        }

        if (fragment != null) {

            ft
                .replace(fragmentId, fragment)
                .commit()
            return true
        }
        return false
    }

    fun popFragment(manager: FragmentManager, fragmentId: Int) {
        if (MainActivity.fragments.size == 1)
            return
        Log.i("tt", "popFragment: " + MainActivity.fragments.size)
        MainActivity.fragments.pop()
        val last = MainActivity.fragments.lastElement()
        val ft = manager.beginTransaction()
        ft.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_right)
        ft.replace(fragmentId, last)
        ft.commit()
    }
}
