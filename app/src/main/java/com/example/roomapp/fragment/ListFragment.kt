package com.example.roomapp.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomapp.R
import com.example.roomapp.adapter.ListAdapter
import com.example.roomapp.viewmodel.UserViewModel
import com.example.roomapp.databinding.FragmentListBinding
import com.example.roomapp.model.User
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.fragment_update.*


class ListFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        binding.rvList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ListAdapter()
        }

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            binding.rvList.adapter
        })

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {}
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _,_ ->
            mUserViewModel.deleteAllUser(user = User(id, firstName = toString(), lastName = toString(), age = Integer.parseInt(txt_age.text.toString())))
            Toast.makeText(requireContext(), "Successfully Removed Everything!", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { _,_ -> }
        builder.setTitle("Delete Everything?")
        builder.setMessage("Are Sure You Want To Delete Everything?")
        builder.create().show()
    }
}

