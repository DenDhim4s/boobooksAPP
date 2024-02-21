import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.e_library.R
import com.example.e_library.fragment.PopUpBookFragment


class HomeFragment : Fragment() {

    lateinit var btnBottomSheet: Button
    lateinit var PopUpBookFragment: PopUpBookFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBottomSheet = view.findViewById(R.id.btnBottomSheet)
        btnBottomSheet.setOnClickListener {
            PopUpBookFragment = PopUpBookFragment()
            PopUpBookFragment.show(requireActivity().supportFragmentManager, "BSDialogFragment")
        }
    }
}