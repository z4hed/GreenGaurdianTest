package customClasses;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.testapplication.R;

import java.util.ArrayList;

import Models.profile;

//public class customAdapter {
//    private ArrayList<profile> dataSet;
//    Context hereContext;
//
//    public customAdapter(ArrayList<profile> data, Context context) {
//        super(context, R.layout.profile_item,data);
//        this.dataSet = data;
//        this.hereContext = context;
//    }
//
//    private static class ViewHolder {
//        TextView txtName;
//        TextView txtSurname;
//    }
//
//    @Override
//    public void onClick(View view) {
//        Log.d("customAdapter", "onClick: clicked!");
//        profile thisProfile = (profile) view.getTag(R.id.profile_tag);
//        // Create an Intent to start the ProfileDetailsActivity
//        Intent intent = new Intent(hereContext, ProfileDetailsActivity.class);
//        // Pass the profile data as an extra to the intent
//        intent.putExtra("profile",thisProfile);
//        hereContext.startActivity(intent);
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        // Get the data item for this position
//        profile hereProfile = getItem(position);
//        ViewHolder viewHolder;
//
//        final View result;
//
//        if (convertView == null) {
//            viewHolder = new ViewHolder();
//            LayoutInflater inflater = LayoutInflater.from(getContext());
//            convertView = inflater.inflate(R.layout.profile_item, parent, false);
//            viewHolder.txtName = convertView.findViewById(R.id.name);
//            viewHolder.txtSurname = convertView.findViewById(R.id.surname);
//
//            result = convertView;
//
//            convertView.setTag(viewHolder);
//            convertView.setTag(R.id.profile_tag, hereProfile);
//            convertView.setOnClickListener(this);
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//            result = convertView;
//        }
//
//        viewHolder.txtName.setText(hereProfile.getName());
//        viewHolder.txtSurname.setText(hereProfile.getSurname());
//
//        // Return the completed view to render on screen
//        return convertView;
//    }
//}
