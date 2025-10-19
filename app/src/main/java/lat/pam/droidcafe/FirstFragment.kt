// Pastikan file FirstFragment.kt Anda terlihat seperti ini
package lat.pam.droidcafe



import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import lat.pam.droidcafe.databinding.FragmentFirstBinding
import lat.pam.droidcafe.OrderActivity


import lat.pam.droidcafe.R

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Listener untuk gambar-gambar
        binding.donut.setOnClickListener {
            // Gunakan requireContext() untuk mengakses resources
            displayToast(requireContext().getString(R.string.donuts))
        }
        binding.iceCream.setOnClickListener {
            // Gunakan requireContext() untuk mengakses resources
            displayToast(requireContext().getString(R.string.ice_cream_sandwiches))
        }
        binding.froyo.setOnClickListener {
            // Gunakan requireContext() untuk mengakses resources
            displayToast(requireContext().getString(R.string.froyo))
        }

        // Listener untuk Floating Action Button
        binding.fab.setOnClickListener {
            val intent = Intent(activity, OrderActivity::class.java)
            startActivity(intent)
        }
    }

    private fun displayToast(message: String) {
        // Gunakan context yang tersedia (dari requireContext())
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
