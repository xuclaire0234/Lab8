package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){
        return cities.size();
    }

    public void addCity(City city){
        cities.add(city);

    }

    /**
     * This function return boolean to check if the list contains the given city.
     * @param city this is a candidate city to add which is of type is {@link City}
     * @return boolean
     */
    public boolean hasCity(City city) {
        if (cities.contains(city)) {
            return true;
        }
        return false;
    }

    /**
     * This function is to delete the given city from the list
     * @param city this is a candidate city to add which is of type is {@link City}
     * @throws IllegalArgumentException if given city is not is list
     */
    public void delete(City city){
        if(!cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This function return a integer which represent how many city (cities) in the list
     * @return int
     */
    public int countCity(){
        int count = 0;
        if(cities.isEmpty()){
            return count;
        }
        for (int i = 0; i < cities.size(); i++) {
            count += 1;
        }
        return count;
    }

}
