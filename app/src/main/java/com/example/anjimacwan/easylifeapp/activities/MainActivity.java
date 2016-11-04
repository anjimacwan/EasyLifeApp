package com.example.anjimacwan.easylifeapp.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.anjimacwan.easylifeapp.R;
import com.example.anjimacwan.easylifeapp.fragments.NoteLinedEditorFragment;
import com.example.anjimacwan.easylifeapp.fragments.NotePlainEditorFragment;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.materialdrawer.util.KeyboardUtil;

public class MainActivity extends AppCompatActivity implements NoteLinedEditorFragment.OnFragmentInteractionListener, NotePlainEditorFragment.OnFragmentInteractionListener{

    private Toolbar mToolbar;
    private com.mikepenz.materialdrawer.Drawer result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        if (savedInstanceState == null){
            NotePlainEditorFragment fragment = new NotePlainEditorFragment();
            openFragment(fragment, "Note Editor");
        }

        //Now build the navigation drawer and pass the AccountHeader
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .withActionBarDrawerToggle(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.title_home).withIcon(FontAwesome.Icon.faw_home).withIdentifier(1),
                        new PrimaryDrawerItem().withName("Editor").withIcon(FontAwesome.Icon.faw_sticky_note).withIdentifier(2),
                        new PrimaryDrawerItem().withName("Settings").withIcon(FontAwesome.Icon.faw_list).withIdentifier(3)

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int i, IDrawerItem drawerItem) {
                        if (drawerItem != null && drawerItem instanceof Nameable){
                            String name = ((Nameable)drawerItem).getName().getText(MainActivity.this);
                            mToolbar.setTitle(name);
                        }

                        if (drawerItem != null){
                            int selectedScren = drawerItem.getIdentifier();
                            switch (selectedScren){
                                case 1:
                                    //do nothing
                                    break;
                                case 2:
                                    NotePlainEditorFragment fragment = new NotePlainEditorFragment();
                                    openFragment(fragment, "Note Editor");
                                    break;
                                case 3:
                                    //go to settings screen, yet to be added
                                    //this will be your home work
                                    Toast.makeText(MainActivity.this, "Settings Clicked", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                        return false;
                    }


                })
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View view) {
                        KeyboardUtil.hideKeyboard(MainActivity.this);

                    }

                    @Override
                    public void onDrawerClosed(View view) {

                    }

                    @Override
                    public void onDrawerSlide(View view, float v) {

                    }
                })
                .withFireOnInitialOnClick(true)
                .withSavedInstance(savedInstanceState)
                .build();
        if (savedInstanceState == null){
            NoteLinedEditorFragment fragment = new NoteLinedEditorFragment();
            openFragment(fragment, "Note Editor");
        }
    }

    private void openFragment(final Fragment fragment, String title){
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.notepad_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.create:
                return true;
            case R.id.shoplist:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openNotepad(View view)
    {
        Intent intent = new Intent(this,Notepad.class);
        startActivity(intent);
    }

    public void openNavigation(View view)
    {
        Intent intent = new Intent(this,Navigation.class);
        startActivity(intent);
    }

    public void openMoneyTracker(View view)
    {
        Intent intent = new Intent(this,MoneyTracker.class);
        startActivity(intent);
    }

    public void openReminder(View view)
    {
        Intent intent = new Intent(this,Reminder.class);
        startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
