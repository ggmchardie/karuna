package com.team9.karunaapp.ui.browse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.team9.karunaapp.databinding.FragmentBrowseBinding;

public class BrowseFragment extends Fragment {
    private FragmentBrowseBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentBrowseBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

}