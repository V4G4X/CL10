package com.varun.login.view.fragment.list

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.varun.login.ADMIN_LOGGED_IN
import com.varun.login.MainActivity
import com.varun.login.R
import com.varun.login.view.activity.registration.FormFirst
import com.varun.login.viewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        // RecyclerView
        val adapter = UserListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.getAll.observe(viewLifecycleOwner , { user ->
            adapter.setData(user)
        })

        // Set Up Delete Menu
        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.admin_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId === R.id.admin_delete){
            deleteAllUsers()
        }
        else if(item.itemId === R.id.admin_logout){
            moveToMainActivity()
        }
        else if(item.itemId === R.id.admin_add){
            addUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){ _,_ ->
            Toast.makeText(requireContext(), "Register Personal Details", Toast.LENGTH_SHORT).show()
            val intent = Intent(activity, FormFirst::class.java).apply {
                putExtra(ADMIN_LOGGED_IN, "logged in")
            }
            startActivity(intent)
        }
        builder.setNegativeButton("No"){ _,_ -> }
        builder.setTitle("Register a new User?")
        builder.create().show()
    }

    private fun moveToMainActivity() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){ _,_ ->
            Toast.makeText(requireContext(), "Logged Out", Toast.LENGTH_SHORT).show()
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
        builder.setNegativeButton("No") { _,_ -> }
        builder.setTitle("Log Out?")
        builder.create().show()
    }

    private fun deleteAllUsers() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){ _,_ ->
            mUserViewModel.deleteAllUsers()
            Toast.makeText(requireContext(), "All Users deleted", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { _,_ -> }
        builder.setTitle("Delete All Users?")
        builder.setMessage("Are you sure you want to delete all User Data?")
        builder.create().show()
    }
}