package com.woman_calendar.utils;
import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;



/**
 *
 * Simple TextView that changes the text size so that the text size can grow smaller as the
 * text itself grows longer.
 *
 * Super dumb implementation, only meant to be used for the score display.  Makes a lot of assumptions
 * about there only being one line, all digits, all monospace, etc.
 *
 * @author nolan
 *
 */
public class AutoResizeTextView extends TextView {



    // don't make it any smaller than this, no matter what
    private static final float MIN_TEXT_SIZE = 12.0F;

    private float maxTextSize;

    public AutoResizeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        maxTextSize = getTextSize();
    }

    public AutoResizeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        maxTextSize = getTextSize();
    }

    public AutoResizeTextView(Context context) {
        super(context);
        maxTextSize = getTextSize();
    }

    /**
     * Set the maximum allowable text size for this textview.
     */
    public void setMaxTextSize(int pixels) {
        maxTextSize = pixels;
    }

    @Override
    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld) {
        super.onSizeChanged(xNew, yNew, xOld, yOld);

        resizeText();
    }


    /**
     * Resize the text in a text view so that it fits and doesn't need to be
     * ellipsized.
     *
     * Gets smaller, but doesn't get larger again.
     *
     */
    public void resizeText() {

        TextPaint textPaint = getPaint();
        String text = getText().toString();

        textPaint.setTextSize(maxTextSize);

        float oldTextSize = maxTextSize;

        int widthLimit = getMeasuredWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight();

        if (widthLimit <= 0) {
            // this happens if the view hasn't been measured yet
            return;
        }

        float actualTextWidth = textPaint.measureText(text);

        float newTextSize = oldTextSize;



        // keep trying smaller size until we find one that fits
        while (newTextSize > MIN_TEXT_SIZE && actualTextWidth > widthLimit) {
            newTextSize -= 2;
            textPaint.setTextSize(newTextSize);
            actualTextWidth = textPaint.measureText(text);
        }



        setTextSize(TypedValue.COMPLEX_UNIT_PX, Math.round(newTextSize));
    }
}