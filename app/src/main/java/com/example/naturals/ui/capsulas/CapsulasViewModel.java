package com.example.naturals.ui.capsulas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CapsulasViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CapsulasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Produtos disponíveis");
    }

    public LiveData<String> getText() {
        return mText;
    }
}