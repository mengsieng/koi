package ig.core.android.view.bottomsheet

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ig.core.android.R
import kotlinx.android.synthetic.main.bottom_sheet_feedback.*
import org.jetbrains.anko.startActivity

class FeedbackBottomSheet: BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return inflater.inflate(R.layout.bottom_sheet_feedback, container, false)
    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        byGoogle.setOnClickListener {
//            requireActivity().startActivity<FeedbackActivity>()
        }
        byTelegram.setOnClickListener {
            val groupTelegram = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/KOITheKHApp"))
            startActivity(groupTelegram)
        }
        btnNo.setOnClickListener {
            dismiss()
        }
    }

}