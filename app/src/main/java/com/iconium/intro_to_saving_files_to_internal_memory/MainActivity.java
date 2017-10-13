package com.iconium.intro_to_saving_files_to_internal_memory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String temp = "";

    // Name of file to be created it can be anything you
    // like e.g mylist, newfile, etc
    private String FILE = "text_file";


    // Globally scoped Button from main activity xml file
    private Button create_text_file_button;

    // Globally scoped EditTextview from main activity xml file
    private EditText text_box;


    // Succes message
    private String SUCCESS_MSG = "Text File was saved into internal memory";

    // Error Message
    private String INTERNAL_STORAGE_ERROR = "Text File could not be created";

    // Globally scoped string
    private String EditViewContents = "";

    // Name of preference
    private String EditViewContentPreferenceKey = "EditViewContentKey";
    // Unique preference key
    private String PREF = "EditViewPreference";

    // Unique key used to save data on the onSavedInstanceState method
    private String EDIT_VIEW_KEY = "onSavedInstanceKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);




        /*
         * Get references of the layout view from main activity's
         * XML file.
         * */
        create_text_file_button = (Button) findViewById(R.id.create_text_file);
        text_box = (EditText) findViewById(R.id.text_box);


//
//         SharedPreferences settings = getSharedPreferences(PREF, 0);
//         String retrievedText = settings.getString(EditViewContentPreferenceKey,"Got Nothing");
//
//        // update EditView with data from SharedPreferences
//         updateEditView(retrievedText);




        /**
        * Attach an event listener to the {@link #create_text_file_button}
        * */
//        create_text_file_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                // Retrieve string value from the EditText View element
//                EditViewContents = (String) create_text_file_button
//                                                    .getText()
//                                                    .toString();
//
//                try {
//                    // create simple text file;
//                    FileOutputStream fos = openFileOutput(FILE, Context.MODE_PRIVATE);
//                    fos.write(EditViewContents.getBytes());
//                    fos.close();
//
//                    // clear EditView
//                    updateEditView("");
//
//                    // Give success feedback
//                    feedback(SUCCESS_MSG);
//
//                }catch (IOException e){
//                    // Give error feedback
//                    feedback(INTERNAL_STORAGE_ERROR);
//                    Log.d("","Could not create File ");
//                }
//            }
//        });


    }

    /**
     * {@link #feedback(String)} gives feedback of action
     * performed by the user i.e notify the user if file was created or not
     * after clicking the  {@link #create_text_file_button}.
     * */
    public void feedback(String feedBackmessage){
        Toast toast = Toast.makeText(getApplicationContext(),feedBackmessage , Toast.LENGTH_LONG);
        toast.show();
    }

    /**
     * Retrieves value from SharedPreferences
     * */
    public void setEditViewContent(String inputText) {
        EditViewContents = inputText;
    }

    /**
     * Updates  {@link #text_box} with new string
     */
    public void updateEditView(String textValue){
        text_box.setText(textValue);
    }

    @Override
    protected void onStop(){
        super.onStop();



//        SharedPreferences preferences = getSharedPreferences(PREF, 0);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putString(EditViewContentPreferenceKey, EditViewContents);
//
//        // Commit modifications!
//        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        updateEditView(temp);

    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore string literal from Bundle saveInstanceState
        temp = savedInstanceState.getString(EDIT_VIEW_KEY);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        // Save state of the activity
        outState.putString(EDIT_VIEW_KEY, text_box.getText().toString());


        super.onSaveInstanceState(outState);

    }
}
