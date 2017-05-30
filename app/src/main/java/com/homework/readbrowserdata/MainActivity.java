package com.homework.readbrowserdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Browser;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    public TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = (TextView) findViewById(R.id.output);

    }

    public void onClick(View v) {
        Cursor mCursor = getContentResolver().query(Browser.BOOKMARKS_URI,
                null, null, null, null);

        if (mCursor.moveToFirst()) {
            String url;
            int urlColumn = mCursor.getColumnIndex(Browser.BookmarkColumns.URL);
            do {
                url = mCursor.getString(urlColumn);
                message.append("\n" + url);
            } while (mCursor.moveToNext());

        }
    }
}
