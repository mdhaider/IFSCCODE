package com.nehal.ifsccode.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nehal.ifsccode.R
import com.nehal.ifsccode.model.IfscResponse
import com.nehal.ifsccode.repository.PostRepository
import com.nehal.ifsccode.viewModel.PostViewModel
import com.nehal.ifsccode.viewModel.PostViewModelFactory
import kotlinx.android.synthetic.main.fragment_1.view.*


class Fragment1 : Fragment() {

    private lateinit var postViewModel: PostViewModel
    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_1, container, false)
        initUi()
        return root
    }

    private fun initUi() {
        setVisibility(false)
        val postViewModelFactory = PostViewModelFactory(PostRepository())
        postViewModel = ViewModelProvider(this, postViewModelFactory)[PostViewModel::class.java]

        root.et_ifsc.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                val length: Int = root.et_ifsc.length()
                if (length == 11) {
                    callApi(root.et_ifsc.text.toString())
                }
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {}
        })
    }

    private fun setVisibility(visibility: Boolean) {
        if (visibility) {
            root.llBankName.visibility = View.VISIBLE
            root.llIfsc.visibility = View.VISIBLE
            root.llMICR.visibility = View.VISIBLE
            root.llState.visibility = View.VISIBLE
            root.llDistrict.visibility = View.VISIBLE
            root.llBranch.visibility = View.VISIBLE
            root.llContact.visibility = View.VISIBLE
            root.llAddress.visibility = View.VISIBLE
        } else {
            root.llBankName.visibility = View.GONE
            root.llIfsc.visibility = View.GONE
            root.llMICR.visibility = View.GONE
            root.llState.visibility = View.GONE
            root.llDistrict.visibility = View.GONE
            root.llBranch.visibility = View.GONE
            root.llContact.visibility = View.GONE
            root.llAddress.visibility = View.GONE
        }
    }

    private fun callApi(ifsc: String) {
        postViewModel.getPost(ifsc)
        postViewModel.postData.observe(requireActivity(), Observer {
            setVisibility(true)
            setValues(it)
        })
    }

    private fun setValues(data: IfscResponse) {
        root.tvBankName.text = data.bANK ?: "NA"
        root.tvIfscCode.text = data.iFSC ?: "NA"
        root.tvMicrCode.text = data.mICR ?: "NA"
        root.tvState.text = data.sTATE ?: "NA"
        root.tvDistrict.text = data.dISTRICT ?: "NA"
        root.tvBranch.text = data.bRANCH ?: "NA"
        root.tvContact.text = data.cONTACT ?: "NA"
        root.tvAddress.text = data.aDDRESS ?: "NA"
    }
}
