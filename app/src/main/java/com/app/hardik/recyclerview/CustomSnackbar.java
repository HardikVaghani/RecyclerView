package com.app.hardik.recyclerview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import android.widget.Toast;

public class CustomSnackbar extends BaseTransientBottomBar<CustomSnackbar> {

    protected CustomSnackbar(View parent, View content, com.google.android.material.snackbar.ContentViewCallback contentViewCallback) {
        super((ViewGroup) parent, content, contentViewCallback);
    }

    public static CustomSnackbar make(View view, String message, int duration) {
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View content = inflater.inflate(R.layout.custom_snackbar, null);
        CustomSnackbar customSnackbar = new CustomSnackbar(view, content, new ContentViewCallback(content));
        ((TextView) content.findViewById(R.id.custom_snackbar_text)).setText(message);
        customSnackbar.setDuration(duration);
        return customSnackbar;
    }

    private static class ContentViewCallback implements com.google.android.material.snackbar.ContentViewCallback {
        private final View content;

        private ContentViewCallback(View content) {
            this.content = content;
        }

        @Override
        public void animateContentIn(int delay, int duration) {
            // You can perform any custom animations for content appearing here if needed.
        }

        @Override
        public void animateContentOut(int delay, int duration) {
            // You can perform any custom animations for content disappearing here if needed.
        }
    }
}