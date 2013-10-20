package ru.alexmikh.summary;

import android.content.Context;
import android.inputmethodservice.Keyboard;

public class SpecialKeyboard  extends Keyboard{

    public SpecialKeyboard(Context context, int xmlLayoutResId) {
        super(context, xmlLayoutResId);
    }
}
