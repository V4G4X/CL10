package com.varun.login.view.fragment.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.varun.login.R
import com.varun.login.model.User
import com.varun.login.viewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.updateFirstName_et.setText(args.currentUser.firstName)
        view.updateLastName_et.setText(args.currentUser.lastName)
        view.updateEmailAddress_et.setText(args.currentUser.email)
        view.updatePhone_et.setText(args.currentUser.phone)
        view.updateDegree_et.setText(args.currentUser.degree)
        view.updateCollege_et.setText(args.currentUser.college)
        view.updateGradYear_et.setText(args.currentUser.gradYear.toString())
        view.updateBranch_et.setText(args.currentUser.branch)

        view.updateButton.setOnClickListener{
            updateItem()
        }

        // Add Menu
        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem(){
        fun personalInputCheck(firstName: String, lastName: String, emailAddress: String, phone: String): Boolean{
            return !(TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(emailAddress) || TextUtils.isEmpty(phone))
        }

        fun professionalInputCheck(degree: String, college: String, gradYear: Editable, branch: String): Boolean {
            return !(TextUtils.isEmpty(degree) || TextUtils.isEmpty(college) || gradYear.isEmpty() || TextUtils.isEmpty(branch))
        }

        val firstName = updateFirstName_et.text.toString()
        val lastName = updateLastName_et.text.toString()
        val email = updateEmailAddress_et.text.toString()
        val phone = updatePhone_et.text.toString()
        val degree = updateDegree_et.text.toString()
        val college = updateCollege_et.text.toString()
        val gradYear = Integer.parseInt(updateGradYear_et.text.toString())
        val branch = updateBranch_et.text.toString()

        if( personalInputCheck(firstName, lastName, email, phone) && professionalInputCheck(degree, college, updateGradYear_et.text, branch) ){
            // Create Updated User
            val updatedUser = User(args.currentUser.uid, firstName, lastName, phone, email, degree, college, gradYear, branch)
            // Update the User in Database
            mUserViewModel.updateUser(updatedUser)
            //Display Success Toast
            Toast.makeText(requireContext(), "Successfully Updated User Details", Toast.LENGTH_SHORT).show()
            //Navigate Back to List
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        else Toast.makeText(requireContext(), "Leave No Field Empty", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){ _,_ ->
            mUserViewModel.deleteUser(args.currentUser)
            Toast.makeText(requireContext(), "${args.currentUser.firstName} deleted", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No") { _,_ -> }
        builder.setTitle("Delete ${args.currentUser.firstName}?")
        builder.setMessage("Are you sure you want to delete ${args.currentUser.firstName}?")
        builder.create().show()
    }
}