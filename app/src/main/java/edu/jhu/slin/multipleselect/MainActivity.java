package edu.jhu.slin.multipleselect;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {
    private Item[] items;

    private ItemAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create toy data
        items = new Item[5];
        items[0] = new Item(1, "One", false);
        items[1] = new Item(2, "Two", true);
        items[2] = new Item(3, "Three", true);
        items[3] = new Item(4, "Bar", false);
        items[4] = new Item(5, "Foo", true);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        adapter = new ItemAdapter(this, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showToast("You clicked position: " + position);
                adapter.toggle(position);
            }
        });
    }

    public void onClickShowSelected(View view) {
        Integer[] ids = adapter.getCheckedItemId();
        showToast("Selected: " + Arrays.deepToString(ids));
    }

    private void showToast(String message) {
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), message, duration);
        toast.show();
    }

    private class ItemAdapter extends ArrayAdapter<Item> {
        private Item[] items;

        public ItemAdapter(Context context, Item[] items) {
            super(context, R.layout.item, items);
            this.items = items;

        }

        public void toggle(int position) {
            if (items[position].isChecked()) {
                items[position].setChecked(false);
            } else {
                items[position].setChecked(true);
            }
        }

        public Integer[] getCheckedItemId() {
            List<Integer> idList = new ArrayList<Integer>();
            for (Item i : items) {
                if (i.isChecked()) {
                    idList.add(i.getId());
                }
            }
            Integer[] ids = new Integer[idList.size()];
            idList.toArray(ids);
            return ids;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                v = getLayoutInflater().inflate(R.layout.item, parent, false);
            }
            CheckedTextView ctx = (CheckedTextView) v.findViewById(R.id.checkedTextView);
            ctx.setText(items[position].getName());
            ((ListView) parent).setItemChecked(position, items[position].isChecked());
            return v;
        }
    }

}


