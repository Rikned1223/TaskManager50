package com.example.taskmanageer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.taskmanageer.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: TaskAdapter
    private val binding get() = _binding!!
    private lateinit var data : List<Task>
/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter(this::onLongClick,this::onCLick)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        setData()

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setData(){
        data = App.db.dao().getAll()
        adapter.addTasks(data)
    }

    private fun onCLick(task: Task){
        findNavController().navigate(R.id.taskFragment, bundleOf(KEY_FOR_TASK to task))
    }

    private fun onLongClick(position: Int){
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Вы уверенны что хотите удалить?")
        builder.setMessage("Если вы удалите данную строку его нельзя будет восстановить!")
        builder.setPositiveButton("Да") { dialogInterface: DialogInterface, i: Int ->
            App.db.dao().delete(data[position])
            setData()
        }
        builder.setNegativeButton("Нет") { dialogInterface: DialogInterface, i: Int ->
        }
        builder.show()
    }

    companion object{
        const val KEY_FOR_TASK = "task"
    }

}