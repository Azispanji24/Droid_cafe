package lat.pam.droidcafe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import lat.pam.droidcafe.FirstFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cek jika savedInstanceState null.
        // Ini penting agar Fragment tidak ditambahkan berulang kali
        // saat terjadi perubahan konfigurasi (seperti rotasi layar).
        if (savedInstanceState == null) {
            // 1. Buat instance dari FirstFragment
            val firstFragment = FirstFragment()

            // 2. Gunakan FragmentManager untuk memulai transaksi
            supportFragmentManager.beginTransaction()
                // 3. Ganti (replace) isi dari FrameLayout dengan Fragment
                .replace(R.id.fragment_container, firstFragment)
                // 4. Lakukan transaksi
                .commit()
        }
    }
}
